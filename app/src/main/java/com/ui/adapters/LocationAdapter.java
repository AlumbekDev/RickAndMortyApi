package com.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.model.LocationModel;
import com.ui.activity.databinding.ItemLocationBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {

    ArrayList<LocationModel> locationModels = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemLocationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    public void setListLoc(ArrayList<LocationModel> locationModels) {
        this.locationModels.addAll(locationModels);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.OnBind(locationModels.get(position));
    }

    @Override
    public int getItemCount() {
        return locationModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemLocationBinding binding;
        public ViewHolder(@NonNull @NotNull ItemLocationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void OnBind(LocationModel locationModel) {
            binding.name.setText(locationModel.getName());
            binding.type.setText(locationModel.getType());
        }
    }
}