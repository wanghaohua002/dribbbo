package com.wanghaohua.dribbbo.shotlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.wanghaohua.dribbbo.R;
import com.wanghaohua.dribbbo.model.Shot;
import java.util.List;

/**
 * 创建时间: 2018/10/15 16:35
 * 作者: wanghaohua
 * 描述:
 */
public class ShotListAdapter extends RecyclerView.Adapter {

  public List<Shot> mData;

  public ShotListAdapter(List<Shot> data) {
    mData = data;
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shot, parent, false);
    return new ShotViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    Shot shot = mData.get(position);
    ShotViewHolder shotViewHolder = (ShotViewHolder) holder;
    shotViewHolder.likeCount.setText(String.valueOf(shot.likes_count));
    shotViewHolder.viewCount.setText(String.valueOf(shot.views_count));
    shotViewHolder.bucketCount.setText(String.valueOf(shot.buckets_count));
    shotViewHolder.image.setBackgroundResource(R.color.color_33000000);
  }

  @Override
  public int getItemCount() {
    return mData.size();
  }

  public class ShotViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_like_count) public TextView likeCount;
    @BindView(R.id.tv_bucket_count) public TextView bucketCount;
    @BindView(R.id.tv_view_count) public TextView viewCount;
    @BindView(R.id.iv_preview) public ImageView image;

    public ShotViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
