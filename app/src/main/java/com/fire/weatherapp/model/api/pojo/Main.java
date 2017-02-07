package com.fire.weatherapp.model.api.pojo;

/**
 * Created by idan on 07/02/2017.
 */

public class Main {
  private Double temp;
  private Double temp_min;
  private Double temp_max;
  private Integer humidity;

  public Integer getHumidity() {
    return humidity;
  }

  public Double getTemp() {
    return temp;
  }

  public Double getTemp_min() {
    return temp_min;
  }

  public Double getTemp_max() {
    return temp_max;
  }
}
