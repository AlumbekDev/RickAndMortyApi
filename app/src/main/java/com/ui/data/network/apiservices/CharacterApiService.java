package com.ui.data.network.apiservices;

import com.model.CharacterModel;
import com.model.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CharacterApiService {

    @GET("api/character")
    Call<RickAndMortyResponse<CharacterModel>> fetchCharacters();
}