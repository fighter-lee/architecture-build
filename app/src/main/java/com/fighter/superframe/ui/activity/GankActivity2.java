package com.fighter.superframe.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.fighter.superframe.R;
import com.fighter.superframe.ui.adapter.GankAdapter;
import com.fighter.superframe.ui.base.BaseActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;

public class GankActivity2 extends BaseActivity {


    public static final String GANK_DESC_CONTENT = "gank_desc_content";
    public static final String GANK_DATA = "gank_data";
    @BindView(R.id.gank_toolbar)
    Toolbar gankToolbar;
    @BindView(R.id.gank_toolbar_layout)
    CollapsingToolbarLayout gankToolbarLayout;
    @BindView(R.id.gank_app_bar)
    AppBarLayout gankAppBar;
    @BindView(R.id.rv_gank)
    RecyclerView rvGank;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    @BindView(R.id.gank_fab)
    FloatingActionButton gankFab;
    @BindView(R.id.imageview)
    ImageView imageview;
    @BindView(R.id.gank_playButton)
    ButtonBarLayout gankPlayButton;
    private static final String TAG = "GankActivity2";
    private CollapsingToolbarLayoutState state;
    private String mTitle = "";
    private Date mDate;

    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        getDataAndTitle();
        super.onCreate(savedInstanceState);
    }

    private void getDataAndTitle() {
        Intent intent = getIntent();
        String desc = intent.getStringExtra(GANK_DESC_CONTENT);
        String dateAll = intent.getStringExtra(GANK_DATA);
        mTitle = desc;
        String date = dateAll.substring(0, "2017-09-20".length());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            mDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化 Toolbar
     */
    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initToolBar(gankToolbar, true, "");
        GankAdapter gankAdapter = new GankAdapter();
        rvGank.setLayoutManager(new LinearLayoutManager(this));
        rvGank.setAdapter(gankAdapter);
        gankFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        gankAppBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    if (state != CollapsingToolbarLayoutState.EXPANDED) {
                        state = CollapsingToolbarLayoutState.EXPANDED;//修改状态标记为展开
                        gankToolbarLayout.setTitle(mTitle);//设置title为EXPANDED
                    }
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    if (state != CollapsingToolbarLayoutState.COLLAPSED) {
                        gankToolbarLayout.setTitle("");//设置title不显示
                        gankPlayButton.setVisibility(View.VISIBLE);//隐藏播放按钮
                        state = CollapsingToolbarLayoutState.COLLAPSED;//修改状态标记为折叠
                    }
                } else {
                    if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
                        if (state == CollapsingToolbarLayoutState.COLLAPSED) {
                            gankPlayButton.setVisibility(View.GONE);//由折叠变为中间状态时隐藏播放按钮
                        }
                        gankToolbarLayout.setTitle(mTitle);
                        state = CollapsingToolbarLayoutState.INTERNEDIATE;//修改状态标记为中间
                    }
                }

            }
        });
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_gank2;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
