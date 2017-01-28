package com.fire.weatherapp.di.app;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Application Module
 * Created by idan on 28/01/2017.
 */
@Module public class AppModule {
  Application app;

  public AppModule(Application application) {
    this.app = application;
  }

  @Provides @Singleton Application provideApplication() {
    return app;
  }

  @Provides @Singleton Context provideContext() {
    return app.getApplicationContext();
  }
}
