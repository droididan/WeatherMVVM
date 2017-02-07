package com.fire.weatherapp.viewmodel.main;

import com.fire.weatherapp.common.WeatherBus;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by idan on 28/01/2017.
 */

public class MainViewModel {
  private boolean isTwoPane = false;
  private CompositeSubscription subscription;

  public MainViewModel(WeatherBus bus, MainListener listener) {
    subscription = new CompositeSubscription();

    // listen to events from other fragments to change the toolbar UI

  }

  public void unsubscribe() {
    if (subscription != null && !subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }

  public boolean isTwoPane() {
    return isTwoPane;
  }

  public void setTwoPane(boolean twoPane) {
    isTwoPane = twoPane;
  }

  public interface MainListener{
    void updateToolbarTitle(String title);
  }
}