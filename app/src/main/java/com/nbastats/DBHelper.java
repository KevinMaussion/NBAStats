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
    public static final String Stats_Column_3_POINTS = "trois_Points";
    public static final String Stats_Column_2_POINTS = "deux_Points";
    public static final String Stats_Column_DUNKS = "Dunks";
    public static final String Stats_Column_FAUTES = "Fautes";


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + Stats_TABLE + " ( " +
                Stats_Column_ID +" INTEGER PRIMARY KEY, "+
                Stats_Column_3_POINTS +" INTEGER, "+
                Stats_Column_2_POINTS +" INTEGER, "+
                Stats_Column_DUNKS +" INTEGER, " +
                Stats_Column_FAUTES +" INTEGER "+" ) ; ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Stats_TABLE+" ;");
        onCreate(db);
    }

   /* public Boolean insertStatistiques(String game_name, String team1, String team2, String city_name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Stats_Column_3_POINTS, game_name);
        contentValues.put(Stats_Column_2_POINTS, team1);
        contentValues.put(Stats_Column_DUNKS, team2);
        contentValues.put(Stats_Column_FAUTES, city_name);
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
        contentValues.put(Stats_Column_3_POINTS, game_name);
        contentValues.put(Stats_Column_2_POINTS, team1);
        contentValues.put(Stats_Column_DUNKS, team2);
        contentValues.put(Stats_Column_FAUTES, game_city);
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
            array_list.add(res.getString(res.getColumnIndex(Stats_Column_3_POINTS)));
            res.moveToNext();
        }
        return array_list;
    }*/
}
