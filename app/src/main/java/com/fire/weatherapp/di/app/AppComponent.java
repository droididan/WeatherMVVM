package com.fire.weatherapp.di.app;

import android.content.SharedPreferences;
import com.fire.weatherapp.common.WeatherBus;
import com.fire.weatherapp.model.api.rest.ApiSource;
import com.google.gson.Gson;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by idan on 28/01/2017.
 */

@Singleton @Component(modules = { AppModule.class, NetworkModule.class })
public interface AppComponent {
  ApiSource apiSource();
  WeatherBus bus();
  Gson gson();
  SharedPreferences sharedPreferences();
}