package com.example.fantasysportsleague.MainActivities.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.fantasysportsleague.MainActivities.Tabs.All_fragment;
import com.example.fantasysportsleague.MainActivities.Tabs.All_rounder_fragment;
import com.example.fantasysportsleague.MainActivities.Tabs.Batter_fragment;
import com.example.fantasysportsleague.MainActivities.Tabs.Bowler_fragment;
import com.example.fantasysportsleague.R;

public class tab_adapter extends FragmentPagerAdapter{
    public int tabcounts;
    public String name;
    public View view;
    TableLayout tb;

    public tab_adapter(FragmentManager fm, int numberoftabs, View view)
    {//,String name) {
        super(fm);
        this.tabcounts=numberoftabs;
        this.view=view;
    }



    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        // Bundle bundle=new Bundle();
        // bundle.putString("buttonname",name);
        switch (position){
            case 0:
                fragment=new Batter_fragment(view);
                // fragment.setArguments(bundle);
                break;
            case 1:
                fragment=new Bowler_fragment(view);
                break;
            case 2:
                fragment=new All_rounder_fragment(view);
                break;
            case 3:
                fragment=new All_fragment(view);
                break;
            default:
                fragment= null;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return tabcounts;
    }

}