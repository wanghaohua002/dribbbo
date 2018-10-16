package com.wanghaohua.dribbbo.bucketlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.wanghaohua.dribbbo.R;
import com.wanghaohua.dribbbo.model.Bucket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 创建时间: 2018/10/16 11:37
 * 作者: wanghaohua
 * 描述:
 */
public class BucketListFragment extends Fragment {

  @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
  @BindView(R.id.fab) FloatingActionButton mFab;

  public static BucketListFragment newInstance() {
    return new BucketListFragment();
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_bucket_list, container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
    mRecyclerView.setAdapter(new BucketListAdapter(mockData()));

    mFab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Snackbar.make(mFab, "fab clicked" , Snackbar.LENGTH_LONG).show();
      }
    });
  }

  private List<Bucket> mockData() {
    List<Bucket> buckets = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < 30; i++) {
      Bucket bucket = new Bucket();
      bucket.name = "bucket" + i;
      bucket.shots_count = random.nextInt(10);
      buckets.add(bucket);
    }
    return buckets;
  }
}
