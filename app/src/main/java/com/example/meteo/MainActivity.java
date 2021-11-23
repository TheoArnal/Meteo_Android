package com.example.meteo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    TextView display_city;
    TextView temp;
    TextView cond;
    EditText city;
    Button validate;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temp = findViewById(R.id.textView1);
        cond = findViewById(R.id.textView2);
        display_city = findViewById(R.id.name_city);
        city = findViewById(R.id.City);
        img = findViewById(R.id.imageView);
        String location = city.getText().toString();
        validate = findViewById(R.id.button);
        validate.setOnClickListener(v -> {
            fetchCity(city.getText().toString());
        });

    }

    public void fetchCity (String city) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://www.prevision-meteo.ch/services/json/" + city;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject data = new JSONObject(response);
                    JSONObject a = data.getJSONObject("current_condition");
                    String condition = a.getString("condition");
                    String tmp = a.getString("tmp");

                    Picasso.get().load(a.getString("icon")).into(img);

                    display_city.setText(city);
                    temp.setText(tmp);
                    cond.setText(condition);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                temp.setText("That didn't work!");
            }



        });

        queue.add(stringRequest);

    }
}