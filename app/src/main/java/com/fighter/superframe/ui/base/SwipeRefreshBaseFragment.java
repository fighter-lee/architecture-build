package com.fighter.superframe.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.fighter.superframe.R;

/**
 * Created by fighter_lee on 2017/8/8.
 */

public abstract class SwipeRefreshBaseFragment extends BaseFragment {

    private SwipeRefreshLayout swipeRefreshView;
    private boolean mIsRequestDataRefresh = true;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupSwipeRefresh();
    }

    protected void setSwipeRefreshView(SwipeRefreshLayout swipeRefreshView) {
        this.swipeRefreshView = swipeRefreshView;
    }

    private void setupSwipeRefresh() {
        if (swipeRefreshView != null) {
            swipeRefreshView.setColorSchemeResources(R.color.refresh_progress_3,
                    R.color.refresh_progress_2, R.color.refresh_progress_1);
            // Do not use lambda here!
            swipeRefreshView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override public void onRefresh() {
                    requestDataRefresh();
                }
            });
        }
    }

    public void requestDataRefresh() {
        mIsRequestDataRefresh = true;
    }

    public void setRefresh(boolean requestDataRefresh) {
        if (swipeRefreshView == null) {
            return;
        }
        if (!requestDataRefresh) {
            mIsRequestDataRefresh = false;
            // 防止刷新消失太快，让子弹飞一会儿.
            swipeRefreshView.postDelayed(new Runnable() {
                @Override public void run() {
                    if (swipeRefreshView != null) {
                        swipeRefreshView.setRefreshing(false);
                    }
                }
            }, 1000);
        } else {
            swipeRefreshView.setRefreshing(true);
        }
    }
}
