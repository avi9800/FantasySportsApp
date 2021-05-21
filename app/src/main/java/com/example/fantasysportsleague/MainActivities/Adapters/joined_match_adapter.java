package com.example.fantasysportsleague.MainActivities.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fantasysportsleague.R;

public class joined_match_adapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_private_match_item,parent,false);
        return new joined_match_adapter.ListViewHolder(view);
    }

    public void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.2f, 3.0f);
        anim.setDuration(2000);
        view.startAnimation(anim);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        setFadeAnimation(holder.itemView);
        ((joined_match_adapter.ListViewHolder)holder).bindView(position);
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

        }

        public void bindView(int position){

        }

        @Override
        public void onClick(View v) {
            Context context=v.getContext();

        }
    }
}
