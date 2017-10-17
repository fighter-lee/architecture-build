package com.fighter.superframe.ui.expandRecyclerview;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by fighter_lee on 2017/10/16.
 */

public class GroupBean extends ExpandableGroup<ChildBean> {

    public GroupBean(String title, List<ChildBean> items) {
        super(title, items);
    }
}