package com.fire.weatherapp.domain.weather;

import com.fire.weatherapp.model.api.RxTransformer;
import com.fire.weatherapp.model.api.pojo.Coord;
import com.fire.weatherapp.model.api.pojo.WeatherResponse;
import com.fire.weatherapp.model.api.rest.ApiSource;
import javax.inject.Inject;
import rx.Observable;

import static com.fire.weatherapp.common.Consts.APP_ID;
import static com.fire.weatherapp.common.Consts.DEF_LANG;
import static com.fire.weatherapp.common.Consts.DEF_UNIT;

/**
 * Created by idan on 28/01/2017.
 */

public class WeatherUseCaseImpl implements WeatherUseCase {
  private ApiSource apiSource;

  @Inject public WeatherUseCaseImpl(ApiSource apiSource) {
    this.apiSource = apiSource;
  }

  @Override public Observable<WeatherResponse> getWeather(Coord cords) {
    return apiSource.getWeather(cords.getLat(), cords.getLon(), APP_ID, DEF_UNIT, DEF_LANG)
        .compose(RxTransformer.applyIOSchedulers());
  }
}