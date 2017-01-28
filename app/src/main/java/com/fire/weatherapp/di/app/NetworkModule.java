package com.fire.weatherapp.di.app;

import com.fire.weatherapp.common.Consts;
import com.fire.weatherapp.model.api.rest.ApiSource;
import com.fire.weatherapp.model.api.rest.ApiSourceImpl;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by idan on 28/01/2017.
 */

@Module public class NetworkModule {
  @Provides @Singleton HttpLoggingInterceptor provideHttpInterceptro() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return interceptor;
  }

  @Provides @Singleton OkHttpClient provideOkHttpClinet(HttpLoggingInterceptor interceptor){
    return new OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(1, TimeUnit.MINUTES)
        .addInterceptor(interceptor)
        .build();
  }

  @Provides @Singleton Retrofit provideRetrofit(OkHttpClient okHttpClient) {
    return new Retrofit.Builder().baseUrl(Consts.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .client(okHttpClient)
        .build();
  }

  @Provides @Singleton ApiSource provideApiSource(Retrofit retrofit) {
    return new ApiSourceImpl(retrofit);
  }
}
