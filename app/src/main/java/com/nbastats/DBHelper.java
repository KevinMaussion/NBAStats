package com.nbastats;

/*
 * Created by kevin_maussion on 21/03/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;




public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "MyDB.db";
    public static final String Stats_TABLE = "Statistiques";
    public static final String Stats_Column_ID = "id";
    public static final String Stats_Column_GAME_NAME = "Game_Name";
    public static final String Stats_Column_CITY_NAME = "City_Name";
    public static final String Stats_Column_TEAM1 = "Team_1";
    public static final String Stats_Column_TEAM2 = "Team_2";


    public DBHelper(Context context){
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Statistiques" + "(id integer primary key, Game_Name text, Team_1 text, Team_2 text, City_Name text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Statistiques");
        onCreate(db);
    }

    public Boolean insertStatistiques(String game_name, String team1, String team2, String city_name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Stats_Column_GAME_NAME, game_name);
        contentValues.put(Stats_Column_TEAM1, team1);
        contentValues.put(Stats_Column_TEAM2, team2);
        contentValues.put(Stats_Column_CITY_NAME, city_name);
        db.insert(Stats_TABLE, null, contentValues);
        return true;
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from Statistiques where id=" + id + "", null);
        return res;

    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, Stats_TABLE);
        return numRows;
    }

    public boolean updateStats(Integer id, String game_name, String team1, String team2, String game_city){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Stats_Column_GAME_NAME, game_name);
        contentValues.put(Stats_Column_TEAM1, team1);
        contentValues.put(Stats_Column_TEAM2, team2);
        contentValues.put(Stats_Column_CITY_NAME, game_city);
        db.update(Stats_TABLE, contentValues, "id = ?", new String[]{Integer.toString(id)});
        return true;
    }

    public boolean deleteStats(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(Stats_TABLE, "id = ?", new String[]{Integer.toString(id)});
        return true;
    }

    public ArrayList<String> getAllStats() {

        ArrayList<String> array_list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select * from Statistiques", null);
        res.moveToFirst();

        while(!res.isAfterLast()){
            array_list.add(res.getString(res.getColumnIndex(Stats_Column_GAME_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}
