package com.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.model.CharacterModel;
import com.ui.activity.R;
import com.ui.activity.databinding.ItemCharacterBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    private ItemCharacterBinding binding;
    public ArrayList<CharacterModel> list = new ArrayList<>();
    //private OnItemClickListener listener;

    @NonNull
    @NotNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CharacterViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CharacterViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addList(ArrayList<CharacterModel> models) {
        this.list = models;
        notifyDataSetChanged();

    }

    class CharacterViewHolder extends RecyclerView.ViewHolder {


        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
//            binding.getRoot().setOnClickListener(v -> {
//                listener.OnItemClick(getAdapterPosition());
//            });
        }

        private void onBind(CharacterModel item) {
            Glide.with(binding.imageItemCharacter).load(item.getImage()).into(binding.imageItemCharacter);
            binding.textItemCharactersNaem.setText(item.getName());
        }
    }
}

//    public interface OnItemClickListener {
//        void OnItemClick(int position);
//    }
//
//    public void setOnItemClickListener(OnItemClickListener listener) {
//        this.listener = listener;
//    }
//}