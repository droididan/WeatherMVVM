package com.fire.weatherapp.model.api.pojo;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class ForecastResponse {
  private City city;
  private int cnt;
  @SerializedName("list") private List<Forecast> forecastList = new ArrayList<>();

  public List<Forecast> getForecastList() {
    return forecastList;
  }

  public City getCity() {
    return city;
  }

  public int getCnt() {
    return cnt;
  }
}
