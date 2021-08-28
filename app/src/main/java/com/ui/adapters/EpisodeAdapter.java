package com.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.model.EpisodeModel;
import com.ui.activity.databinding.ItemEpisodeBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder> {

    private ArrayList<EpisodeModel> list = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new EpisodeViewHolder(ItemEpisodeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull EpisodeViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addList(ArrayList<EpisodeModel> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public class EpisodeViewHolder extends RecyclerView.ViewHolder {
        private ItemEpisodeBinding binding;

        private void onBind(EpisodeModel item) {
            binding.itemEpisode.setText(item.getName());
            binding.itemEpisode2.setText(item.getAir_date());
            binding.itemEpisode3.setText(item.getCreated());
            binding.itemEpisode4.setText(item.getEpisode());
        }

        public EpisodeViewHolder(@NonNull @NotNull ItemEpisodeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
