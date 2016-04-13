package com.nbastats;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by kevin_maussion on 12/04/2016.
 */
public class DAOStats extends DAOBase {

    public DAOStats(Context pContext) {
        super(pContext);
    }

    public void ajouter(DBStats dbs){
        open();

        ContentValues value = new ContentValues();
        value.put(DBHelper.Stats_Column_ID, dbs.getId() );
        value.put(DBHelper.Stats_Column_3_POINTS, dbs.getTrois_Points());
        value.put(DBHelper.Stats_Column_2_POINTS, dbs.getDeux_Points());
        value.put(DBHelper.Stats_Column_DUNKS, dbs.getDunks());
        value.put(DBHelper.Stats_Column_FAUTES, dbs.getFautes());

        mDb.insert(DBHelper.Stats_TABLE, null, value);

        close();
    }

    public void supprimer(long id) {
        mDb.delete(DBHelper.Stats_TABLE, DBHelper.Stats_Column_ID + "= ? ", new String[]{String.valueOf(id)});
    }

    public void modifier(DBStats dbs) {
        ContentValues value = new ContentValues();
        value.put(DBHelper.Stats_Column_ID, dbs.getId() );
        value.put(DBHelper.Stats_Column_3_POINTS, dbs.getTrois_Points());
        value.put(DBHelper.Stats_Column_2_POINTS, dbs.getDeux_Points());
        value.put(DBHelper.Stats_Column_DUNKS, dbs.getDunks());
        value.put(DBHelper.Stats_Column_FAUTES, dbs.getFautes());

        mDb.update(DBHelper.Stats_TABLE, value, DBHelper.Stats_Column_ID + "= ? ", new String[]{String.valueOf(dbs.getId())});
    }

    public void supprimerAll(){
        mDb.execSQL("DELETE FROM " + DBHelper.Stats_TABLE);
    }

    public Cursor selectionner(int id) {
        open();

        Cursor cursor = this.getDb().rawQuery("select " + " * " + " from " + DBHelper.Stats_TABLE + " where " + DBHelper.Stats_Column_ID + " = ? ", new String[]{String.valueOf(id)});

        if(cursor != null && cursor.moveToFirst()){
            return  cursor;
        }else {
            return null;
        }

    }
}
