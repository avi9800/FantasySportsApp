package com.example.fantasysportsleague.MainActivities.Adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fantasysportsleague.R;

public class Create_match_adapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_private_match_item,parent,false);
        return new Create_match_adapter.ListViewHolder(view);
    }

    public void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.2f, 3.0f);
        anim.setDuration(2000);
        view.startAnimation(anim);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        setFadeAnimation(holder.itemView);
        ((Create_match_adapter.ListViewHolder)holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    private static class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView info;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            info=itemView.findViewById(R.id.info_of_player);

        }

        public void bindView(int position){
            info.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Context context=v.getContext();
            if(v.getId()==info.getId())
                Toast.makeText(context, "Info of User", Toast.LENGTH_SHORT).show();

        }
    }

}
