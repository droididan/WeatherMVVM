package com.fire.weatherapp.model.api.rest;

import android.database.Observable;
import com.fire.weatherapp.model.api.entity.WeatherResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

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
   * @param lang en
   * @return WeatherResponse object
   */
  @GET("forecast?") Observable<WeatherResponse> getForcast(
      @Query("lat") double lat,
      @Query("lon") double lon,
      @Query("appid") String appId,
      @Query("units") String units,
      @Query("lang") String lang);

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