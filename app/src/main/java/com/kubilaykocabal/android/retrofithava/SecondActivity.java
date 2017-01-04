package com.kubilaykocabal.android.retrofithava;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends Activity {
    public TextView description;
    public TextView main;
    public ImageView imageview;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        description = (TextView)findViewById(R.id.textViewDescription);
        main = (TextView)findViewById(R.id.textViewMain);
        imageview =(ImageView)findViewById(R.id.imageView);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        progressDialog = new ProgressDialog(this);
        ApiService myApi = RetroClient.getApiService();
        Call<Weather> call = myApi.getGithubWeather(message,"9b19d60baa38c692f1bdb4db53e2d0ce");
        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Log.v("Response Code","Response Code is : "+ response.code());
                String str=response.body().getWeather().get(0).getMain();
                main.setText(response.body().getWeather().get(0).getMain());
                description.setText(response.body().getWeather().get(0).getDescription());
                Picasso.with(getApplicationContext()).load("http://openweathermap.org/img/w/"+ response.body().getWeather().get(0).getİcon()+".png").error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(imageview);

            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {

            }
        });
    }
}
