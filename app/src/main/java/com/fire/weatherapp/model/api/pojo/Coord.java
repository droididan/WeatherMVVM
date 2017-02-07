package com.fire.weatherapp.model.api.pojo;

/**
 * Created by idan on 07/02/2017.
 */

public class Coord {
  private Double lon;
  private Double lat;

  public Coord(Double lon, Double lat) {
    this.lon = lon;
    this.lat = lat;
  }

  public Double getLon() {
    return lon;
  }

  public Double getLat() {
    return lat;
  }
}
