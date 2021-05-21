package com.example.fantasysportsleague.MainActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fantasysportsleague.MainActivities.Adapters.joined_match_adapter;
import com.example.fantasysportsleague.R;

public class joined_match extends AppCompatActivity {
    TextView category,username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joined_match);

        category=findViewById(R.id.match_category_join);
        username=findViewById(R.id.current_user_joined_match);

        category.setText("Private Match");
        username.setText(getSharedPreferences("PREFERENCE1", MODE_PRIVATE)
                .getString("name","Not present"));


    }

    @Override
    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView=findViewById(R.id.joined_match_recyclerview);

        joined_match_adapter ja =new joined_match_adapter();
        recyclerView.setAdapter(ja);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}