package com.example.meteo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;



public class MainActivity2 extends AppCompatActivity{

    private ArrayList<HistoryModal> historyModalArrayList;
    private CityRVAdapter cityCardAdapter;
    private RecyclerView cityRv;
    private ArrayList<String> Citys;
    private CityRVAdapter.RecyclerViewClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cityRv = findViewById(R.id.idRvCity);


        historyModalArrayList = new ArrayList<HistoryModal>();
        cityCardAdapter = new CityRVAdapter(this, historyModalArrayList, listener);
        cityRv.setAdapter(cityCardAdapter);

        setOnClicklistener();
        // faire en sorte de recuperer les villes en bdd, les mettres dans un tableau et les afficher (comme au dessus)
        // + faire que quand on clique sur un element de la liste revienne sur l'activité 1 avec loc changer

        Database mydb = new Database(this);
        Citys = mydb.readData();
        Log.i("APP", String.valueOf(Citys));
        Log.i("APP", "Je suis laaaaaaaaaaaaaaaa" + String.valueOf(Citys.get(1)));

        for (int i=0; i< Citys.size(); i++){
            historyModalArrayList.add(new HistoryModal(Citys.get(i)));
        }
        cityCardAdapter.notifyDataSetChanged();

    }

    private void setOnClicklistener(){
        listener = new CityRVAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("city",historyModalArrayList.get(position).getHistory_city());
                startActivity(intent);

            }
        };
    }
}