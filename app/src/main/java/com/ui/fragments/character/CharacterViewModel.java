package com.ui.fragments.character;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.model.CharacterModel;
import com.model.RickAndMortyResponse;
import com.ui.App;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterViewModel extends ViewModel {

    MutableLiveData<RickAndMortyResponse<CharacterModel>> fetchCharacter() {
        MutableLiveData<RickAndMortyResponse<CharacterModel>> data = new MutableLiveData<>();
        App.characterApiService.fetchCharacters().enqueue(new Callback<RickAndMortyResponse<CharacterModel>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<CharacterModel>> call, Response<RickAndMortyResponse<CharacterModel>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<CharacterModel>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}