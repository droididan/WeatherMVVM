package com.fire.weatherapp.common;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by idan on 28/01/2017.
 * custom rx bus (like event bus)
 */

public class WeatherBus {
  private static WeatherBus instance = null;
  private final Subject<Object, Object> bus = new SerializedSubject<>(PublishSubject.create());

  private WeatherBus() {
  }

  public static WeatherBus getInstance() {
    if (instance == null) instance = new WeatherBus();
    return instance;
  }

  public void send(Object o) {
    bus.onNext(o);
  }

  public Observable<Object> toObserverable() {
    return bus;
  }

  public boolean hasObservers() {
    return bus.hasObservers();
  }
}
