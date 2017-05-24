package com.example.rajat.myapplication2;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Fragment that displays "Monday".
 */
public class KILLED extends Fragment {
public  static ListView listView;
    public  static  ArrayList<wordsclass> words=new ArrayList<wordsclass>();
    public Bitmap decodeBase64(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory
                .decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
View v=inflater.inflate(R.layout.fragment_monday, container, false);
        SharedPreferences userDetails = getActivity().getSharedPreferences("userdetails", MODE_PRIVATE);
        String Uname = userDetails.getString("username", "");
        String pass = userDetails.getString("password", "");
String image=userDetails.getString("image","");
        Bitmap bp=decodeBase64(image);
words.add(new wordsclass(Uname,pass,bp));




        WordAdapter itemsAdapter = new WordAdapter(getActivity(),words );

         listView = (ListView)v.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        return v;
    }
}