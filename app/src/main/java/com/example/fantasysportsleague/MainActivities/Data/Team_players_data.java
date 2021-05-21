package com.example.fantasysportsleague.MainActivities.Data;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Team_players_data {


    public static String[] batters_name=new String[]{
            "Batter_A",
            "Batter_B",
            "Batter_C",
            "Batter_D",
            "Batter_E",
            "Batter_F",
            "Batter_G",
            "Batter_H",
            "Batter_I",
            "Batter_J",
            "Batter_K"
    };

    public static String[] bowlers_name=new String[]{
        "Bowler_A",
        "Bowler_B",
        "Bowler_C",
        "Bowler_D",
        "Bowler_E",
        "Bowler_F",
    };

    public static String[] all_rounders_name=new String[]{
            "All-rounder_A",
            "All-rounder_B",
            "All-rounder_C",
            "All-rounder_D",
            "All-rounder_E",
            "All-rounder_F",
            "All-rounder_G",
            "All-rounder_H",
    };





    public static String[][] getBatters_name(){
        String[][] batters=new String[batters_name.length][batters_name.length];
        for(int i=0;i<batters_name.length;i++){
            double price_point=1+Math.random()*100;
            double playing_points=1+Math.random()*400;
            batters[i][0]=batters_name[i];
            batters[i][1]=String.valueOf((int) price_point);
            batters[i][2]=String.valueOf((int)playing_points);
        }
        return batters;
    }
    public static String[][] getBowlers_name(){
        String[][] bowlers=new String[bowlers_name.length][bowlers_name.length];
        for(int i=0;i<bowlers_name.length;i++){
            double price_point=1+Math.random()*100;
            double playing_points=1+Math.random()*400;
            bowlers[i][0]=bowlers_name[i];
            bowlers[i][1]=String.valueOf((int)price_point);
            bowlers[i][2]=String.valueOf((int)playing_points);
        }
        return bowlers;
    }

    public static String[][] getAll_rounders_name() {
        String[][] all_rounders=new String[all_rounders_name.length][all_rounders_name.length];
        for(int i=0;i<all_rounders_name.length;i++){
            double price_point=1+Math.random()*100;
            double playing_points=1+Math.random()*400;
            all_rounders[i][0]=all_rounders_name[i];
            all_rounders[i][1]=String.valueOf((int)price_point);
            all_rounders[i][2]=String.valueOf((int)playing_points);
        }
        return all_rounders;
    }

}
