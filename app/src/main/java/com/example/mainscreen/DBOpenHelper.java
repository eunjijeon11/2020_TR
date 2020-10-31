package com.example.mainscreen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBOpenHelper {

    private static final String DB_NAME = "ScoreDataBase.db";
    private static final int DB_Version = 2;
    private static SQLiteDatabase mDB;
    private DatabaseHelper mDBHelper;
    private Context mContext;

    private static class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DataBases.CreateDB.CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DataBases.CreateDB.TABLENAME);
            onCreate(db);
        }
    }

    public DBOpenHelper(Context context) {
        this.mContext = context;
    }

    public DBOpenHelper open() throws SQLException{
        mDBHelper = new DatabaseHelper(mContext, DB_NAME, null, DB_Version);
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }

    public void create() {
        mDBHelper.onCreate(mDB);
    }

    public void close() {
        mDB.close();
    }

    public boolean insertColumn(String filename, int score, String date) {
        ContentValues values = new ContentValues();
        values.put(DataBases.CreateDB.FILENAME, filename);
        values.put(DataBases.CreateDB.SCORE, score);
        values.put(DataBases.CreateDB.Date, date);
        return mDB.insert(DataBases.CreateDB.TABLENAME, null, values) > 0;
    }

    public Cursor selectColumns() {
        return mDB.query(DataBases.CreateDB.TABLENAME, null,null,null,null, null, null);
    }

    public boolean updateColumn(long id, String filename, int score, String date) {
        ContentValues values = new ContentValues();
        values.put(DataBases.CreateDB.FILENAME, filename);
        values.put(DataBases.CreateDB.SCORE, score);
        values.put(DataBases.CreateDB.Date, date);
        return mDB.update(DataBases.CreateDB.TABLENAME, values, "_id=" + id, null) > 0;
    }

    public boolean deleteColumn(long id) {
        return mDB.delete(DataBases.CreateDB.TABLENAME, "_id=" + id, null) > 0;
    }
}
