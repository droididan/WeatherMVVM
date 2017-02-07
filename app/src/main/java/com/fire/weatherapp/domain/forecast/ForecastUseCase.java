package com.fire.weatherapp.domain.forecast;

import com.fire.weatherapp.model.api.pojo.Coord;
import com.fire.weatherapp.model.api.pojo.ForecastResponse;
import rx.Observable;

/**
 * Created by idan on 05/02/2017.
 */

public interface ForecastUseCase {
  Observable<ForecastResponse> getForecast(Coord coord);
}
