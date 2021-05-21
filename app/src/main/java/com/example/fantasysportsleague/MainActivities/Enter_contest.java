package com.example.fantasysportsleague.MainActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.example.fantasysportsleague.MainActivities.Adapters.enter_challenge_a_league_adapter;
import com.example.fantasysportsleague.MainActivities.Adapters.enter_choose_a_contest_adapter;
import com.example.fantasysportsleague.R;

public class Enter_contest extends AppCompatActivity {

    String match_id;
    RecyclerView recyclerView1,recyclerView2;
    RecyclerView.LayoutManager layoutManager1,layoutManager2;
    ScrollView scrollView;
    RelativeLayout layout;
    Button join_private_match,create_private_match;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_match_recyclerview);
        scrollView=findViewById(R.id.enter_match_scrollview);
        layout=findViewById(R.id.scrollview_layout);
        join_private_match=findViewById(R.id.join_a_private_contest);
        create_private_match=findViewById(R.id.create_a_private_contest);
        join_private_match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Enter_contest.this,Join_Private_match.class));
            }
        });

        create_private_match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Enter_contest.this,Create_private_match.class));
            }
        });


        Intent i=getIntent();
        match_id=i.getStringExtra("match_id");

        recyclerView1=findViewById(R.id.enter_match_recyclerview1);
        recyclerView2=findViewById(R.id.enter_match_recyclerview2);
        recyclerView1.setNestedScrollingEnabled(false);
        recyclerView2.setNestedScrollingEnabled(false);

        enter_challenge_a_league_adapter ecla=new enter_challenge_a_league_adapter();
        enter_choose_a_contest_adapter ecca=new enter_choose_a_contest_adapter();

        recyclerView1.setAdapter(ecca);
        recyclerView2.setAdapter(ecla);
        layoutManager1=new LinearLayoutManager(this);
        layoutManager2=new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView2.setLayoutManager(layoutManager2);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,Join_match.class));
    }
}