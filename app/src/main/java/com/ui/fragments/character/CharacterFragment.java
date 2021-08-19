package com.ui.fragments.character;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.model.CharacterModel;
import com.model.RickAndMortyResponse;
import com.ui.activity.R;
import com.ui.activity.databinding.FragmentCharacterBinding;
import com.ui.adapters.CharacterAdapter;

import org.jetbrains.annotations.NotNull;

public class CharacterFragment extends Fragment {

    private CharacterViewModel viewModel;
    private FragmentCharacterBinding binding;
    private final CharacterAdapter characterAdapter = new CharacterAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCharacterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        setupCharacterRecycler();
        setupRequests();
    }


    private void initialize() {
        viewModel = new ViewModelProvider(requireActivity()).get(CharacterViewModel.class);
    }

    private void setupCharacterRecycler() {
        binding.recyclerCharacter.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerCharacter.setAdapter(characterAdapter);

//        characterAdapter.setOnItemClickListener(position -> {
//            Navigation.
//                    findNavController(requireActivity(), R.id.nav_host_fragment).navigate(
//                    CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment().setPosition(position));
//        });
    }
    private void setupRequests() {
         viewModel.fetchCharacter().observe(getViewLifecycleOwner(), new Observer<RickAndMortyResponse<CharacterModel>>() {
             @Override
             public void onChanged(RickAndMortyResponse<CharacterModel> characterModelRickAndMortyResponse) {
                 characterAdapter.addList(characterModelRickAndMortyResponse.getResults());             }
         });
    }
}