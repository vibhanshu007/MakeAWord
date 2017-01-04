package com.pensar.tabkids.appstore.makeaword;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ThreeLetters extends Fragment {

    private RecyclerView recyclerView;
    CardViewAdapter cardViewAdapter;
    List<CardViewContent> cardViewContentList;
    GridSpacingItemDecoration gridSpacingItemDecoration;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.fragment_three_letters, container, false);
        // Inflate the layout for this fragment
        recyclerView = (RecyclerView)root.findViewById(R.id.recycler_view);
        cardViewContentList = new ArrayList<>();
        cardViewContentList.add(new CardViewContent("apple"));
        cardViewContentList.add(new CardViewContent("bell"));
        cardViewContentList.add(new CardViewContent("car"));
        cardViewContentList.add(new CardViewContent("dice"));
        cardViewContentList.add(new CardViewContent("earth"));
        cardViewContentList.add(new CardViewContent("fish"));
        cardViewContentList.add(new CardViewContent("gift"));
        cardViewContentList.add(new CardViewContent("heart"));
        cardViewAdapter = new CardViewAdapter(getContext(),cardViewContentList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(getContext(),2,10,true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cardViewAdapter);


        return root;
    }

        private void prepareAlbums() {

    }

}
