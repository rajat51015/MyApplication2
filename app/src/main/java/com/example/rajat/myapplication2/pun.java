package com.example.rajat.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;


public  class pun extends AppCompatActivity {
    Bundle e;
    DBHelper f;
    ImageView v, n;long k;Bitmap bp1;
    Button tb;
    Bitmap bp;
    String t2, t3;Context ct=this;
    public static long t;public ArrayAdapter m;
    public static int qq;
    public static String encodeTobase64(Bitmap image) {
        Bitmap immage = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immage.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);

        Log.d("Image Log:", imageEncoded);
        return imageEncoded;
    }

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

            bp1 = BitmapFactory.decodeByteArray(l, 0, l.length);
            v.setImageBitmap(bp1);
        }
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                k=t+1;


                Bitmap bp = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                ImageView iv = (ImageView) findViewById(R.id.im1);
                iv.setImageBitmap(bp);
                SharedPreferences userDetails = ct.getSharedPreferences("userdetails", MODE_PRIVATE);
                SharedPreferences.Editor edit = userDetails.edit();
                edit.putString("username", t2);
                edit.putString("password", t3);
                edit.putString("image",encodeTobase64(bp1));
                edit.commit();

                f.delete(String.valueOf(k));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(pun.this,HITLIST.class);
                        startActivity(i);
                        finish();
                    }
                }, 3000);







/* wordsclass p=new wordsclass(t2,t3,bp);
            /* Intent i=new Intent(pun.this,HITLIST.class);
                i.putExtra("hi",t2);
startActivity(i);*/
                //  i.putExtra("hii",t3);
                //i.putExtra("hiii",bp);

            }
        });


    }

}
