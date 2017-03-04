package com.fire.weatherapp.view.forecast;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.fire.weatherapp.databinding.ForecastItemBinding;
import com.fire.weatherapp.model.api.pojo.Forecast;
import com.fire.weatherapp.viewmodel.forecast.ItemForecastViewModel;
import java.util.Collections;
import java.util.List;

/**
 * Created by idan on 05/02/2017.
 * show list of forecast
 */

class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {
  private List<Forecast> items;

  ForecastAdapter() {
    this.items = Collections.emptyList();
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return ViewHolder.create(LayoutInflater.from(parent.getContext()), parent);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    holder.bind(new ItemForecastViewModel(holder.itemView.getContext(), items.get(position)));
  }

  @Override public int getItemCount() {
    return items.size();
  }

  void setItems(List<Forecast> list) {
    this.items = list;
    notifyDataSetChanged();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    ForecastItemBinding binding;

    ViewHolder(ForecastItemBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    static ForecastAdapter.ViewHolder create(LayoutInflater inflater, ViewGroup parent) {
      ForecastItemBinding binding = ForecastItemBinding.inflate(inflater, parent, false);
      return new ForecastAdapter.ViewHolder(binding);
    }

    private void bind(ItemForecastViewModel viewModel) {
      binding.setViewModel(viewModel);
      binding.executePendingBindings();
    }
  }
}