package com.nbastats;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by kevin_maussion on 09/04/2016.
 */
public class Row implements Serializable {
    private Drawable draw;
    private String pseudo;
    private String text;

    public Row(Drawable draw, String pseudo, String text) {
        this.draw = draw;
        this.pseudo = pseudo;
        this.text = text;
    }

    public Drawable getDrawable(){
        return draw;
    }

    public String getPseudo(){
        return pseudo;
    }

    public String getText(){ return text; }

    public void setImage(Drawable image){
         this.draw = draw;
    }

    public void setPseudo(String pseudo){
        this.pseudo = pseudo;
    }

    public void setText(String text){
        this.text = text;
    }
}
