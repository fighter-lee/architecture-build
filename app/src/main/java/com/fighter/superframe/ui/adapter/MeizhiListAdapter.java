package com.fighter.superframe.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.fighter.superframe.R;
import com.fighter.superframe.info.ImageInfo;
import com.fighter.superframe.utils.ScreenUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fighter_lee on 2017/8/8.
 */

public class MeizhiListAdapter extends RecyclerView.Adapter<MeizhiListAdapter.MyViewHolder> {

    private static final String TAG = "MeizhiListAdapter";
    private Context mCx;
    private List<ImageInfo.ResultsBean> meiziInfo;
    private OnItemClickListener listener;

    public void setData(List<ImageInfo.ResultsBean> meiziInfo) {
        this.meiziInfo = meiziInfo;
        this.notifyDataSetChanged();
    }

    public MeizhiListAdapter(Context context) {
        this.mCx = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_meizhi, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(mCx)
                .load(meiziInfo.get(position).getUrl())
                .centerCrop()
                .into(holder.meiziView);
    }

    @Override
    public int getItemCount() {
        return meiziInfo == null ? 0 : meiziInfo.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.meizi_view)
        ImageView meiziView;
        @BindView(R.id.meizhi_card)
        LinearLayout meizhiCard;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            ViewGroup.LayoutParams params = meiziView.getLayoutParams();
            params.width = (ScreenUtil.getScreenWidth(mCx) - 4) / 2;
            params.height = (int) (params.width * 1.2);
            meiziView.setLayoutParams(params);
        }

        @OnClick(R.id.meizi_view)
        public void onViewClicked() {
            if (null != listener){

            }
        }
    }
    interface OnItemClickListener{
        void onClick();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
