package com.kubilaykocabal.android.retrofithava;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("data/2.5/weather")
    Call<Weather> getGithubWeather(@Query("q") String city,@Query("appid") String appid);
}
