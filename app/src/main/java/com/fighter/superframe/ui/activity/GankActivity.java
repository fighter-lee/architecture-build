package com.fighter.superframe.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.VideoView;

import com.fighter.superframe.R;
import com.fighter.superframe.ui.adapter.GankAdapter;
import com.fighter.superframe.ui.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by fighter_lee on 2017/9/22.
 */

public class GankActivity extends BaseActivity {
    public static final String PUBLISH_DATE = "publish_date";
    @BindView(R.id.imageview)
    ImageView imageview;
    @BindView(R.id.videoview)
    VideoView videoview;
    @BindView(R.id.video_danmu)
    FrameLayout videoDanmu;
    @BindView(R.id.playButton)
    ButtonBarLayout playButton;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.rv_gank)
    RecyclerView rvGank;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;


    @Override
    protected void initView(Bundle savedInstanceState) {
        GankAdapter gankAdapter = new GankAdapter();
        rvGank.setLayoutManager(new LinearLayoutManager(this));
        rvGank.setAdapter(gankAdapter);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_gank;
    }

}
