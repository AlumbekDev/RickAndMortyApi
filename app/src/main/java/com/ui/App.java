package com.ui;

import android.app.Application;

import com.ui.data.network.apiservices.CharacterApiService;
import com.ui.data.network.RetrofitClient;

public class App extends Application {

    public static CharacterApiService characterApiService;

    @Override
    public void onCreate() {
        super.onCreate();
        characterApiService = new RetrofitClient().provideCharacterApiService();
    }

}
