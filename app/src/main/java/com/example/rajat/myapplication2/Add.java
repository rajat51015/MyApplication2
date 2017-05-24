package com.example.rajat.myapplication2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Fragment that displays "Wednesday".
 */
public class Add extends Fragment {
    TextView a, b, k;String userChoosenTask;Bitmap bm;
    EditText c, d;
    Button f;
    DBHelper g;int q;
    ImageButton e;


    private void cameraIntent()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 6);
    }


    private void galleryIntent()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"),5);
    }

    private void selectImage() {
        final CharSequence[] items = {"Take Photo", "Choose from Library",
                "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                // boolean result = ContextCompat.checkSelfPermission(getActivity(),Write);
                if (items[item].equals("Take Photo")) {
                    userChoosenTask = "Take Photo";
                    //  if (result)
                    cameraIntent();
                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask = "Choose from Library";
                    // if (result)
                    galleryIntent();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 5)
                onSelectFromGalleryResult(data);
            else if (requestCode == 6)
                onCaptureImageResult(data);
        }
    }
    private void onSelectFromGalleryResult(Intent data) {
        bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        e.setImageBitmap(bm);
    }
    private void onCaptureImageResult(Intent data) {
        bm = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        e.setImageBitmap(bm);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_wednesday, container, false);


        k = (TextView) v.findViewById(R.id.ttt);
        c = (EditText) v.findViewById(R.id.editText);
        d = (EditText) v.findViewById(R.id.editText2);
        e = (ImageButton) v.findViewById(R.id.button2);
        f = (Button) v.findViewById(R.id.button3);
        g = new DBHelper(getActivity());
        q = g.getProfilesCount();
        q++;
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();

            }
        });


        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detail ob=new detail(q,c.getText().toString(),d.getText().toString(),bm);
                g.add(ob);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {



                        Intent n=new Intent(getActivity(),pager.class);
                        n.putExtra("l",1);
                        startActivity(n);
                        getActivity().finish();




                    }
                }, 3000);


            }
        });




        return v;
    }
}
