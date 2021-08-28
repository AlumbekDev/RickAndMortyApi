package com.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.model.CharacterModel;
import com.ui.activity.databinding.ItemCharacterBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {
    private ArrayList<CharacterModel> list = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new CharacterViewHolder(ItemCharacterBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CharacterViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void submitList(ArrayList<CharacterModel> results) {
        this.list = results;
        notifyDataSetChanged();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {
        ItemCharacterBinding binding;
        public CharacterViewHolder(@NonNull @NotNull ItemCharacterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void onBind(CharacterModel model){
            Glide.with(binding.imageItemCharacter)
                    .load(model.getImage())
                    .into(binding.imageItemCharacter);
            binding.textItemCharactersNaem.setText(model.getName());
        }
    }


}
