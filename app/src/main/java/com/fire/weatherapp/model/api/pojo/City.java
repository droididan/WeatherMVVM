package com.fire.weatherapp.model.api.pojo;

/**
 * Created by idan on 07/02/2017.
 */

public class City {
  private Long id;
  private String name;
  private Coord coord;
  private String country;

  public Coord getCoord() {
    return coord;
  }

  public String getCountry() {
    return country;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
