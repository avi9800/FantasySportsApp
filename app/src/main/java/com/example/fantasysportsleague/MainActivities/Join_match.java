package com.example.fantasysportsleague.MainActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fantasysportsleague.MainActivities.Adapters.joinmatch_adapter;
import com.example.fantasysportsleague.R;

public class Join_match extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vertical_recyclerview);

        RecyclerView recyclerView=findViewById(R.id.recycler_vertical_item);

        joinmatch_adapter joinmatchadapter =new joinmatch_adapter();
        recyclerView.setAdapter(joinmatchadapter);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        TextView textView=findViewById(R.id.create_team_textview);
        textView.setText("Select a match to proceed");

    }

    @Override
    protected void onResume() {
        super.onResume();

        RecyclerView recyclerView=findViewById(R.id.recycler_vertical_item);

        joinmatch_adapter joinmatchadapter =new joinmatch_adapter();
        recyclerView.setAdapter(joinmatchadapter);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        TextView textView=findViewById(R.id.create_team_textview);
        textView.setText("Join a match");
    }

    @Override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}