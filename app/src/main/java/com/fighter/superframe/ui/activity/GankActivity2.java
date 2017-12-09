package com.fighter.superframe.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.adups.trace.Trace;
import com.bumptech.glide.Glide;
import com.fighter.superframe.Network.Network;
import com.fighter.superframe.R;
import com.fighter.superframe.info.GankDateInfo;
import com.fighter.superframe.ui.adapter.DailyAdapter;
import com.fighter.superframe.ui.adapter.GankAdapter;
import com.fighter.superframe.ui.base.BaseActivity;
import com.fighter.superframe.ui.expandRecyclerview.ChildBean;
import com.fighter.superframe.ui.expandRecyclerview.GroupBean;
import com.fighter.superframe.utils.LogUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
    RelativeLayout gankPlayButton;
    private static final String TAG = "GankActivity2";
    private CollapsingToolbarLayoutState state;
    private String mTitle = "";
    private Calendar mDate;
    private GankAdapter gankAdapter;

    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getDataAndTitle();
        super.onCreate(savedInstanceState);
        initView();
        requestData();
    }

    private void initView() {
        DailyAdapter dailyAdapter = new DailyAdapter();
        rvGank.setLayoutManager(new LinearLayoutManager(this));
        rvGank.setAdapter(dailyAdapter);
    }

    private void requestData() {
        Trace.d(TAG, "requestData() " + mDate.get(Calendar.YEAR) + "," + (mDate.get(Calendar.MONTH) + 1) + "," + mDate.get(Calendar.DATE));
        Network.getGankApi().getGankDateInfo(String.valueOf(mDate.get(Calendar.YEAR)),
                String.valueOf(mDate.get(Calendar.MONTH) + 1),
                String.valueOf(mDate.get(Calendar.DATE)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankDateInfo>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onNext(GankDateInfo gankDateInfo) {
                        showView(gankDateInfo);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void showView(GankDateInfo gankDateInfo) {
        GankDateInfo.ResultsBean results = gankDateInfo.getResults();
        if (null != results.get福利()) {
            if (null != results.get福利().get(0)) {
                Glide.with(this)
                        .load(results.get福利().get(0).getUrl())
                        .fitCenter()
                        .into(imageview);
            }
        }

        List<GroupBean> groups = new ArrayList<>();
        for (String s : gankDateInfo.getCategory()) {
            switch (s) {
                case "Android":
                    groups.add(new GroupBean("Android", setChildData(gankDateInfo.getResults().getAndroid())));
                    break;
                case "前端":
                    groups.add(new GroupBean("前端", setChildData(gankDateInfo.getResults().get前端())));
                    break;
                case "iOS":
                    groups.add(new GroupBean("iOS", setChildData(gankDateInfo.getResults().getIOS())));
                    break;
                case "App":
                    groups.add(new GroupBean("App", setChildData(gankDateInfo.getResults().getApp())));
                    break;
                case "瞎推荐":
                    groups.add(new GroupBean("瞎推荐", setChildData(gankDateInfo.getResults().get瞎推荐())));
                    break;
                case "拓展资源":
                    groups.add(new GroupBean("拓展资源", setChildData(gankDateInfo.getResults().get拓展资源())));
                    break;
            }
        }

        gankAdapter = new GankAdapter(groups);
        rvGank.setLayoutManager(new LinearLayoutManager(this));
        rvGank.setAdapter(gankAdapter);
    }

    private List<ChildBean> setChildData(Object o) {
        List<ChildBean> items = new ArrayList<>();
        List<GankDateInfo.Bean> beanList = (List<GankDateInfo.Bean>) o;
        for (GankDateInfo.Bean bean : beanList) {
            ChildBean childBean = new ChildBean();
            if (null != bean.getImages() && !TextUtils.isEmpty(bean.getImages().get(0))) {
                childBean.setImageUrl(bean.getImages().get(0));
            }
            childBean.setAuthor(getAuthorAndTime(bean.getWho(), bean.getPublishedAt(), bean.getCreatedAt()));
            if (!TextUtils.isEmpty(bean.getDesc())) {
                childBean.setDesc(bean.getDesc());
            }
            items.add(childBean);
        }
        return items;
    }

    private String getAuthorAndTime(@Nullable String who, @Nullable String publishedAt, @Nullable String creatAt) {
        StringBuilder builder = new StringBuilder();
        if (!TextUtils.isEmpty(who)) {
            builder.append(who)
                    .append("-");
        }
        if (!TextUtils.isEmpty(publishedAt)) {
            builder.append(publishedAt.substring(0, "2017-08-15".length()));
            return builder.toString();
        }
        if (!TextUtils.isEmpty(creatAt)) {
            builder.append(creatAt.substring(0, "2017-08-15".length()));
            return builder.toString();
        }
        return "";
    }

    private void getDataAndTitle() {
        Intent intent = getIntent();
        String desc = intent.getStringExtra(GANK_DESC_CONTENT);
        String dateAll = intent.getStringExtra(GANK_DATA);
        mTitle = desc;
        String date = dateAll.substring(0, "2017-09-20".length());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            mDate = Calendar.getInstance();
            mDate.setTime(sdf.parse(date));
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

//    @Override
//    protected int setStatusBarColor() {
//        return getResources().getColor(android.R.color.transparent);
//    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initToolBar(gankToolbar, true, "");
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
                        LogUtils.d(TAG,"verticalOffset == 0"+mTitle);;
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
                        LogUtils.d(TAG,"else"+mTitle);
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
