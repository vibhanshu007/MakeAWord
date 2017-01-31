package com.pensar.tabkids.appstore.makeaword;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        CommonUtil.hideSystemUI(getWindow().getDecorView());
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}