package com.example.veny.venyamiliafitri_1202150243_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by Veny on 2/23/2018.
 */

public class Drink {
    private final String title;
    private final String info;
    private final int imageResource;
    private final String detailDrink;

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "Image Resource";
    static final String DETAIL_KEY = "Detail";

    //konstruktor Drink yang berisi parameter untuk title, info, imageResource dan Detail
    Drink(String title, String info, int imageResource, String detailDrink) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
        this.detailDrink = detailDrink;
    }

    //getter untuk title drink
    String getTitle(){
        return title;
    }

    //getter untuk info drink
    String getInfo(){
        return info;
    }

    //getter untuk imageResource drink
    int getImageResource(){
        return imageResource;
    }

    //getter untuk detail drink
    String getDetail() {
        return detailDrink;
    }

    //Intent dan putExtra dari MainActivity ke DetailActivity
    static Intent starter(Context context, String title, @DrawableRes int imageResId, String detailDrink) {
        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra(TITLE_KEY, title);
        detailIntent.putExtra(IMAGE_KEY, imageResId);
        detailIntent.putExtra(DETAIL_KEY, detailDrink);
        return detailIntent;
    }
}
