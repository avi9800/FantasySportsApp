package com.example.fantasysportsleague.MainActivities.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.fantasysportsleague.MainActivities.Data.Team_players_data;
import com.example.fantasysportsleague.MainActivities.Match_starts;
import com.example.fantasysportsleague.R;

import static android.content.Context.MODE_PRIVATE;

public class tab_item_adapter extends RecyclerView.Adapter<tab_item_adapter.ViewHolder> {


    private Context context;
    private View team_maker;
    private int length;
    String[][] players_array;
    static String[][] batters_selected=new String[Team_players_data.batters_name.length][3];
    static String[][] bowlers_selected=new String[Team_players_data.bowlers_name.length][3];
    static String[][] all_rounder_selected=new String[Team_players_data.all_rounders_name.length][3];
    String temp_bat,temp_bowl,temp_allrounders;
    static int batter_selected_count=0;
    static int bowler_selected_count=0;
    static int all_rounder_selected_count=0;
    public int team_number;
    String team1=null;
    String team2=null;
    String team3=null;
    ViewPager viewPager;

    public tab_item_adapter(Context context,int length,View team_maker){
        this.context=context;
        this.length=length;
        this.team_maker=team_maker;
        batter_selected_count=0;
        bowler_selected_count=0;
        all_rounder_selected_count=0;
        team_number=context.getSharedPreferences("team_name_preference",MODE_PRIVATE).getInt("team_number",0);
        if(length==Team_players_data.all_rounders_name.length)
            players_array = Team_players_data.getAll_rounders_name();
        else if(length==Team_players_data.batters_name.length)
            players_array = Team_players_data.getBatters_name();
        else
            players_array = Team_players_data.getBowlers_name();
    }

    @NonNull
    @Override
    public tab_item_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_maker_item, parent, false);
        viewPager=team_maker.findViewById(R.id.pager);
        return new tab_item_adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final tab_item_adapter.ViewHolder holder, final int position) {
        if(length== Team_players_data.all_rounders_name.length) {
              holder.add_player.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    temp_allrounders="";
                    if(all_rounder_selected[position][0]==null&&all_rounder_selected_count<1){
                        all_rounder_selected[position][0]=players_array[position][0];
                        all_rounder_selected[position][1]=players_array[position][1];
                        all_rounder_selected[position][2]=players_array[position][2];
                        all_rounder_selected_count++;
                        holder.add_player.setCardBackgroundColor(context.getResources().getColor(R.color.selected));
                    }
                    else if(all_rounder_selected[position][0]==null&&all_rounder_selected_count==1)
                        Toast.makeText(context, "No more members of this group can be added", Toast.LENGTH_SHORT).show();
                    else if(all_rounder_selected[position][0]!=null) {
                        all_rounder_selected[position][0]=null;
                        all_rounder_selected[position][1]=null;
                        all_rounder_selected[position][2]=null;
                        all_rounder_selected_count--;
                        holder.add_player.setCardBackgroundColor(context.getResources().getColor(R.color.not_selected));
                    }
                    for(int i=0;i<all_rounder_selected.length;i++){
                        if(all_rounder_selected[i][0]!=null) {
                            temp_allrounders += all_rounder_selected[i][0] + "-" + all_rounder_selected[i][1] + "-" + all_rounder_selected[i][2] + "-" + ";";
                        }
                    }
                    context.getSharedPreferences("no_of_allrounders_selected",MODE_PRIVATE).edit().putInt("allrounder_no",all_rounder_selected_count).commit();
                }
            });
        }
       else if(length==Team_players_data.batters_name.length) {
            holder.add_player.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    temp_bat="";
                    if(batters_selected[position][0]==null&&batter_selected_count<6){
                        batters_selected[position][0]=players_array[position][0];
                        batters_selected[position][1]=players_array[position][1];
                        batters_selected[position][2]=players_array[position][2];
                        batter_selected_count++;
                        holder.add_player.setCardBackgroundColor(context.getResources().getColor(R.color.selected));
                    }
                    else if(batters_selected[position][0]==null&&batter_selected_count==6)
                        Toast.makeText(context, "No more members of this group can be added", Toast.LENGTH_SHORT).show();
                    else if(batters_selected[position][0]!=null) {
                        batters_selected[position][0]=null;
                        batters_selected[position][1]=null;
                        batters_selected[position][2]=null;
                        batter_selected_count--;
                        holder.add_player.setCardBackgroundColor(context.getResources().getColor(R.color.not_selected));
                    }
                    for(int i=0;i<batters_selected.length;i++){
                        if(batters_selected[i][0]!=null) {
                            temp_bat += batters_selected[i][0] + "-" + batters_selected[i][1] + "-" + batters_selected[i][2] + "-" + ";";
                        }
                    }
                    context.getSharedPreferences("no_of_batters_selected",MODE_PRIVATE).edit().putInt("batter_no",batter_selected_count).commit();
                }
            });
        }
        else {
            holder.add_player.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    temp_bowl="";
                    if(bowlers_selected[position][0]==null&&bowler_selected_count<3){
                        bowlers_selected[position][0]=players_array[position][0];
                        bowlers_selected[position][1]=players_array[position][1];
                        bowlers_selected[position][2]=players_array[position][2];
                        bowler_selected_count++;
                        holder.add_player.setCardBackgroundColor(context.getResources().getColor(R.color.selected));
                    }
                    else if(bowlers_selected[position][0]==null&&bowler_selected_count==3)
                        Toast.makeText(context, "No more members of this group can be added", Toast.LENGTH_SHORT).show();
                    else if(bowlers_selected[position][0]!=null){
                        bowlers_selected[position][0]=null;
                        bowlers_selected[position][1]=null;
                        bowlers_selected[position][2]=null;
                        bowler_selected_count--;
                        holder.add_player.setCardBackgroundColor(context.getResources().getColor(R.color.not_selected));
                    }
                    for(int i=0;i<bowlers_selected.length;i++){
                        if(bowlers_selected[i][0]!=null) {
                            temp_bowl += bowlers_selected[i][0] + "-" + bowlers_selected[i][1] + "-" + bowlers_selected[i][2] + "-" + ";";
                        }
                    }
                    context.getSharedPreferences("no_of_bowlers_selected",MODE_PRIVATE).edit().putInt("bowler_no",bowler_selected_count).commit();
                }
            });

        }

        holder.player_name.setText(players_array[position][0]);
        holder.price_point.setText(players_array[position][1]);
        holder.playing_points.setText(players_array[position][2]);
        holder.submit_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(batter_selected_count+bowler_selected_count+all_rounder_selected_count==10){
                    String team="";
                    for(int i=0;i<6;i++){
                        if(batters_selected[i][0]!=null){
                            team+=batters_selected[i][0];
                            team+=',';
                            team+=batters_selected[i][1];
                            team+=',';
                            team+=batters_selected[i][2];
                            team+=';';
                        }
                    }
                    for(int i=0;i<3;i++){
                        if(bowlers_selected[i][0]!=null){
                            team+=bowlers_selected[i][0];
                            team+=',';
                            team+=bowlers_selected[i][1];
                            team+=',';
                            team+=bowlers_selected[i][2];
                            team+=';';
                        }
                    }
                    for(int i=0;i<1;i++){
                        if(all_rounder_selected[i][0]!=null){
                            team+=all_rounder_selected[i][0];
                            team+=',';
                            team+=all_rounder_selected[i][1];
                            team+=',';
                            team+=all_rounder_selected[i][2];
                            team+=';';
                        }
                    }
                    if(context.getSharedPreferences("team_name_preference",MODE_PRIVATE).getInt("team_number",0)==1){
                        team1=team;
                        bowlers_selected=new String[Team_players_data.bowlers_name.length][3];
                        batters_selected=new String[Team_players_data.batters_name.length][3];
                        all_rounder_selected=new String[Team_players_data.all_rounders_name.length][3];
                        bowler_selected_count=0;
                        batter_selected_count=0;
                        all_rounder_selected_count=0;
                        check_preexistence_of_team(context.getSharedPreferences("team_name_preference",MODE_PRIVATE).getInt("team_number",0),team);
                    }
                    else if(context.getSharedPreferences("team_name_preference",MODE_PRIVATE).getInt("team_number",0)==2){
                        team2=team;
                        bowlers_selected=new String[Team_players_data.bowlers_name.length][3];
                        batters_selected=new String[Team_players_data.batters_name.length][3];
                        all_rounder_selected=new String[Team_players_data.all_rounders_name.length][3];
                        bowler_selected_count=0;
                        batter_selected_count=0;
                        all_rounder_selected_count=0;
                        check_preexistence_of_team(context.getSharedPreferences("team_name_preference",MODE_PRIVATE).getInt("team_number",0),team);
                    }
                    else if(context.getSharedPreferences("team_name_preference",MODE_PRIVATE).getInt("team_number",0)==3)
                    {
                        team3=team;
                        bowlers_selected=new String[Team_players_data.bowlers_name.length][3];
                        batters_selected=new String[Team_players_data.batters_name.length][3];
                        all_rounder_selected=new String[Team_players_data.all_rounders_name.length][3];
                        bowler_selected_count=0;
                        batter_selected_count=0;
                        all_rounder_selected_count=0;
                        check_preexistence_of_team(context.getSharedPreferences("team_name_preference",MODE_PRIVATE).getInt("team_number",0),team);

                    }
                    else
                        Toast.makeText(context, "Team number not selected", Toast.LENGTH_SHORT).show();


                }else{
                    Toast.makeText(context, "More members needed to be selected", Toast.LENGTH_SHORT).show();
                   // Toast.makeText(context, "temp batters -"+temp_bat, Toast.LENGTH_SHORT).show();
                } }
        });
    }

    @Override
    public int getItemCount() {
        return length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView player_name,price_point,playing_points;
        CardView team_maker_cardview,add_player;
        Button submit_team;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            player_name=itemView.findViewById(R.id.player_name);
            price_point=itemView.findViewById(R.id.price_points_text);
            playing_points=itemView.findViewById(R.id.playing_points_text);
            team_maker_cardview=itemView.findViewById(R.id.team_maker_cardview);
            add_player=itemView.findViewById(R.id.add_player);
            submit_team=team_maker.findViewById(R.id.submit_team);
        }



    }

  //  public JSONObject makejsonobject(int team_number,String[][] teamlist) throws  JSONException {
    //    JSONObject obj =null;
      //  JSONArray jsonArray = new JSONArray();
        //for(int i=0;i<10;i++){
          //  obj=new JSONObject();
            //try{
              //  obj.put("id",i);
                //obj.put("name",teamlist[i][0]);
                //obj.put("price_points",teamlist[i][1]);
                //obj.put("playing_points",teamlist[i][2]);
                //obj.put("team_number",teamlist[i][3]);
            //}catch (Exception e){
              //  e.printStackTrace();
            //}
            //jsonArray.put(obj);
        //}
        //JSONObject finalobject = new JSONObject();
        //finalobject.put("Team_"+team_number, jsonArray);
        //return finalobject;
    //}

    public void check_preexistence_of_team( int team_number,  String teamdata){
        String preference,key,data;
        final int[] teamnumber={context.getSharedPreferences("team_name_preference",MODE_PRIVATE).getInt("team_number",0)};
        final String[] team={teamdata};
        preference=null;
        key=null;
        data=null;
        if(context.getSharedPreferences("team_name_preference",MODE_PRIVATE).getInt("team_number",0)==1){
            preference="team1_list";
            key="team1";
        }
        if(context.getSharedPreferences("team_name_preference",MODE_PRIVATE).getInt("team_number",0)==2){
            preference="team2_list";
            key="team2";
        }
        if(context.getSharedPreferences("team_name_preference",MODE_PRIVATE).getInt("team_number",0)==3){
            preference="team3_list";
            key="team3";
        }

        if(preference!=null&&key!=null){
            data=context.getSharedPreferences(preference,MODE_PRIVATE).getString(key,null);
        }

        if(data!=""||data!=null){
            AlertDialog.Builder builder=new AlertDialog.Builder(context);
            builder.setMessage("Overwrite previously made team");
            builder.setTitle("Warning");
            builder.setCancelable(false);

            final String[] finalPreference = {preference};
            final String[] finalKey = {key};
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(context, "Team "+teamnumber[0]+" is changed", Toast.LENGTH_SHORT).show();
                    context.getSharedPreferences(finalPreference[0],MODE_PRIVATE).edit().putString(finalKey[0],team[0]).apply();
                    Intent i=new Intent(context,Match_starts.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    context.startActivity(i);
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(context, "Team not changed", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                }
            });


            AlertDialog alertDialog = builder.create();


            alertDialog.show();

        }
        else {
            Toast.makeText(context, "Team "+team_number+" is stored", Toast.LENGTH_SHORT).show();
            context.getSharedPreferences(preference,MODE_PRIVATE).edit().putString(key,teamdata).apply();
            Intent i=new Intent(context,Match_starts.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(i);
        }

    }

}