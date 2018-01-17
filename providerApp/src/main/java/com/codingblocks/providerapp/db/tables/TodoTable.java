package com.codingblocks.providerapp.db.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.codingblocks.providerapp.models.Todo;

import java.util.ArrayList;

import static com.codingblocks.providerapp.db.Consts.CMD_CREATE_TABLE_INE;
import static com.codingblocks.providerapp.db.Consts.COMA;
import static com.codingblocks.providerapp.db.Consts.LBR;
import static com.codingblocks.providerapp.db.Consts.RBR;
import static com.codingblocks.providerapp.db.Consts.SEMICOL;
import static com.codingblocks.providerapp.db.Consts.TYPE_BOOL;
import static com.codingblocks.providerapp.db.Consts.TYPE_PK_AI;
import static com.codingblocks.providerapp.db.Consts.TYPE_TEXT;

/**
 * Created by championswimmer on 17/01/18.
 */

public class TodoTable {

    public static final String TABLE_NAME = "todos";

    public interface Columns {
        String ID = "id";
        String TASK = "task";
        String DONE = "done";
    }

    public static final String CMD_CREATE =
            CMD_CREATE_TABLE_INE + TABLE_NAME +
                LBR +
                    Columns.ID + TYPE_PK_AI +
                    COMA +
                    Columns.TASK + TYPE_TEXT +
                    COMA +
                    Columns.DONE + TYPE_BOOL +
                RBR +
            SEMICOL;

    public static long addTodo(SQLiteDatabase db, Todo todo) {
        ContentValues todoRow = new ContentValues();
        todoRow.put(Columns.TASK, todo.getTask());
        todoRow.put(Columns.DONE, todo.getDone());
        return db.insert(TABLE_NAME, null, todoRow);
    }

    public static ArrayList<Todo> getAllTodos (SQLiteDatabase db) {
        ArrayList<Todo> todos = new ArrayList<>();
        Cursor c = db.query(
                TABLE_NAME,
                new String[] {Columns.ID, Columns.TASK, Columns.DONE},
                null, null, null, null, null
        );
        while (c.moveToNext()) {
            todos.add(new Todo(
                    c.getInt(0),
                    c.getString(1),
                    c.getInt(2) == 1 // boolean is stored as 0 or 1
            ));
        }
        return todos;
    }

}
