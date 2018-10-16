package com.wanghaohua.dribbbo.shotlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.wanghaohua.dribbbo.R;
import com.wanghaohua.dribbbo.model.Shot;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 创建时间: 2018/10/15 16:07
 * 作者: wanghaohua
 * 描述:
 */
public class ShotListFragment extends Fragment {

  @BindView(R.id.recycler_view) RecyclerView mRecyclerView;

  public static ShotListFragment newInstance() {
    return new ShotListFragment();
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_shot_list, container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    mRecyclerView.addItemDecoration(new SpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.space)));
    mRecyclerView.setAdapter(new ShotListAdapter(mockData()));
  }

  private List<Shot> mockData() {
    List<Shot> shots = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < 30; i++) {
      Shot shot = new Shot();
      shot.buckets_count = random.nextInt(1000);
      shot.likes_count = random.nextInt(1000);
      shot.views_count = random.nextInt(1000);
      shots.add(shot);
    }
    return shots;
  }
}
