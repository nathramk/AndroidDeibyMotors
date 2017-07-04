package com.home.example.notepatt;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.home.example.notepatt.dao.ProductosDao;
import com.home.example.notepatt.dao.UserDao;

import java.util.ArrayList;

/**
 * Created by HPINTEL on 03/07/2017.
 */

public class Product extends Fragment {


    public static int layouts = android.R.layout.simple_list_item_1;

    SQLiteDatabase db;
    ProductosDao productosDao;
    ListView listProduct;
    int productId;
    ArrayList<String> listaProduct;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.productos_tab, container, false);

        productosDao= new ProductosDao(getActivity());

        listProduct = (ListView) view.findViewById(R.id.listProduct);

        listaProduct = productosDao.llenar_listProduct();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), layouts, listaProduct);
        listProduct.setAdapter(adapter);

        listProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getActivity(), listaProduct.get(position),Toast.LENGTH_SHORT).show();


            }
        });


        return view;
    }
}
