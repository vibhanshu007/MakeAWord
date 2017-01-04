package com.pensar.tabkids.appstore.makeaword;

/**
 * Created by root on 3/1/17.
 */

public class CardViewContent {

    private String imageName;
    private int image;



    public CardViewContent(String imageName, int image){
        this.imageName= imageName;
        this.image = image;
    }

    public CardViewContent(String imageName){

        this.imageName=imageName;

    }

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
