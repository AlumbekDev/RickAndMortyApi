package com.ui.fragments.character.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.model.CharacterModel;
import com.ui.activity.databinding.FragmentCharacterDetailBinding;
import com.ui.fragments.character.CharacterViewModel;

import org.jetbrains.annotations.NotNull;

public class CharacterDetailFragment extends Fragment {
    private FragmentCharacterDetailBinding binding;
    CharacterViewModel viewModel;
    private int id;

    @Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initialize();
        setupArgs();
        setupRequest();
    }

    private void setupRequest() {
        viewModel.fetchData(id).observe(getViewLifecycleOwner(), characterModel -> {
            Glide
                    .with(binding.image)
                    .load(characterModel.getImage())
                    .into(binding.image);
            binding.title.setText(characterModel.getName());
            binding.status.setText(characterModel.getStatus());
            binding.species.setText(characterModel.getSpecies());
            binding.type.setText(characterModel.getType());
            binding.gender.setText(characterModel.getGender());
        });
    }

    private void setupArgs() {
       id = CharacterDetailFragmentArgs.fromBundle(getArguments()).getPosition();
    }



    private void initialize() {
        viewModel = new ViewModelProvider(requireActivity()).get(CharacterViewModel.class);
    }
}