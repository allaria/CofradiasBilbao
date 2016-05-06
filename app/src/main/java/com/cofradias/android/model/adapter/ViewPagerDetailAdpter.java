package com.cofradias.android.model.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cofradias.android.R;
import com.cofradias.android.model.Cofradia;
import com.cofradias.android.model.DetailCofradia;
import com.cofradias.android.model.DetailDetalle;
import com.cofradias.android.model.Fragment3;

public class ViewPagerDetailAdpter extends FragmentPagerAdapter {

    public Context context;
    private String tab1, tab2, tab3;
    //private String tab2;
    private String[] tabtitlearray = new String[3];

    Cofradia[] cofradiaList;
    DetailCofradia.InterfaceDetailCofradia activity;

    public ViewPagerDetailAdpter(DetailCofradia.InterfaceDetailCofradia activity, FragmentManager manager, Context context, Cofradia[] cofradiaList){
        super(manager);
        this.context = context;
        this.cofradiaList = cofradiaList;
        this.activity=activity;

        tab1 = context.getString(R.string.tab_detail_one);
        tab2 = context.getString(R.string.tab_detail_two);
        tab3 = context.getString(R.string.tab_detail_three);

        tabtitlearray[0]=tab1;
        tabtitlearray[1]=tab2;
        tabtitlearray[2]=tab3;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0: {
                DetailCofradia fragmentDetailCofradia = new DetailCofradia();
                fragmentDetailCofradia.setCofradia(cofradiaList[position]);
                fragmentDetailCofradia.setListener(activity);
                return fragmentDetailCofradia;
            }
            case 1: {
                DetailDetalle fragmentDetailDetalle = new DetailDetalle();
                fragmentDetailDetalle.setCofradia(cofradiaList[0]);
                return fragmentDetailDetalle;
            }
            case 2: {
                return new Fragment3();
            }

        }


        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabtitlearray[position];
    }
}
