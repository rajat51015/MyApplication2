package com.example.rajat.myapplication2;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rajat on 12/5/17.
 */

public class WordAdapter extends ArrayAdapter<wordsclass> {




    public WordAdapter(Activity context, ArrayList<wordsclass> androidFlavors) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, androidFlavors);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.listitem, parent, false);

        }

        wordsclass w = getItem(position);

        TextView t=(TextView) listItemView.findViewById(R.id.textView);
        TextView t2=(TextView) listItemView.findViewById(R.id.textView2);
        ImageView v1=(ImageView)listItemView.findViewById(R.id.f);
t.setText(w.gh());
        t2.setText(w.gn());
        v1.setImageBitmap(w.gid());
return listItemView;

    }



}
