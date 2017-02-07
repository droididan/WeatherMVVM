package com.fire.weatherapp.domain.weather;


import com.fire.weatherapp.model.api.pojo.Coord;
import com.fire.weatherapp.model.api.pojo.WeatherResponse;
import rx.Observable;

/**
 * Created by idan on 28/01/2017.
 */

public interface WeatherUseCase {
  Observable<WeatherResponse> getWeather(Coord cords);
}
