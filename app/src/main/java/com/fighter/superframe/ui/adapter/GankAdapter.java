package com.fighter.superframe.ui.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.HashMap;
import java.util.List;

/**
 * Created by fighter_lee on 2017/9/22.
 */

public class GankAdapter extends ExpandableRecyclerViewAdapter<GankAdapter.GroupViewHolder,GankAdapter.ChildViewHolder> {


    private HashMap<String, Object> data = new HashMap<>();

    public GankAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public GroupViewHolder onCreateGroupViewHolder(ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(viewGroup.getContext())
//                .inflate(R.layout.list_item_group, viewGroup, false);
        return null;
    }

    @Override
    public ChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder childViewHolder, int i, ExpandableGroup expandableGroup, int i1) {

    }

    @Override
    public void onBindGroupViewHolder(GroupViewHolder groupViewHolder, int i, ExpandableGroup expandableGroup) {

    }

    public void setDate(HashMap<String, Object> map) {
        this.data = map;
        notifyDataSetChanged();
    }

    public class GroupViewHolder extends com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder {
        public GroupViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class ChildViewHolder extends com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder {
        public ChildViewHolder(View itemView) {
            super(itemView);
        }
    }
}
