package com.example.fantasysportsleague.MainActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fantasysportsleague.MainActivities.Adapters.Create_match_adapter;
import com.example.fantasysportsleague.R;

import java.util.ArrayList;
import java.util.List;

public class Create_private_match extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView match_category,code,current_user;
    static int no_of_players=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_private_match);

        match_category=findViewById(R.id.match_category);
        code=findViewById(R.id.code_to_send_others_to_join);
        current_user=findViewById(R.id.current_user_creating_match);

        match_category.setText("Private Match");

        Spinner spinner=findViewById(R.id.no_of_players_spinner);
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("5");
        categories.add("10");
        categories.add("25");
        categories.add("50");
        categories.add("100");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,R.layout.spinner_layout_text, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        no_of_players=Integer.parseInt(parent.getItemAtPosition(position).toString());
        Toast.makeText(this, ""+no_of_players, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView=findViewById(R.id.recyclerview_of_create_match);

        Create_match_adapter create_match_adapter =new Create_match_adapter();
        recyclerView.setAdapter(create_match_adapter);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}