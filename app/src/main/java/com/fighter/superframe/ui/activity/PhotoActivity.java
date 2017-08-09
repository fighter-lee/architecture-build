package com.fighter.superframe.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.fighter.superframe.R;
import com.fighter.superframe.ui.base.BaseActivity;
import com.github.chrisbanes.photoview.PhotoView;

import butterknife.BindView;

/**
 * Created by fighter_lee on 2017/8/9.
 */

public class PhotoActivity extends BaseActivity {
    public static final String PHOTO_URL = "photo_url";
    private static final String TAG = "PhotoActivity";
    @BindView(R.id.picture)
    PhotoView picture;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;

    @Override
    protected void initView(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String url = intent.getStringExtra(PHOTO_URL);
        initToolBar(toolbar, true, "");
        Glide.with(this)
                .load(url)
                .centerCrop()
                .into(picture);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_photo;
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
