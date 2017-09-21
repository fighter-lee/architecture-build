package com.fighter.superframe.ui.fragment;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.adups.trace.Trace;
import com.fighter.superframe.Network.Network;
import com.fighter.superframe.R;
import com.fighter.superframe.constant.GankType;
import com.fighter.superframe.info.GankInfo;
import com.fighter.superframe.ui.activity.PhotoActivity;
import com.fighter.superframe.ui.adapter.MeizhiListAdapter;
import com.fighter.superframe.ui.base.SwipeRefreshBaseFragment;
import com.fighter.superframe.ui.view.SpacesItemDecoration;

import java.util.ArrayList;

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
            public void onClick(GankInfo.ResultsBean info) {
                Intent intent = new Intent(getActivity(), PhotoActivity.class);
                Trace.d(TAG, "onClick() " + info.getUrl());
                intent.putExtra(PhotoActivity.PHOTO_URL, info.getUrl());
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

        Observable<GankInfo> shipingObserable = Network.getGankApi().getGankInfo(GankType.TYPE_SHIPING,"10",String.valueOf(mPage))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observable<GankInfo> fuliObserable = Network.getGankApi().getGankInfo(GankType.TYPE_FULI,"10",String.valueOf(mPage))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observable.zip(shipingObserable, fuliObserable, new BiFunction<GankInfo, GankInfo, ArrayList<GankInfo.ResultsBean>>() {
            @Override
            public ArrayList<GankInfo.ResultsBean> apply(GankInfo gankInfo, GankInfo gankInfo2) throws Exception {
                ArrayList<GankInfo.ResultsBean> resultsBeans = new ArrayList<>();
                resultsBeans.addAll(gankInfo.getResults());
                resultsBeans.addAll(gankInfo2.getResults());
                return resultsBeans;
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ArrayList<GankInfo.ResultsBean>>() {
                    @Override
                    public void accept(ArrayList<GankInfo.ResultsBean> resultsBeans) throws Exception {
                        if (clear){
                            data_list.clear();
                        }
                        data_list.addAll(resultsBeans);
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

}
