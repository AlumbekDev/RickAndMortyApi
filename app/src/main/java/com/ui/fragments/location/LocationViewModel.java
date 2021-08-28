package com.ui.fragments.location;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.model.LocationModel;
import com.model.RickAndMortyResponse;
import com.App;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationViewModel extends ViewModel {

    public MutableLiveData<RickAndMortyResponse<LocationModel>> getLocation() {

        MutableLiveData<RickAndMortyResponse<LocationModel>> liveData = new MutableLiveData<>();
        App.locationApiService.fetchLocation().enqueue(new Callback<RickAndMortyResponse<LocationModel>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<LocationModel>> call, Response<RickAndMortyResponse<LocationModel>> response) {
                liveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<LocationModel>> call, Throwable t) {
                liveData.setValue(null);
            }
        });
        return liveData;
    }

}