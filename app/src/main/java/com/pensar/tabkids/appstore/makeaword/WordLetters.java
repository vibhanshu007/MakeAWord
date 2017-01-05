package com.pensar.tabkids.appstore.makeaword;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class WordLetters extends Fragment {

    private RecyclerView recyclerView;
    CardViewAdapter cardViewAdapter;
    List<CardViewContent> cardViewContentList;
    GridSpacingItemDecoration gridSpacingItemDecoration;

    public static WordLetters getInstance(List<CardViewContent> cardViewContentList) {

        WordLetters wordLetters =new WordLetters();
        Bundle bundle=new Bundle(1);
        bundle.putParcelableArrayList("list", (ArrayList<? extends Parcelable>) cardViewContentList);
        wordLetters.setArguments(bundle);
        return wordLetters;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cardViewContentList=getArguments().getParcelableArrayList("list");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.fragment_word_letters, container, false);
        // Inflate the layout for this fragment
        recyclerView = (RecyclerView)root.findViewById(R.id.recycler_view);


        cardViewAdapter = new CardViewAdapter(getContext(),cardViewContentList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(getContext(),2,10,true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cardViewAdapter);


        return root;
    }

        private void prepareAlbums() {

    }

}
