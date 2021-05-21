package com.example.fantasysportsleague.Onboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.fantasysportsleague.R;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context){
        this.context=context;
    }

    public String[] slide_text={
            "Welcome to Fantasy League",
            "Create you own team",
            "Predict , play and earn money easily!!!"
    };

    @Override
    public int getCount() {
        return slide_text.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);

        TextView onBoard_slide_text=view.findViewById(R.id.onboardtext);
        onBoard_slide_text.setText(slide_text[position]);

        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }
}
