package com.fighter.superframe.ui.activity;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
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

    @BindView(R.id.id_tool_bar)
    Toolbar idToolBar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.home_viewPager)
    ViewPager homeViewPager;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private MainPresenterImpl presenter;
    private static final String TAG = "MainActivity";

    @Override
    protected void initView(Bundle savedInstanceState) {

        new MainPresenterImpl(this, this);
        presenter.start();
        initToolBar(idToolBar,false,"gank");
        MeiziViewpageAdapter viewpageAdapter = new MeiziViewpageAdapter(getSupportFragmentManager());
        viewpageAdapter.addFragment(new MeiziFragment());
        homeViewPager.setAdapter(viewpageAdapter);


    }

    /**
     * 初始化 Toolbar
     */
    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
        toolbar.setNavigationIcon(R.mipmap.ic_github);
        toolbar.inflateMenu(R.menu.main_menu);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_check_up:
                return true;
            case R.id.menu_about:
                return true;

            case R.id.change_view:
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
