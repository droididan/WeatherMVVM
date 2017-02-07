package com.fire.weatherapp.view.weather;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fire.weatherapp.App;
import com.fire.weatherapp.R;
import com.fire.weatherapp.databinding.FragmentWeatherBinding;
import com.fire.weatherapp.di.weather.DaggerWeatherComponent;
import com.fire.weatherapp.di.weather.WeatherModule;
import com.fire.weatherapp.viewmodel.weather.WeatherViewModel;
import javax.inject.Inject;

/**
 * Created by idan on 28/01/2017.
 */
public class WeatherFragment extends Fragment {

  FragmentWeatherBinding binding;

  @Inject WeatherViewModel viewModel;

  public static Fragment getInstance() {
    return new WeatherFragment();
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather, container, false);
    initInjectors();
    binding.setViewModel(viewModel);

    return binding.getRoot();
  }

  private void initInjectors() {
    DaggerWeatherComponent.builder()
        .appComponent(((App) getActivity().getApplicationContext()).getAppComponent())
        .weatherModule(new WeatherModule())
        .build()
        .inject(this);
  }
}
