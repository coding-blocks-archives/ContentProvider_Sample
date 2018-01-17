package com.codingblocks.providerapp.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.codingblocks.providerapp.db.TodoDbHelper;
import com.codingblocks.providerapp.db.tables.TodoTable;

import java.net.URI;

public class TodoProvider extends ContentProvider {

    public static final String URI_AUTHORITY = "com.codingblocks.providerapp";
    public static final String URI_PATH_TODOS = "todos";
    public static final String URI_PATH_TODOS_ID = "todos/#";

    public static final int URI_CODE_TODOS = 1;
    public static final int URI_CODE_TODOS_ID = 2;

    public static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    SQLiteDatabase todoDB;

    static {
        /*
         * If Intent for content provider has URI =
          *     content://com.codingblocks.providerapp/todos
          * then,
          *     uriMatcher returns code = 1
         */
        uriMatcher.addURI(URI_AUTHORITY, URI_PATH_TODOS, URI_CODE_TODOS);
        uriMatcher.addURI(URI_AUTHORITY, URI_PATH_TODOS_ID, URI_CODE_TODOS_ID);
    }

    public TodoProvider() {
        TodoDbHelper dbHelper = new TodoDbHelper(getContext());
        todoDB = dbHelper.getWritableDatabase();
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {


        switch (uriMatcher.match(uri)) {
            case URI_CODE_TODOS:

                return TodoTable.getAllTodosCursor(todoDB);

            case URI_CODE_TODOS_ID:
                break;
            case UriMatcher.NO_MATCH:default:
                break;
        }

        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
