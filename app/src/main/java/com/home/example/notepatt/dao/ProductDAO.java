package com.home.example.notepatt.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by Usuario on 04/07/2017.
 */

public class ProductDAO extends SQLiteOpenHelper{


    public ProductDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){

        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);

    }

    public void insertData(String Cod_product, String Name_prodcut, String Marca_producto, String Cantidad_producto,
                           String Categoria_prodcuto, String Pecio_Unit, byte[] logo_product){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO Product VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
        SQLiteStatement stament = database.compileStatement(sql);
        stament.clearBindings();
        stament.bindString(1, Cod_product);
        stament.bindString(2, Name_prodcut);
        stament.bindString(3, Marca_producto);
        stament.bindString(4, Cantidad_producto);
        stament.bindString(5, Categoria_prodcuto);
        stament.bindString(6, Pecio_Unit);
        stament.bindBlob(7, logo_product);

        stament.executeInsert();

    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
