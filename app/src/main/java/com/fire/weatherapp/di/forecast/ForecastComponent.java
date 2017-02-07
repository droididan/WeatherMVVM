package com.fire.weatherapp.di.forecast;

import com.fire.weatherapp.di.app.AppComponent;
import com.fire.weatherapp.di.scopes.Fragment;
import com.fire.weatherapp.view.forecast.ForecastFragment;
import dagger.Component;

/**
 * Created by idan on 05/02/2017.
 */

@Fragment @Component(dependencies = AppComponent.class, modules = ForecastModule.class)
public interface ForecastComponent {
  void inject(ForecastFragment fragment);
}
