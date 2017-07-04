package com.home.example.notepatt;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.home.example.notepatt.bean.Person;
import com.home.example.notepatt.bean.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    public static List<Product> listProduct = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView=(ListView)findViewById(R.id.listViewProduct);


        listProduct.add(new Product(1,"faro","12.12","activo", "actiivo", R.drawable.ic_edit, "20"));
        listProduct.add(new Product(2,"faro","12.12","activo", "actiivo", R.drawable.ic_edit, "20"));
        listProduct.add(new Product(3,"faro","12.12","activo", "actiivo", R.drawable.ic_edit, "20"));
        listProduct.add(new Product(4,"faro","12.12","activo", "actiivo", R.drawable.ic_edit, "20"));
        listProduct.add(new Product(5,"faro","12.12","activo", "actiivo", R.drawable.ic_edit, "20"));


        ProductListAdapter adapter = new ProductListAdapter(this,listProduct);

        listView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent ii= new Intent(ProductActivity.this, MainPrincipal.class);
                startActivity(ii);
            }
        });
    }

}
