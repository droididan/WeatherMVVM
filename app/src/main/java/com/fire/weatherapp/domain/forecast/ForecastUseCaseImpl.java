package com.fire.weatherapp.domain.forecast;

import com.fire.weatherapp.common.Consts;
import com.fire.weatherapp.model.api.RxTransformer;
import com.fire.weatherapp.model.api.pojo.Coord;
import com.fire.weatherapp.model.api.pojo.ForecastResponse;
import com.fire.weatherapp.model.api.rest.ApiSource;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by idan on 05/02/2017.
 */

public class ForecastUseCaseImpl implements ForecastUseCase {
  private ApiSource apiSource;
  @Inject public ForecastUseCaseImpl(ApiSource apiSource) {
    this.apiSource = apiSource;
  }

  @Override public Observable<ForecastResponse> getForecast(Coord coord) {
    return apiSource.getForecast(coord.getLat(), coord.getLon(), Consts.APP_ID, Consts.DEF_UNIT,
        Consts.DEF_LANG).compose(RxTransformer.applyIOSchedulers());
  }
}