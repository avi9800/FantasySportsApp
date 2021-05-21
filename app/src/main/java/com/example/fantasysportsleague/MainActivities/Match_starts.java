package com.example.fantasysportsleague.MainActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fantasysportsleague.R;

public class Match_starts extends AppCompatActivity {

    TextView team1list,team2list,team3list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_starts);
         team1list=findViewById(R.id.team1_list);
         team2list=findViewById(R.id.team2_list);
        team3list=findViewById(R.id.team3_list);

        team1list.setText("Team 1-"+getSharedPreferences("team1_list",MODE_PRIVATE).getString("team1",null));
        team2list.setText("Team 2-"+getSharedPreferences("team2_list",MODE_PRIVATE).getString("team2",null));
        team3list.setText("Team 3-"+getSharedPreferences("team3_list",MODE_PRIVATE).getString("team3",null));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(this,Enter_contest.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}