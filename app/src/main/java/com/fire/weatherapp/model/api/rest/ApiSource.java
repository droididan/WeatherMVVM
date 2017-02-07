package com.fire.weatherapp.model.api.rest;

import com.fire.weatherapp.model.api.pojo.ForecastResponse;
import com.fire.weatherapp.model.api.pojo.WeatherResponse;
import rx.Observable;

/**
 * Created by idan on 28/01/2017.
 */

public interface ApiSource {
  Observable<WeatherResponse> getWeather(double latitude, double longitude, String appId,
      String units, String lang);

  Observable<ForecastResponse> getForecast(double latitude, double longitude, String appId,
      String units, String lang);
}
