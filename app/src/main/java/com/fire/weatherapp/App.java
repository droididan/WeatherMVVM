package com.fire.weatherapp;

import android.app.Application;
import com.fire.weatherapp.di.app.AppComponent;
import com.fire.weatherapp.di.app.AppModule;
import com.fire.weatherapp.di.app.DaggerAppComponent;
import com.fire.weatherapp.di.app.NetworkModule;

/**
 * Created by idan on 28/01/2017.
 */

public class App extends Application {

  AppComponent appComponent;

  @Override public void onCreate() {
    super.onCreate();
    initInjector();
  }

  private void initInjector() {
    appComponent = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .networkModule(new NetworkModule())
        .build();
  }

  public AppComponent getAppComponent() {
    return appComponent;
  }
}