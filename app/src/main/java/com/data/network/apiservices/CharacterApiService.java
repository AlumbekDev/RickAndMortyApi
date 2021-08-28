package com.data.network.apiservices;

import com.model.CharacterModel;
import com.model.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CharacterApiService {

    @GET("api/character")
    Call<RickAndMortyResponse<CharacterModel>> fetchCharacters();

    @GET("api/character/{id}")
    Call<CharacterModel> fetchId(@Path("id") int id);

}