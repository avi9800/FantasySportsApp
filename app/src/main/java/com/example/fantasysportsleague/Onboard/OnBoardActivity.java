package com.example.fantasysportsleague.Onboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fantasysportsleague.Profile_maker;
import com.example.fantasysportsleague.R;
import com.google.android.material.tabs.TabLayout;

public class OnBoardActivity extends AppCompatActivity {

    private ViewPager Slideviewpager;
    private SlideAdapter slideAdapter;


    TextView nextbutton,previousbutton;

    private int CurrentPage=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);


        Slideviewpager=findViewById(R.id.slide_viewpager);

        nextbutton=findViewById(R.id.next);
        previousbutton=findViewById(R.id.previous);

        slideAdapter=new SlideAdapter(this);

        Slideviewpager.setAdapter(slideAdapter);

        TabLayout tabLayout=findViewById(R.id.DotItem);
        tabLayout.setupWithViewPager(Slideviewpager,true);


        Slideviewpager.addOnPageChangeListener(viewListener);
         nextbutton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Slideviewpager.setCurrentItem(CurrentPage+1);
             }
         });

    }


    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(final int position) {
                CurrentPage=position;

                if(position==0){
                    previousbutton.setEnabled(false);
                    nextbutton.setEnabled(true);

                    previousbutton.setVisibility(View.INVISIBLE);
                    nextbutton.setText("Skip");
                    previousbutton.setText("");
                }
                else if(position==2){
                    previousbutton.setEnabled(true);
                    nextbutton.setEnabled(true);

                    previousbutton.setVisibility(View.VISIBLE);
                    nextbutton.setText("Get Started");
                    previousbutton.setText("Back");

                }
                else {
                    previousbutton.setEnabled(true);
                    nextbutton.setEnabled(true);

                    previousbutton.setVisibility(View.VISIBLE);
                    nextbutton.setText("Skip");
                    previousbutton.setText("Back");
                }

            nextbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(nextbutton.getText()!="Get Started"){
                        Slideviewpager.setCurrentItem(CurrentPage+1);
                    }
                    else {
                        finish();
                        startActivity(new Intent(OnBoardActivity.this, Profile_maker.class));
                    }
                }
            });
            previousbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Slideviewpager.setCurrentItem(CurrentPage-1);
                }
            });
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}