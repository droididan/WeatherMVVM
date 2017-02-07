package com.fire.weatherapp.di.main;

import com.fire.weatherapp.common.WeatherBus;
import com.fire.weatherapp.di.scopes.Activity;
import com.fire.weatherapp.viewmodel.main.MainViewModel;
import dagger.Module;
import dagger.Provides;

/**
 * Created by idan on 28/01/2017.
 */

@Module public class MainModule {
  private MainViewModel.MainListener listener;

  public MainModule(MainViewModel.MainListener listener) {
    this.listener = listener;
  }

  @Provides @Activity MainViewModel provideMainViewModel(WeatherBus bus) {
    return new MainViewModel(bus, listener);
  }
}
