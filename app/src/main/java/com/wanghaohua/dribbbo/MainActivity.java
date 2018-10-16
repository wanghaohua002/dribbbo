package com.wanghaohua.dribbbo;

import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.wanghaohua.dribbbo.bucketlist.BucketListFragment;
import com.wanghaohua.dribbbo.shotlist.ShotListFragment;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.toolbar) Toolbar mToolbar;
  @BindView(R.id.drawer_layout) DrawerLayout mDrawerLayout;
  @BindView(R.id.navigation_view) NavigationView mNavigationView;

  private ActionBarDrawerToggle mDrawerToggle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);

    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction()
          .add(R.id.fl_container, ShotListFragment.newInstance())
          .commit();
    }

    initDrawer();
  }

  @Override
  protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    mDrawerToggle.syncState();
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    mDrawerToggle.onConfigurationChanged(newConfig);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (mDrawerToggle.onOptionsItemSelected(item)) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private void initDrawer() {
    mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open_drawer,
        R.string.close_drawer);
    mDrawerLayout.addDrawerListener(mDrawerToggle);

    View headerView = mNavigationView.getHeaderView(0);
    //Glide.with(this)
    //    .load(DribbboManager.getAvatar())
    //    .apply(RequestOptions.circleCropTransform())
    //    .into((ImageView) headerView.findViewById(R.id.iv_avatar));
    ImageView ivAvatar = headerView.findViewById(R.id.iv_avatar);
    ivAvatar.setImageResource(R.mipmap.ic_launcher);

    TextView username = headerView.findViewById(R.id.tv_username);
    //username.setText(DribbboManager.getUsername());
    username.setText("test username");

    TextView logout = headerView.findViewById(R.id.tv_logout);
    //logout.setOnClickListener(new View.OnClickListener() {
    //  @Override
    //  public void onClick(View v) {
    //    LoginActivity.start(MainActivity.this);
    //  }
    //});

    mNavigationView.setNavigationItemSelectedListener(
        new NavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            mDrawerLayout.closeDrawers();
            if (item.isChecked()) {
              return true;
            }
            Fragment fragment = null;
            switch (item.getItemId()) {
              case R.id.drawer_item_home:
                fragment = ShotListFragment.newInstance();
                setTitle(R.string.title_home);
                break;
              case R.id.drawer_item_like:
                fragment = ShotListFragment.newInstance();
                setTitle(R.string.title_likes);
                break;
              case R.id.drawer_item_buckets:
                fragment = BucketListFragment.newInstance();
                setTitle(R.string.title_buckets);
                break;
            }
            if (fragment != null) {
              getSupportFragmentManager().beginTransaction()
                  .replace(R.id.fl_container, fragment)
                  .commit();
              return true;
            }
            return false;
          }
        });
  }
}
