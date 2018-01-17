package com.codingblocks.providerapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.codingblocks.providerapp.db.tables.TodoTable;

/**
 * Created by championswimmer on 17/01/18.
 */

public class TodoDbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "todos.db";
    public static final int DB_VER = 1;

    public TodoDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TodoTable.CMD_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
