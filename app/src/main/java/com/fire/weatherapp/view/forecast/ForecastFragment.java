package com.fire.weatherapp.view.forecast;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fire.weatherapp.App;
import com.fire.weatherapp.R;
import com.fire.weatherapp.databinding.FragmentForecastBinding;
import com.fire.weatherapp.di.forecast.DaggerForecastComponent;
import com.fire.weatherapp.di.forecast.ForecastModule;
import com.fire.weatherapp.model.api.pojo.ForecastResponse;
import com.fire.weatherapp.viewmodel.forecast.ForecastViewModel;
import javax.inject.Inject;

/**
 * Created by idan on 28/01/2017.
 * Shows weekly weather with adapter and list
 */
public class ForecastFragment extends Fragment implements ForecastViewModel.ForecastListener {

  FragmentForecastBinding binding;

  ForecastAdapter adapter;

  @Inject ForecastViewModel viewModel;

  public static Fragment getInstance() {
    return new ForecastFragment();
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_forecast, container, false);
    initInjectors();
    initViews();
    binding.setViewModel(viewModel);
    return binding.getRoot();
  }

  private void initViews() {
    adapter = new ForecastAdapter();
    binding.list.setLayoutManager(new LinearLayoutManager(getContext()));
    binding.list.setAdapter(adapter);
  }

  private void initInjectors() {
    DaggerForecastComponent.builder()
        .appComponent(((App) getActivity().getApplicationContext()).getAppComponent())
        .forecastModule(new ForecastModule(this))
        .build()
        .inject(this);
  }

  @Override public void onForecastReady(ForecastResponse response) {
    adapter.setItems(response.getForecastList());
  }
}
