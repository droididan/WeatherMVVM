package com.fire.weatherapp.di.main;

import com.fire.weatherapp.di.app.AppComponent;
import com.fire.weatherapp.di.scopes.Activity;
import com.fire.weatherapp.view.forecast.ForecastFragment;
import com.fire.weatherapp.view.main.MainActivity;
import dagger.Component;

/**
 * Created by idan on 28/01/2017.
 */

@Activity @Component(dependencies = { AppComponent.class }, modules = { MainModule.class })
public interface MainComponent {
  void inject(MainActivity mainActivity);
}
