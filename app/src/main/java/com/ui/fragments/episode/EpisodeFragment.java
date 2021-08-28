package com.ui.fragments.episode;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.model.EpisodeModel;
import com.ui.activity.R;
import com.ui.activity.databinding.FragmentEpisodeBinding;
import com.ui.adapters.EpisodeAdapter;

import org.jetbrains.annotations.NotNull;

public class EpisodeFragment extends Fragment {

    private FragmentEpisodeBinding binding;
    private EpisodeViewModel viewModel;
    private EpisodeAdapter episodeAdapter = new EpisodeAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEpisodeBinding.inflate(inflater,container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel =
                new ViewModelProvider(requireActivity()).get(EpisodeViewModel.class);
        initialize();
        setupRequests();
    }

    private void setupRequests() {
        viewModel.fetchEpisodes().observe(getViewLifecycleOwner(), episodeModelRickAndMortyResponse -> {
            episodeAdapter.addList(episodeModelRickAndMortyResponse.getResults());
        });
    }

    private void initialize() {
        setupEpisodeRecycler();
    }

    private void setupEpisodeRecycler() {
        binding.rvEpi.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvEpi.setAdapter(episodeAdapter);
    }
}