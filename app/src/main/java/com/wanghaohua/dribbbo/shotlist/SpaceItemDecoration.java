package com.wanghaohua.dribbbo.shotlist;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 创建时间: 2018/10/15 16:28
 * 作者: wanghaohua
 * 描述:
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
  private int space;

  public SpaceItemDecoration(int space) {
    this.space = space;
  }

  @Override
  public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
    outRect.left = space;
    outRect.right = space;
    outRect.bottom = space;

    // Add top margin only for the first item to avoid double space between items
    if (parent.getChildAdapterPosition(view) == 0) {
      outRect.top = space;
    }
  }
}
