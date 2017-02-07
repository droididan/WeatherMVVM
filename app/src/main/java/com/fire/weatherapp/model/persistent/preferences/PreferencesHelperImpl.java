package com.fire.weatherapp.model.persistent.preferences;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import javax.inject.Inject;
import rx.Observable;

public class PreferencesHelperImpl<T> implements PreferencesHelper<T> {


  private SharedPreferences sharedPreferences;
  private Gson gson;

  @Inject public PreferencesHelperImpl(SharedPreferences sharedPreferences, Gson gson) {
    this.sharedPreferences = sharedPreferences;
    this.gson = gson;
  }

  @Override public Observable<T> save(String key, T value) {
    return Observable.create(subscriber -> {
      sharedPreferences.edit().putString(key, gson.toJson(value)).apply();
      subscriber.onNext(value);
      subscriber.onCompleted();
    });
  }

  @Override public Observable<T> get(String key, Class<T> generic) {
    return Observable.create(subscriber -> {
      String json = sharedPreferences.getString(key, "");
      T myClass = gson.fromJson(json, generic);
      subscriber.onNext(myClass);
      subscriber.onCompleted();
    });
  }

  @Override public Observable<Boolean> clear() {
    return Observable.create(subscriber -> {
      sharedPreferences.edit().clear().apply();
      subscriber.onNext(true);
      subscriber.onCompleted();
    });
  }
}