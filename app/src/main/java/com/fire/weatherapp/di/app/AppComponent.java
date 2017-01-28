package com.fire.weatherapp.di.app;

import com.fire.weatherapp.model.api.rest.ApiSource;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by idan on 28/01/2017.
 */

@Singleton @Component(modules = { AppModule.class, NetworkModule.class })
public interface AppComponent {
  ApiSource apiSource();
}