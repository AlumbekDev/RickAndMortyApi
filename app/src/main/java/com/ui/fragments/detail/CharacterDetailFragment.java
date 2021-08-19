package com.ui.fragments.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ui.activity.R;
import com.ui.activity.databinding.FragmentCharacterBinding;
import com.ui.activity.databinding.FragmentCharacterDetailBinding;

import org.jetbrains.annotations.NotNull;

public class CharacterDetailFragment extends Fragment {
    private FragmentCharacterDetailBinding binding;
//    private CharacterDetailFragmentArgs args;

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
    }

    private void setupArgs() {
    }

    private void initialize() {

    }
}