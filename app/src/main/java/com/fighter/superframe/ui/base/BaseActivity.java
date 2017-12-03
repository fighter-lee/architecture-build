package com.fighter.superframe.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fighter.superframe.R;
import com.fighter.superframe.utils.ActivityCollector;
import com.fighter.superframe.utils.SystemBarHelper;

import butterknife.ButterKnife;

/**
 * Created by fighter_lee on 2017/8/8.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this, getClass());

        if (getContentViewLayoutID() != 0) {
            setContentView(getContentViewLayoutID());
            initView(savedInstanceState);
        }
        initSystemBar();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 获取布局ID
     *
     * @return 布局id
     */
    protected abstract int getContentViewLayoutID();


    private void initSystemBar() {
        if (translucentStatusBar()) {
            if (null == getToolbar()) {
                return;
            }
            SystemBarHelper.immersiveStatusBar(this, 0);
            SystemBarHelper.setHeightAndPadding(this, getToolbar());
            return;
        }
        if (tintStatusBar()) {
            SystemBarHelper.tintStatusBar(this, setStatusBarColor(), 0);
            return;
        }

    }

    /**
     * 子类可以重写决定是否使用透明状态栏
     */
    protected boolean translucentStatusBar() {
        return false;
    }

    /**
     * 着色状态栏
     *
     * @return
     */
    protected boolean tintStatusBar() {
        return true;
    }

    /**
     * 获取toolbar
     *
     * @return
     */
    protected View getToolbar() {
        return null;
    }

    /**
     * 子类可以重写改变状态栏颜色
     */
    protected int setStatusBarColor() {
        return getResources().getColor(R.color.colorPrimary);
    }
}
