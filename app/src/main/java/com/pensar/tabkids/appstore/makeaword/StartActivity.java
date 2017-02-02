package com.pensar.tabkids.appstore.makeaword;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class StartActivity extends AppCompatActivity {

    ImageView questionImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        CommonUtil.hideSystemUI(getWindow().getDecorView());
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        questionImage = (ImageView)findViewById(R.id.image_question);

    }
}
