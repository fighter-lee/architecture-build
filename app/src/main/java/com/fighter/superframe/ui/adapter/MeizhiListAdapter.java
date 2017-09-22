package com.fighter.superframe.ui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.adups.trace.Trace;
import com.bumptech.glide.Glide;
import com.fighter.superframe.R;
import com.fighter.superframe.info.GankInfo;
import com.fighter.superframe.utils.ScreenUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fighter_lee on 2017/8/8.
 */

public class MeizhiListAdapter extends RecyclerView.Adapter<MeizhiListAdapter.MyViewHolder> {

    private static final String TAG = "MeizhiListAdapter";
    private Context mCx;
    private List<GankInfo.ResultsBean> meiziInfo;
    private OnItemClickListener listener;

    public void setData(List<GankInfo.ResultsBean> meiziInfo) {
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
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Glide.with(mCx)
                .load(meiziInfo.get(position).getUrl())
                .centerCrop()
                .into(holder.meiziView);
        holder.tvDesc.setText(meiziInfo.get(position).getDesc());
        holder.meiziView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    listener.onPicClick(meiziInfo.get(position));
                }
            }
        });
        holder.tvDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    listener.onTextClick(meiziInfo.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return meiziInfo == null ? 0 : meiziInfo.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.meizi_view)
        ImageView meiziView;
        @BindView(R.id.meizhi_card)
        CardView meizhiCard;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.meizi_item_rl)
        RelativeLayout meiziItemRl;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            ViewGroup.LayoutParams params = meiziView.getLayoutParams();
            int width = (ScreenUtil.getScreenWidth(mCx) - 4) / 2;
            params.height = (int) (width * 1.2);
            meiziView.setLayoutParams(params);
            Trace.d(TAG, "MyViewHolder() " + meiziView.getHeight() + "," + meiziView.getWidth());
        }

    }

    public interface OnItemClickListener {
        void onPicClick(GankInfo.ResultsBean info);

        void onTextClick(GankInfo.ResultsBean info);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
