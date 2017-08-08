package com.fighter.superframe.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.adups.trace.Trace;
import com.fighter.superframe.Network.Network;
import com.fighter.superframe.R;
import com.fighter.superframe.info.ImageInfo;
import com.fighter.superframe.ui.adapter.MeizhiListAdapter;
import com.fighter.superframe.ui.base.SwipeRefreshBaseFragment;
import com.fighter.superframe.ui.view.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
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
    private List<ImageInfo.ResultsBean> data_list = new ArrayList<>();

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_meizi;
    }

    @Override
    protected void init() {
        Trace.d(TAG, "init() ");
        setSwipeRefreshView(swipeRefreshLayout);
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        list.setLayoutManager(layoutManager);
        adapter = new MeizhiListAdapter(getActivity());
        list.setAdapter(adapter);
        SpacesItemDecoration decoration = new SpacesItemDecoration(30);
        list.addItemDecoration(decoration);
        list.addOnScrollListener(getOnBottomListener(layoutManager));
        requestData(true);
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
        Network.getGankApi()
                .getRxFuli("10", String.valueOf(mPage))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ImageInfo>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        Trace.d(TAG, "onSubscribe() ");
                    }

                    @Override
                    public void onNext(ImageInfo imageInfo) {
                        Trace.d(TAG, "onNext() " + imageInfo.getResults().size());
                        if (clear){
                            data_list.clear();
                        }
                        data_list.addAll(imageInfo.getResults());
                        adapter.setData(data_list);
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
                });
    }

}
