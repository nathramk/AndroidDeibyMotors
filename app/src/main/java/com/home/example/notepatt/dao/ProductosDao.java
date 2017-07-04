package com.home.example.notepatt.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.home.example.notepatt.bean.Productos;
import com.home.example.notepatt.bean.User;

import java.util.ArrayList;

import static com.home.example.notepatt.commons.Commons.CREATE_TABLE;
import static com.home.example.notepatt.commons.Commons.CREATE_TABLE1;
import static com.home.example.notepatt.commons.Commons.DROP_TABLE;
import static com.home.example.notepatt.commons.Commons.DROP_TABLE1;
import static com.home.example.notepatt.commons.Commons.NAME_DATABASE;
import static com.home.example.notepatt.commons.Commons.NAME_DATABASE1;
import static com.home.example.notepatt.commons.Commons.NAME_TABLE;
import static com.home.example.notepatt.commons.Commons.NAME_TABLE1;

/**
 * Created by HPINTEL on 03/07/2017.
 */

public class ProductosDao extends SQLiteOpenHelper {

    SQLiteDatabase db;

    public ProductosDao(Context context) {
        super(context, NAME_DATABASE1, null,VERSION_DATABAS1);
    }
    private static final int VERSION_DATABAS1 = 2;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE1);
        this.db = db;

    }

    public void saveProduct(Productos productos){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("nameProductos", productos.getNameProductos());
        values.put("description", productos.getDescription());

        db.insert(NAME_TABLE1,null,values);
        db.close();

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE1);
        this.onCreate(db);

    }
    public ArrayList<String> llenar_listProduct(){
        ArrayList<String> listsProduct = new ArrayList<>();
        db = this.getReadableDatabase();
        String quer = "SELECT * FROM Productos";
        Cursor regs = db.rawQuery(quer, null);

        //variables para ordenar
        String nameProduct = " \nNombre Producto: ";
        String description = " \nDescripcion: ";
        if (regs.moveToFirst()){
            Productos productos= new Productos();
            do {

                productos.setId(regs.getInt(0));
                productos.setNameProductos(nameProduct+regs.getString(1)+description);
                productos.setDescription(regs.getString(2));

                listsProduct.add(productos.toString());

            }while (regs.moveToNext());
        }
        return listsProduct;
    }



    public String getDatabaseName(){
        return NAME_DATABASE1;
    }
    public static String getKeyId() {
        return "id";
    }

    public static String getTableContacts() {
        return "Productos";
    }

    public static int getDatabaseVersion() {
        return VERSION_DATABAS1;
    }


}
