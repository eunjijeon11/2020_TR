package com.example.mainscreen;

import android.provider.BaseColumns;

public class DataBases {

    public static final class CreateDB implements BaseColumns {
        public static final String FILENAME = "filename";
        public static final String SCORE = "score";
        public static final String Date = "date";
        public static final String TABLENAME = "scoretable";
        public static final String CREATE = "create table if not exists " + TABLENAME +
                "(" + _ID + " integer primary key autoincrement, "
                +FILENAME+ " text not null , "
                +SCORE+ " integer not null , "
                +Date+ " text not null );";
    }
}
