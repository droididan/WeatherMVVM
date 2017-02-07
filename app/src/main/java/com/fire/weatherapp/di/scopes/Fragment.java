package com.fire.weatherapp.di.scopes;

/**
 * Created by idan on 28/01/2017.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

@Scope @Retention(RetentionPolicy.RUNTIME) public @interface Fragment {
}
