package com.fire.weatherapp.common;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

import static com.fire.weatherapp.common.Consts.FILE_PNG;
import static com.fire.weatherapp.common.Consts.URL;

/**
 * Created by idan on 28/01/2017.
 *
 */
public class ImageDataBinding {
  @BindingAdapter({ "android:background" })
  public static void loadResImages(ImageView view, String icon) {
    Glide.with(view.getContext()).load(URL + icon + FILE_PNG).placeholder(placeholder).into(view);
  }
}