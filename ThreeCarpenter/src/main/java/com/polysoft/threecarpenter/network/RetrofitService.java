package com.polysoft.threecarpenter.network;

import com.polysoft.threecarpenter.network.api.NetApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xu on 2016/11/16.
 */
public class RetrofitService {

    //http://192.168.1.238:8080/sgmj/app/login

    public static final String BASE_URL = "http://192.168.1.238:8080/sgmj/app/";
    private static NetApi netApi;
    public static GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    private static OkHttpClient client = new OkHttpClient.Builder().addInterceptor
            (new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();

    public static NetApi getRetrofit() {
        if (netApi == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(gsonConverterFactory)
                    .client(client)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory).build();
            netApi = retrofit.create(NetApi.class);
        }
        return netApi;
    }


}