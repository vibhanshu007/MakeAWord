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
    List<CardViewContent> threeLettersContent;
    List<CardViewContent> fourLettersContentList;
        public TabsPagerAdapter(FragmentManager fm , int NoOfTabs) {
        super(fm);
        this.noOfTabs= NoOfTabs;
        threeLettersContent = new ArrayList<CardViewContent>();
        fourLettersContentList = new ArrayList<CardViewContent>();
            //three letter word
        threeLettersContent.add(new CardViewContent("car"));
        threeLettersContent.add(new CardViewContent("ice"));

            //four letter word

            fourLettersContentList.add(new CardViewContent("apple"));
            fourLettersContentList.add(new CardViewContent("bell"));
            fourLettersContentList.add(new CardViewContent("dice"));
            fourLettersContentList.add(new CardViewContent("earth"));
            fourLettersContentList.add(new CardViewContent("fish"));
            fourLettersContentList.add(new CardViewContent("gift"));
            fourLettersContentList.add(new CardViewContent("heart"));
            fourLettersContentList.add(new CardViewContent("joker"));
            fourLettersContentList.add(new CardViewContent("knife"));
            fourLettersContentList.add(new CardViewContent("lion"));

    }

    @Override
    public Fragment getItem(int position) {

        WordLetters wordLetters;
        switch (position){
            case 0:
                 wordLetters = WordLetters.getInstance(threeLettersContent);
                return wordLetters;

            case 1:
                 wordLetters = WordLetters.getInstance(fourLettersContentList);
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
