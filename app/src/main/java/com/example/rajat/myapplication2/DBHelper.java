  package com.example.rajat.myapplication2;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rajat on 12/5/17.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String dbname = "data";
    private static final String name = "name";
    private static final String house = "house";
    private static final String id = "id";
    private static final String KEY_IMAGE = "image_data";

    public DBHelper(Context context) {
        super(context, dbname, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + dbname + "("
                + id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + name + " TEXT,"
                + house + " TEXT,"
                + KEY_IMAGE + " BLOB);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + dbname
        );
        onCreate(db);

    }

    public void add(detail detail) {

        ContentValues v = new ContentValues();
        //  v.put(id,detail.getid());
        v.put(name, detail.getname());
        v.put(house, detail.gethouse());
        v.put(KEY_IMAGE, detail.getbh());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(dbname, null, v);
        db.close();
    }

   public void delete(String name1) {
        SQLiteDatabase db = getWritableDatabase();

       db.execSQL("DELETE FROM " + dbname + " WHERE " + id + "= '" + name1 + "'");

       db.execSQL("UPDATE "+dbname+" set id = (id - 1) WHERE id > "+name1);
       db.close();
    }


    public int getProfilesCount() {
        String countQuery = "SELECT  * FROM " + dbname;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }
   /* public String display() {

        String d="";
        SQLiteDatabase db = getWritableDatabase();
        String q = " SELECT * FROM" + dbname + "WHERE 1";
        Cursor c = db.rawQuery(q, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {

            if (c.getString(c.getColumnIndex(id)) != null) {
                d = c.getString(c.getColumnIndex(name));
            }
            c.moveToNext();

        }
        db.close();
        return d;
    }*/
   public Cursor getData(String a) {
       SQLiteDatabase db = this.getReadableDatabase();
       String q = " SELECT * FROM " + dbname + " WHERE id = '" + a + "'";
       Cursor c = db.rawQuery(q, null);

       return c;
   }




}


