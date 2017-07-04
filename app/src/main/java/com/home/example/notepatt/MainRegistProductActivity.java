package com.home.example.notepatt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.home.example.notepatt.bean.Productos;
import com.home.example.notepatt.bean.User;
import com.home.example.notepatt.dao.ProductosDao;
import com.home.example.notepatt.dao.UserDao;

public class MainRegistProductActivity extends AppCompatActivity {

    EditText edtNameProduct;
    EditText edtDescription;

    Button btnIngresProduct;


    SharedPreferences sharedPreferences;
    public static final String mypreference = "mypref";
    public static final String Username1 = "nameKey";
    public static final String Username2 = "lastNameKey";

    ProductosDao productosDao= new ProductosDao(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_regist_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent ii= new Intent(MainRegistProductActivity.this, MainPrincipal.class);
                startActivity(ii);
            }
        });

        edtNameProduct = (EditText)findViewById(R.id.edtNameProduct);
        edtDescription = (EditText)findViewById(R.id.edtDescription);
        btnIngresProduct = (Button)findViewById(R.id.btnSaveProduct);

        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);


        btnIngresProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameProduct = edtNameProduct.getText().toString();
                String description = edtDescription.getText().toString();


                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Username1, nameProduct);
                editor.putString(Username2, description);
                editor.commit();

                    Productos productos= new Productos();
                    productos.setNameProductos(nameProduct);
                    productos.setDescription(description);

                    productosDao.saveProduct(productos);
                    Toast.makeText(MainRegistProductActivity.this, "registrado", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainPrincipal.class));


                    Toast.makeText(getApplicationContext(), "Campos vacios ", Toast.LENGTH_SHORT).show();

            }

        });


    }

}
