package com.fighter.superframe.ui.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fighter.superframe.R;
import com.fighter.superframe.gloable.MeiziApp;
import com.fighter.superframe.ui.expandRecyclerview.ChildBean;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

/**
 * Created by fighter_lee on 2017/9/22.
 */

public class GankAdapter extends ExpandableRecyclerViewAdapter<GankAdapter.GroupViewHolder, GankAdapter.ChildViewHolder> {

    public GankAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public GroupViewHolder onCreateGroupViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_group, viewGroup, false);
        return new GroupViewHolder(view);
    }

    @Override
    public ChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_gank, viewGroup, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder childViewHolder, int i, ExpandableGroup expandableGroup, int i1) {
        ChildBean childBean = (ChildBean) expandableGroup.getItems().get(i1);
        childViewHolder.tvAuthor.setText(childBean.getAuthor());
        childViewHolder.tvContent.setText(childBean.getDesc());
        if (!TextUtils.isEmpty(childBean.getImageUrl())) {
            Glide.with(MeiziApp.sCx)
                    .load(childBean.getImageUrl())
                    .fitCenter()
                    .into(childViewHolder.ivItemGankImage);
        }
    }

    @Override
    public void onBindGroupViewHolder(GroupViewHolder groupViewHolder, int i, ExpandableGroup expandableGroup) {
        groupViewHolder.tvGroupName.setText(expandableGroup.getTitle());
    }

    public class GroupViewHolder extends com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder {

        @BindView(R.id.tv_group_name)
        TextView tvGroupName;
        @BindView(R.id.iv_group_arrow)
        ImageView arrow;

        public GroupViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void expand() {
            animateExpand();
        }

        @Override
        public void collapse() {
            animateCollapse();
        }

        private void animateExpand() {
            RotateAnimation rotate =
                    new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(300);
            rotate.setFillAfter(true);
            arrow.setAnimation(rotate);
        }

        private void animateCollapse() {
            RotateAnimation rotate =
                    new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(300);
            rotate.setFillAfter(true);
            arrow.setAnimation(rotate);
        }
    }

    public class ChildViewHolder extends com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder {

        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.tv_author)
        TextView tvAuthor;
        @BindView(R.id.iv_item_gank_image)
        ImageView ivItemGankImage;

        public ChildViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
