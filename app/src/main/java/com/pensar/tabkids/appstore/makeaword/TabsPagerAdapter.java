package com.pensar.tabkids.appstore.makeaword;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by root on 2/1/17.
 */

public class TabsPagerAdapter extends FragmentStatePagerAdapter {

    int noOfTabs;

    public TabsPagerAdapter(FragmentManager fm , int NoOfTabs) {
        super(fm);
        this.noOfTabs= NoOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:
                ThreeLetters threeLetters = new ThreeLetters();
                return threeLetters;

            case 1:
                FourLetters fourLetters = new FourLetters();
                return fourLetters;

        }
        return null;
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
