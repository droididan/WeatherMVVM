package com.fire.weatherapp.di.weather;

import com.fire.weatherapp.di.app.AppComponent;
import com.fire.weatherapp.di.scopes.Fragment;
import com.fire.weatherapp.view.weather.WeatherFragment;
import dagger.Component;

/**
 * Created by idan on 28/01/2017.
 */

@Fragment @Component(dependencies = AppComponent.class, modules = WeatherModule.class)
public interface WeatherComponent {
  void inject(WeatherFragment weatherFragment);
}
