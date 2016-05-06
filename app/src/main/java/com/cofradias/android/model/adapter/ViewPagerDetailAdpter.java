package com.cofradias.android.model.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cofradias.android.R;
import com.cofradias.android.model.Cofradia;
import com.cofradias.android.model.Fragment1;
import com.cofradias.android.model.Fragment2;

public class ViewPagerDetailAdpter extends FragmentPagerAdapter {

    public Context context;
    private String tab1;
    private String tab2;
    private String[] tabtitlearray = new String[2];

    Cofradia[] cofradiaList;
    Fragment1.interfaceFragment1 act;

    public ViewPagerDetailAdpter(Fragment1.interfaceFragment1 act, FragmentManager manager, Context context, Cofradia[] cofradiaList){
        super(manager);
        this.context = context;
        this.cofradiaList = cofradiaList;
        this.act=act;

        tab1 = context.getString(R.string.tab_detail_one);
        tab2 = context.getString(R.string.tab_detail_two);
        tabtitlearray[0]=tab1;
        tabtitlearray[1]=tab2;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0: {
                Fragment1 fragment1 = new Fragment1();
                fragment1.setCofradia(cofradiaList[position]);
                fragment1.setListener(act);
                return fragment1;
            }
            case 1: return new Fragment2();
        }


        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabtitlearray[position];
    }
}
