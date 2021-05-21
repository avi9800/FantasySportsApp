package com.example.fantasysportsleague.MainActivities.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fantasysportsleague.MainActivities.Match_starts;
import com.example.fantasysportsleague.MainActivities.TeamMaker;
import com.example.fantasysportsleague.R;

public class enter_choose_a_contest_adapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_enter_contest_item,parent,false);
        return new enter_choose_a_contest_adapter.ListViewHolder(view);
    }

    public void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.2f, 3.0f);
        anim.setDuration(2000);
        view.startAnimation(anim);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        setFadeAnimation(holder.itemView);
        ((enter_choose_a_contest_adapter.ListViewHolder)holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    private static class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private CardView cardView;
        private TextView match_name;
        private Button join,create_team;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.contest_details);
            match_name=itemView.findViewById(R.id.match_name);
            join=itemView.findViewById(R.id.join_match);
            create_team=itemView.findViewById(R.id.Create_team_button);
        }

        public void bindView(int position){
            match_name.setText("ODI "+(position+1));
            cardView.setOnClickListener(this);
            join.setOnClickListener(this);
            create_team.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Context context=v.getContext();
            if(v.getId()==cardView.getId())
                Toast.makeText(context, "Show match details of "+(getAdapterPosition()+1), Toast.LENGTH_SHORT).show();
            if(v.getId()==create_team.getId()){
                Toast.makeText(context, "Create a team for contest "+(getAdapterPosition()+1), Toast.LENGTH_SHORT).show();
                Intent i=new Intent(context, TeamMaker.class);
                i.putExtra("contest_number",(getAdapterPosition()+1));
                context.startActivity(i);
            }
            if(v.getId()==join.getId()){
                Toast.makeText(context, "Create a team for contest "+(getAdapterPosition()+1), Toast.LENGTH_SHORT).show();
                Intent i=new Intent(context, Match_starts.class);
                i.putExtra("contest_number",(getAdapterPosition()+1));
                context.startActivity(i);
            }
        }
    }
}
