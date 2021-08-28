package com.data.network.apiservices;

import com.model.LocationModel;
import com.model.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LocationApiService {

    @GET("api/location")
    Call<RickAndMortyResponse<LocationModel>> fetchLocation();
}
