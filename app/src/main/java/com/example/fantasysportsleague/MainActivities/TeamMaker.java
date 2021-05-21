package com.example.fantasysportsleague.MainActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.fantasysportsleague.MainActivities.Adapters.tab_adapter;
import com.example.fantasysportsleague.MainActivities.Tabs.All_fragment;
import com.example.fantasysportsleague.MainActivities.Tabs.All_rounder_fragment;
import com.example.fantasysportsleague.MainActivities.Tabs.Batter_fragment;
import com.example.fantasysportsleague.MainActivities.Tabs.Bowler_fragment;
import com.example.fantasysportsleague.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TeamMaker extends AppCompatActivity implements All_rounder_fragment.OnFragmentInteractionListener, Batter_fragment.OnFragmentInteractionListener, Bowler_fragment.OnFragmentInteractionListener, All_fragment.OnFragmentInteractionListener, AdapterView.OnItemSelectedListener , View.OnClickListener {
    TabLayout tabLayout;
    TextView team_number;
    int team_no;
    String spinner_item;
    PagerAdapter pagerAdapter;
    ViewPager viewPager;
    ArrayList<String> all_rounders_selected,batters_selected,bowlers_selected;
    Button submit;
    int no_of_batters,no_of_bowlers,no_of_allrounders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_maker);

        //Intent i=getIntent();
        //int contest_id=i.getIntExtra("contest_id",-1);

        submit=findViewById(R.id.submit_team);
        submit.setOnClickListener(this);

        all_rounders_selected=new ArrayList<>();
        batters_selected=new ArrayList<>();
        bowlers_selected=new ArrayList<>();

        tabLayout=findViewById(R.id.tab_layout);
        team_number=findViewById(R.id.team_number);

        no_of_batters=getSharedPreferences("no_of_batters_selected",MODE_PRIVATE).getInt("batter_no",0);
        no_of_bowlers=getSharedPreferences("no_of_bowlers_selected",MODE_PRIVATE).getInt("bowler_no",0);
        no_of_allrounders=getSharedPreferences("no_of_allrounders_selected",MODE_PRIVATE).getInt("allrounder_no",0);

        //tabLayout.addTab(tabLayout.newTab().setText("Batter("+no_of_batters+")"));
       // tabLayout.addTab(tabLayout.newTab().setText("Bowler("+no_of_bowlers+")"));
       // tabLayout.addTab(tabLayout.newTab().setText("All-rounder("+no_of_allrounders+")"));
        tabLayout.addTab(tabLayout.newTab().setText("Batter"));
        tabLayout.addTab(tabLayout.newTab().setText("Bowler"));
        tabLayout.addTab(tabLayout.newTab().setText("All-rounder"));
        //tabLayout.addTab(tabLayout.newTab().setText("All"));
        tabLayout.setTabTextColors(Color.parseColor("#FFFFFF"),Color.parseColor("#FD6A02"));
        viewPager=findViewById(R.id.pager);
        Button submit=findViewById(R.id.submit_team);
        pagerAdapter=new tab_adapter(getSupportFragmentManager(),tabLayout.getTabCount(),submit);//,name+" is Present");
        int limit = (pagerAdapter.getCount() > 1 ? pagerAdapter.getCount() - 1 : 1);//to get page adapter limit
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(limit);//to prevent tabs from refreshing on swiping to next

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        Spinner spinner=findViewById(R.id.team_spinner);
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("Team 1");
        categories.add("Team 2");
        categories.add("Team 3");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,R.layout.spinner_layout_text, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        spinner_item = parent.getItemAtPosition(position).toString();
        team_no=position+1;

        getSharedPreferences("team_name_preference",MODE_PRIVATE).edit().putInt("team_number",team_no).commit();


        // Showing selected spinner item
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
        if(!getSharedPreferences("team_name_preference",MODE_PRIVATE).contains("team_number"))
        {
            getSharedPreferences("team_name_preference",MODE_PRIVATE).edit().putInt("team_number",1);
        }

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==submit.getId())
        {
        }
    }

}