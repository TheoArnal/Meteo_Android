package com.example.meteo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CityRVAdapter extends RecyclerView.Adapter<CityRVAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HistoryModal> cityCardsArrayList;

    public CityRVAdapter(Context context, ArrayList<HistoryModal> cityCardsArrayList) {
        this.context = context;
        this.cityCardsArrayList = cityCardsArrayList;
    }

    @NonNull
    @Override
    public CityRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.city_layout_card,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityRVAdapter.ViewHolder holder, int position) {
        HistoryModal modal = cityCardsArrayList.get(position);
        holder.City.setText(modal.getHistory_city());
    }

    @Override
    public int getItemCount() {
        return cityCardsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView City;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            City = itemView.findViewById(R.id.idCity);
        }
    }
}
