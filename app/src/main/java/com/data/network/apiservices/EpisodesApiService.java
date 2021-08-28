package com.data.network.apiservices;

import com.model.EpisodeModel;
import com.model.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EpisodesApiService {
    @GET("api/episode")
    Call<RickAndMortyResponse<EpisodeModel>> fetchEpisodes();
}
