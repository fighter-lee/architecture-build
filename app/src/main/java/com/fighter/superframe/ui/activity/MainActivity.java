package com.fighter.superframe.ui.activity;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.fighter.superframe.R;
import com.fighter.superframe.presenter.impl.MainPresenterImpl;
import com.fighter.superframe.ui.MainView;
import com.fighter.superframe.ui.adapter.MeiziViewpageAdapter;
import com.fighter.superframe.ui.base.BaseActivity;
import com.fighter.superframe.ui.fragment.MeiziFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainView<MainPresenterImpl> {

    @BindView(R.id.home_viewPager)
    ViewPager homeViewPager;
    @BindView(R.id.fab)
    FloatingActionButton fab;
//    @BindView(R.id.toolbar_title)
//    TextView toolbarTitle;
    @BindView(R.id.home_toolbar)
    Toolbar homeToolbar;
    @BindView(R.id.home_tabLayout)
    TabLayout homeTabLayout;
    private MainPresenterImpl presenter;

    @Override
    protected void initView(Bundle savedInstanceState) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { // 4.4 以上版本
//            // 设置 Toolbar 高度为 80dp，适配状态栏
//            ViewGroup.LayoutParams layoutParams = toolbarTitle.getLayoutParams();
//            //            layoutParams.height = ScreenUtil.dip2px(this,ScreenUtil.getStatusBarHeight(this));
//            layoutParams.height = ScreenUtil.dip2px(this, 80);
//            toolbarTitle.setLayoutParams(layoutParams);
//        }
        initToolBar(homeToolbar, false, "");
        new MainPresenterImpl(this, this);
        presenter.start();

        String[] tilte = {};
        MeiziViewpageAdapter viewpageAdapter = new MeiziViewpageAdapter(getSupportFragmentManager(), tilte);
        viewpageAdapter.addFragment(new MeiziFragment());
        homeViewPager.setAdapter(viewpageAdapter);
        homeTabLayout.setupWithViewPager(homeViewPager);
        if (tilte.length <= 1){
            homeTabLayout.setVisibility(View.GONE);
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
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_login:
                return true;
            case R.id.action_attention:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fab:
                Toast.makeText(this, "xxx", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    @Override
    public void setPresenter(MainPresenterImpl presenter) {
        this.presenter = presenter;
    }

}
