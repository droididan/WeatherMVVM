package com.fire.weatherapp.model.api.entity;

import com.google.gson.annotations.SerializedName;

public class Rain {

  @SerializedName("3h") private Long m3h;

  public Long get3h() {
    return m3h;
  }
}
