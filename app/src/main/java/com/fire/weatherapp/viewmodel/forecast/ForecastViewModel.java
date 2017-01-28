package com.fire.weatherapp.viewmodel.forecast;

/**
 * Created by idan on 28/01/2017.
 */

public class ForecastViewModel {

  public ForecastViewModel(ForecastListener listener){




  }

  public interface ForecastListener {
    void onForecastClicked();
  }
}
