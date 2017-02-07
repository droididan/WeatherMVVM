package com.fire.weatherapp.viewmodel.forecast;

import android.databinding.ObservableField;
import android.view.View;
import com.fire.weatherapp.domain.forecast.ForecastUseCase;
import com.fire.weatherapp.model.api.pojo.Coord;
import com.fire.weatherapp.model.api.pojo.ForecastResponse;
import javax.inject.Inject;
import rx.subjects.PublishSubject;

/**
 * Created by idan on 28/01/2017.
 * forecast view model
 */

public class ForecastViewModel {

  @Inject public ForecastViewModel(ForecastUseCase useCase, ForecastListener listener) {

    PublishSubject<Coord> publishSubject = PublishSubject.create();
    ObservableField<Integer> isLoading = new ObservableField<>(View.GONE);

    publishSubject.doOnNext(response -> isLoading.set(View.VISIBLE))
        .flatMap(useCase::getForecast)
        .limit(1)
        .doOnNext(response -> isLoading.set(View.GONE))
        .subscribe(listener::onForecastReady);


    publishSubject.onNext(new Coord(32.2, 34.2));
  }

  public interface ForecastListener {
    void onForecastReady(ForecastResponse response);
  }
}
