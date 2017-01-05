package com.pensar.tabkids.appstore.makeaword;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by root on 3/1/17.
 */

public class CardViewContent implements Parcelable{

    private String imageName;
    private int image;



    public CardViewContent(String imageName, int image){
        this.imageName= imageName;
        this.image = image;
    }

    public CardViewContent(String imageName){

        this.imageName=imageName;

    }

    protected CardViewContent(Parcel in) {
        imageName = in.readString();
        image = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageName);
        dest.writeInt(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CardViewContent> CREATOR = new Creator<CardViewContent>() {
        @Override
        public CardViewContent createFromParcel(Parcel in) {
            return new CardViewContent(in);
        }

        @Override
        public CardViewContent[] newArray(int size) {
            return new CardViewContent[size];
        }
    };

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
