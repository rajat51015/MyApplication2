package com.example.rajat.myapplication2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.example.rajat.myapplication2.DBHelper.dbname;
import static com.example.rajat.myapplication2.pun.qq;

/**
 * Fragment that displays "Tuesday".
 */
public class KILL extends Fragment {
    String a, b;public long h;
    DBHelper f; public long o1=0;
    Cursor d;int k=1;static Intent ii=new Intent();
    Context l;Bundle e=null;
    ListView listView1;
       ArrayList<wordsclass> words1 = new ArrayList<wordsclass>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v1 = inflater.inflate(R.layout.fragment_tuesday, container, false);
        f = new DBHelper(getActivity());
        int profile_counts = f.getProfilesCount();



            //  SQLiteDatabase db = f.getWritableDatabase();

            //f.delete(m);}


        Cursor d = f.getData(String.valueOf(k));

    while (d.moveToNext()) {
        a = d.getString(1);
        b = d.getString(2);
        byte l[] = d.getBlob(3);
        Bitmap bp = BitmapFactory.decodeByteArray(l, 0, l.length);

        words1.add(new wordsclass(a, b, bp));
        k++;
        d = f.getData(String.valueOf(k));o1++;
    }



        WordAdapter itemsAdapter1 = new WordAdapter(getActivity(), words1);


            listView1 = (ListView) v1.findViewById(R.id.list1);


            listView1.setAdapter(itemsAdapter1);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                h = id;



               Intent i = new Intent(getActivity(), pun.class);
                i.putExtra("key", h);
                startActivity(i);



            }
        });

            return v1;
        }}





