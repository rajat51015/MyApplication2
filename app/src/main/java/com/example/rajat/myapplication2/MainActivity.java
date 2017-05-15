package com.example.rajat.myapplication2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import com.example.rajat.myapplication2.R;



/**
 * Displays a {@link ViewPager} where each page shows a different day of the week.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
DBHelper f=new DBHelper(this);
        f.add(new detail(0,"NAME-Cersie Lannister","HOUSE-Lannister", BitmapFactory.decodeResource(getResources(),R.drawable.c)));
        f.add(new detail(1,"NAME-Joffery","HOUSE-Lannister", BitmapFactory.decodeResource(getResources(),R.drawable.joff)));
        f.add(new detail(2,"NAME-Hound","HOUSE-Clegane", BitmapFactory.decodeResource(getResources(),R.drawable.hound)));
         f.add(new detail(3,"NAME-Meryn","HOUSE-Trant", BitmapFactory.decodeResource(getResources(),R.drawable.meryn)));
               f.add(new detail(4,"NAME-Thoros","HOUSE-Myr", BitmapFactory.decodeResource(getResources(),R.drawable.thoros)));
               f.add(new detail(5,"NAME-Beric","HOUSE-Dondarion", BitmapFactory.decodeResource(getResources(),R.drawable.beric)));
               f.add(new detail(6,"NAME-Mellisandre","HOUSE-Baratheon", BitmapFactory.decodeResource(getResources(),R.drawable.mellisan)));
               f.add(new detail(7,"NAME-Gregor","HOUSE-Clegane", BitmapFactory.decodeResource(getResources(),R.drawable.gregor)));
               f.add(new detail(8,"NAME-Tywin","HOUSE-Lannister", BitmapFactory.decodeResource(getResources(),R.drawable.tywin)));
               f.add(new detail(9,"NAME-Walder Frey","HOUSE-Frey", BitmapFactory.decodeResource(getResources(),R.drawable.frey)));
               f.add(new detail(10,"NAME-Ilyn","HOUSE-Payne", BitmapFactory.decodeResource(getResources(),R.drawable.ilyn)));
               f.add(new detail(11,"NAME-Amory","HOUSE-Lorch",BitmapFactory.decodeResource(getResources(),R.drawable.amory)));
       new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                 Intent mainIntent = new Intent(MainActivity.this, pager.class);
                mainIntent.putExtra("d",2);
                startActivity(mainIntent);
finish();
            }
        }, 3000);


        }



}