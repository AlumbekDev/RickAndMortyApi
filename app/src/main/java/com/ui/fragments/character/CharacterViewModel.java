package com.ui.fragments.character;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.App;
import com.base.BaseViewModel;
import com.data.repositories.CharacterRepository;
import com.model.CharacterModel;
import com.model.RickAndMortyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterViewModel extends BaseViewModel {
public int page = 1;
    private final CharacterRepository repository = new CharacterRepository();

    MutableLiveData<RickAndMortyResponse<CharacterModel>> fetchCharacter(){
        return repository.fetchCharacters(page);
    }

    public MutableLiveData<CharacterModel> fetchData(int id) {
        return repository.fetchData(id);
    }
}