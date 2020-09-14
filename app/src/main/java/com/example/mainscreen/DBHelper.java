package com.example.mainscreen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    final String TAG = "DBHelper";

    public Context context;

    //Table name and column name
    public static final String TABLE_NAME = "MYSCORE";
    public static final String ID = "_id";
    public static final String FILENAME = "filename";
    public static final String SCORE = "score";

    //Database information
    static final String DB_NAME = "example.db";
    static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    //최초 DB가 존재하지 않으면 새로 생성한다.
    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CREATE TABLE " +TABLE_NAME + "(");
        stringBuffer.append(ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
        stringBuffer.append(FILENAME + " TEXT, ");
        stringBuffer.append(SCORE + " TEXT);");

        Log.d(TAG, stringBuffer.toString());
        db.execSQL(stringBuffer.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //데이터 추가하고 boolean를 반환한다.
    public boolean insertData(String filename, int score){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FILENAME, filename);
        values.put(SCORE, score);
        long result = db.insert(TABLE_NAME, null, values);
        if(result == -1){
            return false;
        } else {
            return true;
        }
    }

    //데이터 모두 가져오기
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME + " order by _id desc", null);
        return cursor;
    }

    //데이터 수정 업데이트
    public boolean updateData(String id, String filename, int score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, id);
        values.put(FILENAME, filename);
        values.put(SCORE, score);
        db.update(TABLE_NAME, values, "ID = ?", new String[] {id});
        return true;
    }

    //테이블 삭제
    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "name = ?" , new String[] {id});
    }
}
