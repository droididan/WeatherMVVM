package com.fire.weatherapp.model.api.rest;

import com.fire.weatherapp.model.api.pojo.ForecastResponse;
import com.fire.weatherapp.model.api.pojo.WeatherResponse;
import retrofit2.Retrofit;
import rx.Observable;

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

  @Override public Observable<ForecastResponse> getForecast(double latitude, double longitude,
      String appId, String units, String lang) {
    return weatherService.getForecast(latitude, longitude, 5, appId, units);
  }
}