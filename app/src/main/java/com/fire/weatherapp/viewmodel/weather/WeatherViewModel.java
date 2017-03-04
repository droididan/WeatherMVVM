package com.fire.weatherapp.viewmodel.weather;

import android.databinding.ObservableField;
import android.view.View;
import com.fire.weatherapp.common.Consts;
import com.fire.weatherapp.domain.weather.WeatherUseCase;
import com.fire.weatherapp.model.api.pojo.Coord;
import com.fire.weatherapp.model.api.pojo.WeatherResponse;
import javax.inject.Inject;
import rx.Observer;
import rx.subjects.PublishSubject;

/**
 * Created by idan on 28/01/2017.
 */
public class WeatherViewModel {

  public ObservableField<Integer> isLoading;
  public ObservableField<String> temp;
  public ObservableField<String> humidity;
  public ObservableField<String> desc;
  public ObservableField<String> city;

  @Inject public WeatherViewModel(WeatherUseCase useCase) {
    isLoading = new ObservableField<>(View.GONE);
    temp = new ObservableField<>();
    humidity = new ObservableField<>();
    desc = new ObservableField<>();
    city = new ObservableField<>();

    PublishSubject<Coord> publishSubject = PublishSubject.create();

    publishSubject
        .doOnNext(response -> isLoading.set(View.VISIBLE))
        .flatMap(useCase::getWeather)
        .doOnNext(response -> isLoading.set(View.GONE))
        .subscribe(new Observer<WeatherResponse>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {

          }

          @Override public void onNext(WeatherResponse response) {
            temp.set(Math.round(response.getMain().getTemp()) + Consts.PERCENT);
            humidity.set("Hu" + response.getMain().getHumidity().toString());
            city.set(response.getName());
            desc.set(response.getWeather().get(0).getMain());
          }
        });

    // the coord should come from main activity with location services.
    publishSubject.onNext(new Coord(34.2, 32.2));
  }
}