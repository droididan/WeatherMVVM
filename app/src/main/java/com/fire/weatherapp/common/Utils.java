package com.fire.weatherapp.common;

import android.content.Context;
import android.text.format.Time;
import com.fire.weatherapp.R;
import java.text.SimpleDateFormat;

/**
 * Created by idan on 28/01/2017.
 */

public class Utils {
  public static String getDayName(Context context, long dateInMillis) {
    // If the date is today, return the localized version of "Today" instead of the actual
    // day name.

    Time t = new Time();
    t.setToNow();
    int julianDay = Time.getJulianDay(dateInMillis, t.gmtoff);
    int currentJulianDay = Time.getJulianDay(System.currentTimeMillis(), t.gmtoff);
    if (julianDay == currentJulianDay) {
      return context.getString(R.string.today);
    } else if (julianDay == currentJulianDay + 1) {
      return context.getString(R.string.tomorrow);
    } else {
      Time time = new Time();
      time.setToNow();
      // Otherwise, the format is just the day of the week (e.g "Wednesday".
      SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
      return dayFormat.format(dateInMillis);
    }
  }
}

