package com.kubilaykocabal.android.retrofithava;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {
    private static final String ROOT_URL = "http://api.openweathermap.org/";
    private static Retrofit getRefrofitInstance(){
        Retrofit rf = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return rf;
    }
    public static ApiService getApiService(){
        ApiService api = getRefrofitInstance().create(ApiService.class);
        return api;
    }
}
