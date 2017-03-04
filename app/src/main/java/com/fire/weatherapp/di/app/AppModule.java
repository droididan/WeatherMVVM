package com.fire.weatherapp.di.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.fire.weatherapp.common.WeatherBus;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.producers.Produces;
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

  @Provides @Singleton WeatherBus provideBus() {
    return WeatherBus.getInstance();
  }

  @Provides @Singleton Gson provideGson() {
    return new Gson();
  }

  @Provides @Singleton SharedPreferences provideSharedPreferences(Application application) {
    return PreferenceManager.getDefaultSharedPreferences(application);
  }

  //@Provides @Singleton GoogleApiClient providesGoogleApiClient(Context context) {
  //  return new GoogleApiClient.Builder(context).addApi(LocationServices.API).build();
  //}
}
