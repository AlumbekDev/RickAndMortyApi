package com.data.repositories;

import androidx.lifecycle.MutableLiveData;

import com.App;
import com.model.CharacterModel;
import com.model.RickAndMortyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterRepository {
    public MutableLiveData<RickAndMortyResponse<CharacterModel>> fetchCharacters(int page) {
        MutableLiveData<RickAndMortyResponse<CharacterModel>> data = new MutableLiveData<>();
        App.characterApiService.fetchCharacters().enqueue(new Callback<RickAndMortyResponse<CharacterModel>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<CharacterModel>> call, Response<RickAndMortyResponse<CharacterModel>> response) {
                App.characterDao.insertAll(response.body().getResults());
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<CharacterModel>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    MutableLiveData<CharacterModel> dataId = new MutableLiveData<>();

    public MutableLiveData<CharacterModel> fetchData(int id) {
        App.characterApiService.fetchId(id).enqueue(new Callback<CharacterModel>() {
            @Override
            public void onResponse(Call<CharacterModel> call, Response<CharacterModel> response) {
                if (response.body() != null) {
                    dataId.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<CharacterModel> call, Throwable t) {
                dataId.setValue(null);
            }
        });
        return dataId;
    }

    public List<CharacterModel> getCharacters(){
        return App.characterDao.getAll();
    }
}