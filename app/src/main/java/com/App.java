package com;

import android.app.Application;

import com.data.db.RoomClient;
import com.data.db.daos.CharacterDao;
import com.data.network.apiservices.CharacterApiService;
import com.data.network.RetrofitClient;
import com.data.network.apiservices.EpisodesApiService;
import com.data.network.apiservices.LocationApiService;

public class App extends Application {

    public static CharacterApiService characterApiService;
    public static LocationApiService locationApiService;
    public static EpisodesApiService episodesApiService;
    public static CharacterDao characterDao;

    @Override
    public void onCreate() {
        super.onCreate();
        characterApiService = new RetrofitClient().provideCharacterApiService();
        locationApiService = new RetrofitClient().providerLocationService();
        episodesApiService = new RetrofitClient().providerEpisodesApiService();

        RoomClient roomClient = new RoomClient();
        characterDao = roomClient.provideCharacterDao(roomClient.provideDatabase(this));
    }
}