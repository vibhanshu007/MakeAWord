package com.pensar.tabkids.appstore.makeaword;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by root on 4/1/17.
 */

public class CommonUtil {

    public static Bitmap getDataFromAsserts(Context context,String filePath){
        AssetManager assetManager = context.getAssets();
        
        Bitmap bitmap =null;
        InputStream inputStream;
        
        try {
            inputStream = assetManager.open(filePath);
            bitmap = BitmapFactory.decodeStream(inputStream);
        }catch (IOException e){
            
        }
        return bitmap;
    }

    public static BitmapDrawable getBitmapDrawableFromAsserts(Context context,String filepath){

        return new BitmapDrawable(context.getResources(),getDataFromAsserts(context,filepath));


    }
}
