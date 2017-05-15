package com.example.rajat.myapplication2;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Fragment that displays "Monday".
 */
public class HITLIST extends Fragment {
ListView listView;
    ArrayList<wordsclass> words=new ArrayList<wordsclass>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
View v=inflater.inflate(R.layout.fragment_monday, container, false);
        words.add(new wordsclass("NAME-Cersie Lannister","HOUSE-Lannister", BitmapFactory.decodeResource(getResources(),R.drawable.c)));
        words.add(new wordsclass("NAME-Joffery","HOUSE-Lannister",BitmapFactory.decodeResource(getResources(),R.drawable.joff)));

        words.add(new wordsclass("NAME-Hound","HOUSE-Clegane",BitmapFactory.decodeResource(getResources(),R.drawable.hound)));

        words.add(new wordsclass("NAME-Meryn","HOUSE-Trant",BitmapFactory.decodeResource(getResources(),R.drawable.meryn)));
        words.add(new wordsclass("NAME-Thoros","HOUSE-Myr",BitmapFactory.decodeResource(getResources(),R.drawable.thoros)));
        words.add(new wordsclass("NAME-Beric","HOUSE-Dondarion",BitmapFactory.decodeResource(getResources(),R.drawable.beric)));
        words.add(new wordsclass("NAME-Mellisandre","HOUSE-Baratheon",BitmapFactory.decodeResource(getResources(),R.drawable.mellisan)));
        words.add(new wordsclass("NAME-Gregor","HOUSE-Clegane",BitmapFactory.decodeResource(getResources(),R.drawable.gregor)));
        words.add(new wordsclass("NAME-Tywin","HOUSE-Lannister",BitmapFactory.decodeResource(getResources(),R.drawable.tywin)));
        words.add(new wordsclass("NAME-Walder Frey","HOUSE-Frey",BitmapFactory.decodeResource(getResources(),R.drawable.frey)));
        words.add(new wordsclass("NAME-Ilyn","HOUSE-Payne",BitmapFactory.decodeResource(getResources(),R.drawable.ilyn)));
        words.add(new wordsclass("NAME-Amory","HOUSE-Lorch",BitmapFactory.decodeResource(getResources(),R.drawable.amory)));


        WordAdapter itemsAdapter = new WordAdapter(getActivity(),words );

         listView = (ListView)v.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        return v;
    }
}