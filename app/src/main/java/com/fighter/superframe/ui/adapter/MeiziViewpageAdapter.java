package com.fighter.superframe.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fighter_lee on 2017/8/8.
 */

public class MeiziViewpageAdapter extends FragmentPagerAdapter {

    private String[] title;
    private List<Fragment> mFragments = new ArrayList<>();

    public MeiziViewpageAdapter(FragmentManager fm, String[] titles) {
        super(fm);
        title = titles;
    }

    public void addFragment(Fragment fragment) {
        mFragments.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (title.length <= 1) {
            return "";
        } else {
            return title[position];
        }
    }
}
