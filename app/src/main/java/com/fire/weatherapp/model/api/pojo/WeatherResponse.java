package com.fire.weatherapp.model.api.pojo;

import java.util.List;

/**
 * Created by idan on 07/02/2017.
 */

public class WeatherResponse {
  private Coord coord;
  private List<Weather> weather;
  private Main main;
  private Wind wind;
  private Long dt;
  private String name;

  public String getName() {
    return name;
  }

  public Coord getCoord() {
    return coord;
  }

  public List<Weather> getWeather() {
    return weather;
  }

  public Main getMain() {
    return main;
  }

  public Wind getWind() {
    return wind;
  }

  public Long getDt() {
    return dt;
  }
}
