package com.bellarix.socializaproto;

import android.widget.ImageView;

import java.text.NumberFormat;

/**
 * Created by flakoloko32 on 7/26/2015.
 */
public class Offer {
    // define attributes of an item
    public String title;
    public String likesNumber;
    public String price;

    // create a constructor
    public Offer(String title, String likesNumber, String price){
        this.title = title;
        this.likesNumber = likesNumber;
        this.price = "$"+price;
    }


}
