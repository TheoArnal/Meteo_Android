package com.example.meteo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private ArrayList<HistoryModal> historyModalArrayList;
    private CityRVAdapter cityCardAdapter;
    private RecyclerView cityRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cityRv = findViewById(R.id.idRvCity);

        historyModalArrayList = new ArrayList<HistoryModal>();
        cityCardAdapter = new CityRVAdapter(this, historyModalArrayList);
        cityRv.setAdapter(cityCardAdapter);
        historyModalArrayList.add(new HistoryModal("Toulouse"));
        historyModalArrayList.add(new HistoryModal("Paris"));
        cityCardAdapter.notifyDataSetChanged();


        // faire en sorte de recuperer les villes en bdd, les mettres dans un tableau et les afficher (comme au dessus)
        // + faire que quand on clique sur un element de la liste revienne sur l'activité 1 avec loc changer

        Database mydb = new Database(this);
        mydb.readData();




    }
}