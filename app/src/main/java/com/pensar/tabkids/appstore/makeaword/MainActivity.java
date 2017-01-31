package com.pensar.tabkids.appstore.makeaword;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {


    Toolbar toolbar;
    ArrayList<CardViewContent> cardViewContents = new ArrayList<>();
    ArrayList<String> selectedItem = new ArrayList<String>();
    boolean is_in_actionMode= false;
    int counter = 0;
    FloatingActionButton fab;
    TextView counterTextView;
    TabsPagerAdapter adapter;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layOut);
        tabLayout.addTab(tabLayout.newTab().setText("Three Letters"));
        tabLayout.addTab(tabLayout.newTab().setText("Four Letters"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        counterTextView = (TextView) findViewById(R.id.counter_text);
        counterTextView.setVisibility(View.GONE);
        fab.setVisibility(View.GONE);

        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new TabsPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.e("current Item",""+viewPager.getCurrentItem());
                changeNormalView();
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
               // Log.e("current Item@@@",""+viewPager.getCurrentItem());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
               // Log.e("current Item@@@",""+viewPager.getCurrentItem());

            }


        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent(getApplicationContext(),StartActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == android.R.id.home){
            changeNormalView();
        }

        return true;
    }


    public void prepareSelection(CompoundButton checkBox,int selectedPosition){
        Log.e("checkBox.isChecked()",""+checkBox.isChecked());
        if (checkBox.isChecked()){
            selectedItem.add(String.valueOf(selectedPosition));
            counter=counter+1;
            updateCounter(counter);
        }else {
            selectedItem.remove(String.valueOf(selectedPosition));
            counter = counter-1;
            updateCounter(counter);
        }
    }
    public void updateCounter(int counter){
        if (counter==0){
            counterTextView.setText("0 item Selcted");
        }else {
            counterTextView.setText(counter+" item Selected");
        }

    }



    public void cleanActionMode(){
        is_in_actionMode=false;
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.menu_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        counterTextView.setVisibility(View.GONE);
        fab.setVisibility(View.GONE);
        counterTextView.setText("Make A Word");
        counter=0;
        selectedItem.clear();
    }

    @Override
    public void onBackPressed() {

        if (is_in_actionMode){
            changeNormalView();
        }else {
            super.onBackPressed();
        }
    }
    public void changeNormalView(){
        cleanActionMode();
        adapter.getWordLetters(viewPager.getCurrentItem()).updateList();
    }

}
