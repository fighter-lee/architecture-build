package com.fighter.superframe.ui.fragment;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;

import com.adups.trace.Trace;
import com.fighter.superframe.Network.Network;
import com.fighter.superframe.R;
import com.fighter.superframe.constant.GankType;
import com.fighter.superframe.info.GankInfo;
import com.fighter.superframe.ui.activity.GankActivity2;
import com.fighter.superframe.ui.activity.PhotoActivity;
import com.fighter.superframe.ui.adapter.MeizhiListAdapter;
import com.fighter.superframe.ui.base.SwipeRefreshBaseFragment;
import com.fighter.superframe.ui.view.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fighter_lee on 2017/8/8.
 */

public class MeiziFragment extends SwipeRefreshBaseFragment {
    private static final String TAG = "MeiziFragment";
    private static final int PRELOAD_SIZE = 6;
    @BindView(R.id.list)
    RecyclerView list;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private MeizhiListAdapter adapter;
    private int mPage = 1;
    private ArrayList<GankInfo.ResultsBean> data_list = new ArrayList<>();
    private StaggeredGridLayoutManager layoutManager;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_meizi;
    }

    @Override
    protected void init() {
        Trace.d(TAG, "init() ");
        setSwipeRefreshView(swipeRefreshLayout);
        layoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        list.setLayoutManager(layoutManager);
        adapter = new MeizhiListAdapter(getActivity());
        list.setAdapter(adapter);
        list.setHasFixedSize(true);
        SpacesItemDecoration decoration = new SpacesItemDecoration(30);
        list.addItemDecoration(decoration);
        list.addOnScrollListener(getOnBottomListener(layoutManager));
        requestData(true);

        adapter.setOnItemClickListener(new MeizhiListAdapter.OnItemClickListener() {
            @Override
            public void onPicClick(GankInfo.ResultsBean info) {
                Intent intent = new Intent(getActivity(), PhotoActivity.class);
                intent.putExtra(PhotoActivity.PHOTO_URL, info.getUrl());
                getActivity().startActivity(intent);
            }

            @Override
            public void onTextClick(GankInfo.ResultsBean info) {
                Intent intent = new Intent(getActivity(), GankActivity2.class);
                intent.putExtra(GankActivity2.GANK_DESC_CONTENT, info.getDesc());
                intent.putExtra(GankActivity2.GANK_DATA,info.getPublishedAt()==null?info.getCreatedAt():info.getPublishedAt());
                getActivity().startActivity(intent);
            }

        });
    }

    @Override
    public void requestDataRefresh() {
        super.requestDataRefresh();
        Trace.d(TAG, "requestDataRefresh() ");
        mPage = 1;
        requestData(true);
    }

    private RecyclerView.OnScrollListener getOnBottomListener(final StaggeredGridLayoutManager layoutManager) {
        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                boolean isBottom =
                        layoutManager.findLastCompletelyVisibleItemPositions(new int[2])[1] >=
                                adapter.getItemCount() - PRELOAD_SIZE;
                if (!swipeRefreshLayout.isRefreshing() && isBottom) {
                    swipeRefreshLayout.setRefreshing(true);
                    mPage += 1;
                    requestData(false);
                }
            }
        };
    }

    public void requestData(final boolean clear) {

        Observable<GankInfo> shipingObserable = Network.getGankApi().getGankInfo(GankType.TYPE_SHIPING, "10", String.valueOf(mPage))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observable<GankInfo> fuliObserable = Network.getGankApi().getGankInfo(GankType.TYPE_FULI, "10", String.valueOf(mPage))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observable.zip(shipingObserable, fuliObserable, new BiFunction<GankInfo, GankInfo, ArrayList<GankInfo.ResultsBean>>() {
            @Override
            public ArrayList<GankInfo.ResultsBean> apply(GankInfo gankInfo, GankInfo gankInfo2) throws Exception {

                Trace.d(TAG, "apply() " + gankInfo.getResults().size() + "," + gankInfo2.getResults().size());
                return getFuliWith视频desc(gankInfo2, gankInfo);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ArrayList<GankInfo.ResultsBean>>() {
                    @Override
                    public void accept(ArrayList<GankInfo.ResultsBean> resultsBeans) throws Exception {
                        Trace.d(TAG, "accept() " + resultsBeans.size());
                        if (clear) {
                            data_list.clear();
                        }
                        for (GankInfo.ResultsBean resultsBean : resultsBeans) {
                            if (!TextUtils.isEmpty(resultsBean.getUrl())) {
                                data_list.add(resultsBean);
                            }
                        }
                        adapter.setData(data_list);
                        setRefresh(false);
                    }
                });

        /*Observable fuliObservable = Network.getGankApi()
                .getGankInfo(GankType.TYPE_FULI,"10",String.valueOf(mPage))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GankInfo>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onNext(GankInfo gankInfo) {
                        Trace.d(TAG, "onNext() " + gankInfo.getResults().size());
                        if (clear) {
                            data_list.clear();
                        }
                        data_list.addAll(gankInfo.getResults());
                        adapter.setData(data_list);

                        //实现切换
                        //                        if (clear) {
                        //                            if (null != layoutManager) {
                        //                                layoutManager.setSpanCount(2);
                        //                                list.postInvalidate();
                        //                            }
                        //                        } else {
                        //                            if (null != layoutManager) {
                        //                                layoutManager.setSpanCount(1);
                        //                                list.postInvalidate();
                        //                            }
                        //                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Trace.d(TAG, "onError() " + throwable.toString());
                        setRefresh(false);
                    }

                    @Override
                    public void onComplete() {
                        Trace.d(TAG, "onComplete() ");
                        setRefresh(false);
                    }
                });*/


    }

    private ArrayList<GankInfo.ResultsBean> getFuliWith视频desc(GankInfo gankInfo, GankInfo gankInfo2) {
        List<GankInfo.ResultsBean> fuli = gankInfo.getResults();
        List<GankInfo.ResultsBean> shiping = gankInfo2.getResults();
        for (int i = 0; i < fuli.size(); i++) {
            fuli.get(i).setDesc(fuli.get(i).getDesc() + " " +
                    getFirstVideoDesc(fuli.get(i).getPublishedAt(), shiping));
        }
        return (ArrayList<GankInfo.ResultsBean>) fuli;
    }

    int length = "2017-09-21".length();
    private int mLastVideoIndex = 0;

    private String getFirstVideoDesc(String publishedAt, List<GankInfo.ResultsBean> results) {
        String videoDesc = "";
        for (int i = 0; i < results.size(); i++) {
            GankInfo.ResultsBean video = results.get(i);
            if (video.getPublishedAt() == null)
                video.setPublishedAt(video.getCreatedAt());

            if (publishedAt.length() > length &&
                    video.getPublishedAt().length() > length &&
                    TextUtils.equals(publishedAt.substring(0, length), video.getPublishedAt().substring(0, length))) {
                videoDesc = video.getDesc();
                break;
            }
        }
        return videoDesc;
    }


}
