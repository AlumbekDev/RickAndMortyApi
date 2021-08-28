package com.ui.fragments.character;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.base.BaseFragment;
import com.ui.activity.R;
import com.ui.activity.databinding.FragmentCharacterBinding;
import com.ui.adapters.CharacterAdapter;

import org.jetbrains.annotations.NotNull;


public class CharacterFragment extends BaseFragment<CharacterViewModel, FragmentCharacterBinding> {

    private CharacterViewModel viewModel;
    private FragmentCharacterBinding binding;

    private final CharacterAdapter characterAdapter = new CharacterAdapter();
    private LinearLayoutManager linearLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCharacterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initialize() {
        super.initialize();
        viewModel = new ViewModelProvider(requireActivity()).get(CharacterViewModel.class);
        setupCharacterRecycler();
    }

    private void setupCharacterRecycler() {
        linearLayoutManager = new LinearLayoutManager(getContext());
        binding.recyclerCharacter.setLayoutManager(linearLayoutManager);
        binding.recyclerCharacter.setAdapter(characterAdapter);
//        characterAdapter.setOnItemClickListener(position -> {
//            Navigation.
//                    findNavController(requireActivity(), R.id.nav_host_fragment).navigate(
//                    CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment()
//                            .setPosition(position));
//        });
    }

    private int visibleItemCount;
    private int totalItemCount;
    private int pastVisiblesItems;

    @Override
    protected void setupRequests() {
        super.setupRequests();
        viewModel.fetchCharacter().observe(getViewLifecycleOwner(), characterModelRickAndMortyResponse -> {
            characterAdapter.submitList(characterModelRickAndMortyResponse.getResults());
        });

        binding.recyclerCharacter.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull @NotNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    visibleItemCount = linearLayoutManager.getChildCount();
                    totalItemCount = linearLayoutManager.getItemCount();
                    pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition();
                    if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                        viewModel.page++;
                        viewModel.fetchCharacter().observe(getViewLifecycleOwner(), characterModelRickAndMortyResponse -> {
                            characterAdapter.submitList(characterModelRickAndMortyResponse.getResults());
                        });
                    }
                }
            }
        });
    }
}