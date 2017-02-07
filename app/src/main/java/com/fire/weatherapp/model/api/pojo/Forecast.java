package com.fire.weatherapp.model.api.pojo;

import java.util.List;

/**
 * Created by idan on 07/02/2017.
 */

public class Forecast {
  private Long dt;
  private Integer humidity;
  private Temp temp;
  private List<Weather> weather;
  private Double speed;
  private Integer deg;

  public Temp getTemp() {
    return temp;
  }

  public List<Weather> getWeather() {
    return weather;
  }

  public Double getSpeed() {
    return speed;
  }

  public Integer getDeg() {
    return deg;
  }

  public Long getDt() {
    return dt;
  }

  public Integer getHumidity() {
    return humidity;
  }
}
