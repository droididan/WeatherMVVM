package com.fire.weatherapp.viewmodel.forecast;

import android.content.Context;
import android.databinding.ObservableField;
import com.fire.weatherapp.common.Consts;
import com.fire.weatherapp.common.Utils;
import com.fire.weatherapp.model.api.pojo.Forecast;

/**
 * Created by idan on 05/02/2017.
 */

public class ItemForecastViewModel {
  public ObservableField<String> temp;
  public ObservableField<String> desc;
  public ObservableField<String> date;
  public ObservableField<String> image;

  public ItemForecastViewModel(Context context, Forecast res) {
    temp = new ObservableField<>(Math.round(res.getTemp().getDay()) + Consts.PERCENT);
    desc = new ObservableField<>(res.getWeather().get(0).getDescription());
    date = new ObservableField<>(Utils.getDayName(context, res.getDt()));
    image = new ObservableField<>(res.getWeather().get(0).getIcon());
  }
}
