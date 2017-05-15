package com.example.rajat.myapplication2;

import android.graphics.Bitmap;

/**
 * Created by rajat on 12/5/17.
 */

public class wordsclass {

    private String name;
    private String house;
   private Bitmap p;


wordsclass (String n1,String h1,Bitmap t)
{
    this.name=n1;
    this.house=h1;
    this.p=t;

}

public  String gn()
{
    return name;
}
public String gh()
{
    return house;
}
public Bitmap gid()
{
    return p;
}
}