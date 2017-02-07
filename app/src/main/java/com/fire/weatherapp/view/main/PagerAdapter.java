package com.fire.weatherapp.view.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by idan on 28/01/2017.
 * Pager Adapter
 */
class PagerAdapter extends FragmentPagerAdapter {
  private final List<Fragment> fragments = new ArrayList<>();

  PagerAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override public Fragment getItem(int position) {
    return fragments.get(position);
  }

  @Override public int getCount() {
    return fragments.size();
  }

  void addFragment(Fragment fragment) {
    fragments.add(fragment);
  }
}