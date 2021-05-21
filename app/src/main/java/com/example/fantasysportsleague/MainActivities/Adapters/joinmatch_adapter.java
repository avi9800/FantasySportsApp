package com.example.fantasysportsleague.MainActivities.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fantasysportsleague.MainActivities.Enter_contest;
import com.example.fantasysportsleague.R;

public class joinmatch_adapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.join_match,parent,false);
        return new ListViewHolder(view);
    }

    public void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.2f, 3.0f);
        anim.setDuration(2000);
        view.startAnimation(anim);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        setFadeAnimation(holder.itemView);
        ((ListViewHolder)holder).bindView(position);

    }

    @Override
    public int getItemCount() {
        return 10;
    }


    private static class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageButton team1_image,team2_image;
        private TextView team1_name,team2_name,status;
        private CardView cardView_item;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            team1_image=itemView.findViewById(R.id.team1_image);
            team2_image=itemView.findViewById(R.id.team2_image);
            team1_name=itemView.findViewById(R.id.team1_name);
            team2_name=itemView.findViewById(R.id.team2_name);
            status=itemView.findViewById(R.id.status);
            cardView_item=itemView.findViewById(R.id.matches_cardview);
            cardView_item.setOnClickListener(this);

        }

        public void bindView(int position){

            team1_image.setBackgroundResource(R.drawable.indian_logo);
            team2_image.setBackgroundResource(R.drawable.pakistan_logo);
            team1_name.setText("IND");
            team2_name.setText("PAK");
            if(position%2==0)
                status.setText("Open");
            else
                status.setText("Closed");
        }


        @Override
        public void onClick(View v) {
            Context context=v.getContext();
            if(v.getId()==cardView_item.getId()){
                Intent intent=new Intent(context, Enter_contest.class);
                intent.putExtra("match_id",getAdapterPosition());
                context.startActivity(intent);
            }
        }

    }
}
