package com.wanghaohua.dribbbo.bucketlist;

import android.media.Image;
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
import com.wanghaohua.dribbbo.model.Bucket;
import java.text.MessageFormat;
import java.util.List;

/**
 * 创建时间: 2018/10/16 12:09
 * 作者: wanghaohua
 * 描述:
 */
public class BucketListAdapter extends RecyclerView.Adapter {
  public List<Bucket> mData;

  public BucketListAdapter(List<Bucket> data) {
    mData = data;
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bucket, parent, false);
    return new BucketViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    Bucket bucket = mData.get(position);
    BucketViewHolder bucketViewHolder = (BucketViewHolder) holder;
    bucketViewHolder.mBucketName.setText(bucket.name);
    bucketViewHolder.mShotCount.setText(MessageFormat.format(
            bucketViewHolder.itemView.getContext().getResources().getString(R.string.shot_count),
            bucket.shots_count));
  }

  @Override
  public int getItemCount() {
    return mData.size();
  }

  public class BucketViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_bucket_name) public TextView mBucketName;
    @BindView(R.id.tv_bucket_shot_count) public TextView mShotCount;
    @BindView(R.id.iv_bucket_checkbox) public ImageView mIvCheckbox;

    public BucketViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
