package com.data.network;

import com.data.network.apiservices.CharacterApiService;
import com.data.network.apiservices.EpisodesApiService;
import com.data.network.apiservices.LocationApiService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .addInterceptor(provideLoggingInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .build();

    private HttpLoggingInterceptor provideLoggingInterceptor(){
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    private Retrofit provideRetrofit = new Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public CharacterApiService provideCharacterApiService(){
        return provideRetrofit.create(CharacterApiService.class);
    }

    public LocationApiService providerLocationService() {
        return provideRetrofit.create(LocationApiService.class);
    }

    public EpisodesApiService providerEpisodesApiService() {
        return provideRetrofit.create(EpisodesApiService.class);
    }
}