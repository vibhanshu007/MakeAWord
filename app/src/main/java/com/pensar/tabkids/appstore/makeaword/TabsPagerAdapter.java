package com.pensar.tabkids.appstore.makeaword;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2/1/17.
 */

public class TabsPagerAdapter extends FragmentStatePagerAdapter {

    int noOfTabs;
    List<CardViewContent> cardViewContentList;
    public TabsPagerAdapter(FragmentManager fm , int NoOfTabs) {
        super(fm);
        this.noOfTabs= NoOfTabs;
        cardViewContentList = new ArrayList<CardViewContent>();
        cardViewContentList.add(new CardViewContent("apple"));
        cardViewContentList.add(new CardViewContent("bell"));
        cardViewContentList.add(new CardViewContent("car"));
        cardViewContentList.add(new CardViewContent("dice"));
        cardViewContentList.add(new CardViewContent("earth"));
        cardViewContentList.add(new CardViewContent("fish"));
        cardViewContentList.add(new CardViewContent("gift"));
        cardViewContentList.add(new CardViewContent("heart"));
        cardViewContentList.add(new CardViewContent("ice"));
        cardViewContentList.add(new CardViewContent("joker"));
        cardViewContentList.add(new CardViewContent("knife"));
        cardViewContentList.add(new CardViewContent("lion"));

    }

    @Override
    public Fragment getItem(int position) {

        WordLetters wordLetters;
        switch (position){
            case 0:
                 wordLetters = WordLetters.getInstance(cardViewContentList);
                return wordLetters;

            case 1:
                 wordLetters = WordLetters.getInstance(cardViewContentList);
                return wordLetters;

        }
        return null;
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }

    public void selectItem(){

    }
}
