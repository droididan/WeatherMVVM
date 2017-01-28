package com.fire.weatherapp.model.api.rest;

import android.database.Observable;
import com.fire.weatherapp.model.api.entity.WeatherResponse;

/**
 * Created by idan on 28/01/2017.
 */

public interface ApiSource {
  Observable<WeatherResponse> getWeather(double latitude, double longitude, String appId,
      String units, String lang);

  Observable<WeatherResponse> getForecast(double latitude, double longitude, String appId,
      String units, String lang);
}
