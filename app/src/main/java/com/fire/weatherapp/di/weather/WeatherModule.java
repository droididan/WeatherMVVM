package com.fire.weatherapp.di.weather;

import com.fire.weatherapp.di.scopes.Fragment;
import com.fire.weatherapp.domain.weather.WeatherUseCase;
import com.fire.weatherapp.domain.weather.WeatherUseCaseImpl;
import com.fire.weatherapp.model.api.rest.ApiSource;
import com.fire.weatherapp.viewmodel.weather.WeatherViewModel;
import dagger.Module;
import dagger.Provides;

/**
 * Created by idan on 28/01/2017.
 */
@Module public class WeatherModule {

  public WeatherModule() {
  }

  @Provides @Fragment WeatherUseCase provideWeatherUserCase(ApiSource apiSource) {
    return new WeatherUseCaseImpl(apiSource);
  }

  @Provides @Fragment WeatherViewModel provideWeatherViewModel(WeatherUseCase useCase) {
    return new WeatherViewModel(useCase);
  }
}
