package com.home.example.notepatt.commons;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by HPINTEL on 01/07/2017.
 */

public class DBHelper {

    private static DBHelper instance;
    private static final String TABLE_NAME = "entries";
    private static final String COLUMN_NAME = "value";
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + " (_id integer primary key autoincrement, " + COLUMN_NAME + " text not null);";

    private SQLiteDatabase db;

    public static DBHelper get(Context context) {

        if (instance == null) {
            instance = new DBHelper(context);
        }
        return instance;
    }

    private DBHelper(Context context) {
        db = context.openOrCreateDatabase("copy", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        try {
            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {
            // table already exists
        }
    }

    public ArrayList<String> getEntries() {
        Cursor c = db.query(TABLE_NAME, new String[] {COLUMN_NAME}, null, null, null, null, null);
        ArrayList<String> values = new ArrayList<String>();
        int columnId = c.getColumnIndex(COLUMN_NAME);
        if (c.moveToFirst()) {
            do {
                values.add(c.getString(columnId));
            } while (c.moveToNext());
        }

        Collections.sort(values);
        return values;
    }

    public void addEntry(String entry) {
//		ContentValues cv = new ContentValues();
//		cv.put("value", entry);
//		db.insert(TABLE_NAME, null, cv);
        SQLiteStatement statement = db.compileStatement("INSERT INTO " + TABLE_NAME + " VALUES (?, ?)");
        statement.bindNull(1);
        statement.bindString(2, entry);
        statement.execute();
    }

    public void updateEntry(String oldValue, String newValue) {
//		String query = "UPDATE " + TABLE_NAME + " SET value = '" + newValue + "' WHERE value = '" + oldValue + "';";
        SQLiteStatement statement = db.compileStatement("UPDATE " + TABLE_NAME + " SET value = ? WHERE value = ?;");
        statement.bindString(1, newValue);
        statement.bindString(2, oldValue);
        statement.execute();
    }

    public void deleteEntry(String oldValue) {
        String query = "DELETE FROM " + TABLE_NAME + " WHERE value = '" + oldValue + "';";
        SQLiteStatement statement = db.compileStatement("DELETE FROM " + TABLE_NAME + " WHERE value = ?;");
        statement.bindString(1, oldValue);
        statement.execute();
    }
}
