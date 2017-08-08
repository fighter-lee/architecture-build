package com.fighter.superframe.presenter.impl;

import android.content.Context;

import com.adups.trace.Trace;
import com.fighter.superframe.Network.Network;
import com.fighter.superframe.info.AndroidInfo;
import com.fighter.superframe.presenter.MainPresenter;
import com.fighter.superframe.ui.MainView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fighter_lee on 2017/8/8.
 */

public class MainPresenterImpl implements MainPresenter{

    private Context mContext;
    private static final String TAG = "MainPresenterImpl";

    public MainPresenterImpl(MainView view, Context context) {
        this.mContext = context;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        if (!getCacheData()){
            getNetData();
        }
    }

    @Override
    public boolean getCacheData() {
        //TODO 先读缓存
        return false;
    }

    @Override
    public void getNetData() {

    }

    public void getAndroidInfo() {
        Network.getGankApi()
                .getRxAndroidInfo("10","1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AndroidInfo>() {
                    @Override
                    public void accept(AndroidInfo androidInfo) throws Exception {
                        Trace.d(TAG, "accept() :"+androidInfo.getResults().size());
                    }
                });
    }
}
