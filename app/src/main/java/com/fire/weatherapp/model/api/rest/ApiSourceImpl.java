package com.fire.weatherapp.model.api.rest;

import android.database.Observable;
import com.fire.weatherapp.model.api.entity.WeatherResponse;
import retrofit2.Retrofit;

/**
 * Created by idan on 28/01/2017.
 */

public class ApiSourceImpl implements ApiSource {

  private WeatherService weatherService;

  public ApiSourceImpl(Retrofit retrofit) {
    weatherService = retrofit.create(WeatherService.class);
  }

  @Override
  public Observable<WeatherResponse> getWeather(double latitude, double longitude, String appId,
      String units, String lang) {
    return weatherService.getWeather(latitude, longitude, appId, units, lang);
  }

  @Override
  public Observable<WeatherResponse> getForecast(double latitude, double longitude, String appId,
      String units, String lang) {
    return weatherService.getForcast(latitude, longitude, appId, units, lang);
  }
}
