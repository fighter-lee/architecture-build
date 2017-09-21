package com.fighter.superframe.ui.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.fighter.superframe.R;
import com.fighter.superframe.utils.ActivityCollector;
import com.umeng.message.PushAgent;

import butterknife.ButterKnife;

/**
 * Created by fighter_lee on 2017/8/8.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PushAgent.getInstance(this).onAppStart();
        ActivityCollector.addActivity(this, getClass());

        initSystemBar();
        if (getContentViewLayoutID() != 0) {
            setContentView(getContentViewLayoutID());
            initView(savedInstanceState);
        }
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
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                //                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
                localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            }
        }
    }

    /**
     * 子类可以重写决定是否使用透明状态栏
     */
    protected boolean translucentStatusBar() {
        return true;
    }

    /**
     * 子类可以重写改变状态栏颜色
     */
    protected int setStatusBarColor() {
        return R.color.colorPrimary;
    }
}
