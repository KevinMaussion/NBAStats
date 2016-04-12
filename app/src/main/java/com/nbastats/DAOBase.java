package com.nbastats;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by kevin_maussion on 12/04/2016.
 */
public class DAOBase {

    protected final static int version = 1;

    protected final static String nom = "database.db";

    protected SQLiteDatabase mDb = null;

    protected DBHelper mHandler = null;

    public DAOBase(Context pContext) {
        this.mHandler = new DBHelper(pContext, nom, null, version);
    }

    public SQLiteDatabase open() {
        mDb = mHandler.getWritableDatabase();
        return mDb;
    }

    public void close() {
        mDb.close();
    }

    public SQLiteDatabase getDb() {
        return mDb;
    }
}


