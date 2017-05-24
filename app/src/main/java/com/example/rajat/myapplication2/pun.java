package com.example.rajat.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.util.ArrayList;




public  class pun extends AppCompatActivity {
    Bundle e;
    DBHelper f;
    ImageView v, n;long k;
    Button tb;
    Bitmap bp;
    String t2, t3;
    public static long t;public ArrayAdapter m;
    public static int qq;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pun);

        Intent in = getIntent();
        v = (ImageView) findViewById(R.id.im);

        tb = (Button) findViewById(R.id.button);
        e = in.getExtras();
        t = e.getLong("key");
        f = new DBHelper(this);
        Cursor d = f.getData(String.valueOf(t + 1));
        while (d.moveToNext()) {
            t2 = d.getString(1);
            t3 = d.getString(2);
            byte l[] = d.getBlob(3);

            bp = BitmapFactory.decodeByteArray(l, 0, l.length);
            v.setImageBitmap(bp);
        }
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                k=t+1;

                Bitmap bp = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                ImageView iv = (ImageView) findViewById(R.id.im1);
                iv.setImageBitmap(bp);

                f.delete(String.valueOf(k));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(pun.this,KILL.class);
                        startActivity(i);
                        finish();
                    }
                }, 3000);







/* wordsclass p=new wordsclass(t2,t3,bp);
            /* Intent i=new Intent(pun.this,KILL.class);
                i.putExtra("hi",t2);
startActivity(i);*/
                //  i.putExtra("hii",t3);
                //i.putExtra("hiii",bp);

            }
        });


    }

}
