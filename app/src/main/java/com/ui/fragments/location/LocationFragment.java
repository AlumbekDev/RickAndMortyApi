package com.ui.fragments.location;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.model.LocationModel;
import com.model.RickAndMortyResponse;
import com.ui.activity.R;
import com.ui.activity.databinding.FragmentLocationBinding;
import com.ui.adapters.LocationAdapter;

import org.jetbrains.annotations.NotNull;


public class LocationFragment extends Fragment {

    LocationAdapter adapter = new LocationAdapter();

    private LocationViewModel locationViewModel;

    private FragmentLocationBinding binding;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLocationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        initRecyclerView();
        fetchApiLoc();

    }

    private void initialize() {
        locationViewModel = new ViewModelProvider(this).get(LocationViewModel.class);
    }


    private void initRecyclerView() {
        binding.rvLoc.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvLoc.setAdapter(adapter);
    }

    private void fetchApiLoc() {
        locationViewModel.getLocation().observe(getViewLifecycleOwner(), new Observer<RickAndMortyResponse<LocationModel>>() {
            @Override
            public void onChanged(RickAndMortyResponse<LocationModel> locationModelRickAndMortyResponse) {
                adapter.setListLoc(locationModelRickAndMortyResponse.getResults());
            }
        });
    }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            binding = null;
        }
    }
