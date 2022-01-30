package com.example.meteo;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CityRVAdapter extends RecyclerView.Adapter<CityRVAdapter.ViewHolder>  {
    private Context context;
    private ArrayList<HistoryModal> cityCardsArrayList;
    private RecyclerViewClickListener listener;

    public CityRVAdapter(Context context, ArrayList<HistoryModal> cityCardsArrayList, RecyclerViewClickListener listener) {
        this.context = context;
        this.cityCardsArrayList = cityCardsArrayList;
        this.listener = listener;
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView City;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            City = itemView.findViewById(R.id.idCity);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //listener.onClick(v, getAdapterPosition());
            Toast.makeText(context, "j'ai auppyer sur " +getAdapterPosition(), Toast.LENGTH_SHORT).show();
        }
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }


}
