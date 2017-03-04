package com.fire.weatherapp.model.api.rest;

import com.fire.weatherapp.model.api.pojo.ForecastResponse;
import com.fire.weatherapp.model.api.pojo.WeatherResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by idan on 28/01/2017.
 * Retrofits call service
 */

public interface WeatherService {
  /**
   * Gets 5 days forecast weather
   * @param lat latitude
   * @param lon longitude
   * @param appId token
   * @param units metric

   * @return WeatherResponse object
   */
  @GET("forecast/daily?") Observable<ForecastResponse> getForecast(
      @Query("lat") double lat,
      @Query("lon") double lon,
      @Query("cnt") Integer daysNumber,
      @Query("appid") String appId,
      @Query("units") String units);

  /**
   * Gets today's forecast weather
   * @param lat latitude
   * @param lon longitude
   * @param appId token
   * @param units metric
   * @param lang en
   * @return WeatherResponse object
   */
  @GET("weather?") Observable<WeatherResponse> getWeather(
      @Query("lat") double lat,
      @Query("lon") double lon,
      @Query("appid") String appId,
      @Query("units") String units,
      @Query("lang") String lang);
}