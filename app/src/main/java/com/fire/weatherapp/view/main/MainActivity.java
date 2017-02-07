package com.fire.weatherapp.view.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.fire.weatherapp.App;
import com.fire.weatherapp.R;
import com.fire.weatherapp.databinding.ActivityMainBinding;
import com.fire.weatherapp.di.main.DaggerMainComponent;
import com.fire.weatherapp.di.main.MainModule;
import com.fire.weatherapp.view.forecast.ForecastFragment;
import com.fire.weatherapp.view.weather.WeatherFragment;
import com.fire.weatherapp.viewmodel.main.MainViewModel;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainViewModel.MainListener {

  @Inject MainViewModel mainViewModel;
  ActivityMainBinding binding;
  private int pos;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    initInjector();
    initViews();
  }

  private void initViews() {
    setSupportActionBar(binding.toolbarInclude.toolbar);
    binding.setViewModel(mainViewModel);
    PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
    adapter.addFragment(WeatherFragment.getInstance());
    adapter.addFragment(ForecastFragment.getInstance());
    binding.pager.setAdapter(adapter);
  }

  private void initInjector() {
    DaggerMainComponent.builder()
        .appComponent(((App) getApplicationContext()).getAppComponent())
        .mainModule(new MainModule(this))
        .build()
        .inject(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    mainViewModel.unsubscribe();
  }

  @Override public void updateToolbarTitle(String title) {
    binding.toolbarInclude.toolbar.setTitle(title);
  }
}