package com.example.rajat.myapplication2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

/**
 * Created by rajat on 12/5/17.
 */

public class detail {

    private int id;
    private String name;
    private String house;
    Bitmap p;

    detail(int a,String b,String c,Bitmap p1)
    {
        id=a;
        name=b;
        house=c;
        p=p1;
    }


     public void setId(int id1)
    {
this.id=id1;
    }
 public void setName(String s)
{
    this.name=s;
}

    public void setHouse(String s1)
    {
        this.house=s1;
    }

public int getid()
{
    return id;
}
public String getname()
{
    return name;
}

    public String gethouse()
    {
        return house;
    }

public void seti(Bitmap b)
{
    this.p=b;
}
public byte[] getbh()
{
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    this.p.compress(Bitmap.CompressFormat.PNG, 0, stream);
    return stream.toByteArray();
}
    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
}
