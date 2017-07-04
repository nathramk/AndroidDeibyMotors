package com.home.example.notepatt;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.home.example.notepatt.adapter.ProductListAdapters;
import com.home.example.notepatt.bean.Products;

import java.util.ArrayList;

import static com.home.example.notepatt.commons.Commons.NAME_TABLE_PRODUCT;

/**
 * Created by Usuario on 04/07/2017.
 */

public class ProductListSQlite extends AppCompatActivity {
    ListView ListViewProtos;
    ArrayList<Products> list;
    ProductListAdapters adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_layout_list);

        ListViewProtos = (ListView) findViewById(R.id.ListViewProtos);
        list = new ArrayList<>();
        adapter = new ProductListAdapters(this, R.layout.product_items, list);
        ListViewProtos.setAdapter(adapter);

        // get all data from sqlit

        Cursor cursor = ProductosSQlite.productDAO.getData("SELECT * FROM " + NAME_TABLE_PRODUCT);
        list.clear();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String codProduct = cursor.getString(1);
            String nameProdcut = cursor.getString(2);
            String marcaProducto = cursor.getString(3);
            String cantidadProducto = cursor.getString(4);
            String categoriaProdcuto = cursor.getString(5);
            String pecioUnit = cursor.getString(6);
            byte[] image = cursor.getBlob(7);

            list.add(new Products(id, codProduct, nameProdcut, marcaProducto, cantidadProducto, categoriaProdcuto, pecioUnit, image));
        }

        adapter.notifyDataSetChanged();
    }
}