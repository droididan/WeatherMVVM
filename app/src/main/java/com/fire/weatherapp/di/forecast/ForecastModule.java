package com.fire.weatherapp.di.forecast;

import com.fire.weatherapp.di.scopes.Fragment;
import com.fire.weatherapp.domain.forecast.ForecastUseCase;
import com.fire.weatherapp.domain.forecast.ForecastUseCaseImpl;
import com.fire.weatherapp.model.api.rest.ApiSource;
import com.fire.weatherapp.viewmodel.forecast.ForecastViewModel;
import dagger.Module;
import dagger.Provides;

/**
 * Created by idan on 05/02/2017.
 * Forecast module, we need to init the usecase and the view model.
 */

@Module public class ForecastModule {

  private ForecastViewModel.ForecastListener listener;

  public ForecastModule(ForecastViewModel.ForecastListener listener) {
    this.listener = listener;
  }

  @Provides @Fragment ForecastUseCase provideForecastUserCase(ApiSource apiSource) {
    return new ForecastUseCaseImpl(apiSource);
  }

  @Provides @Fragment ForecastViewModel provideForecastViewModel(ForecastUseCase useCase) {
    return new ForecastViewModel(useCase, listener);
  }
}
