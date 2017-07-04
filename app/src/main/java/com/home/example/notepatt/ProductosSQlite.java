package com.home.example.notepatt;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.home.example.notepatt.dao.ProductDAO;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static com.home.example.notepatt.commons.Commons.CREATE_TABLE_PRODUCT;
import static com.home.example.notepatt.commons.Commons.NAME_DATABASE;

public class ProductosSQlite extends AppCompatActivity {

    EditText edtCodProducto, edtNameProduct, edtMarcaProduct, edtCateforia, edtCantidad, edtPriceUnit;
    ImageView imageProductLogo;
    Button btnChoiceImage, btnIrToList, btnAgregar;

    public static ProductDAO productDAO;

    final int RQUEST_CODE_GALLERY = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_sqlite);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();

        productDAO = new ProductDAO(this, NAME_DATABASE, null, 2);

        productDAO.queryData(CREATE_TABLE_PRODUCT);

        btnChoiceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        ProductosSQlite.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        RQUEST_CODE_GALLERY
                );
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    productDAO.insertData(
                            edtCodProducto.getText().toString().trim(),
                            edtNameProduct.getText().toString().trim(),
                            edtMarcaProduct.getText().toString().trim(),
                            edtCateforia.getText().toString().trim(),
                            edtCantidad.getText().toString().trim(),
                            edtPriceUnit.getText().toString().trim(),
                            imageProductLogoToByte(imageProductLogo)
                    );
                    Toast.makeText(getApplicationContext(), "Agregado satisfactoriamente", Toast.LENGTH_SHORT).show();

                    edtCodProducto.setText("");
                    edtNameProduct.setText("");
                    edtMarcaProduct.setText("");
                    edtCateforia.setText("");
                    edtCantidad.setText("");
                    edtPriceUnit.setText("");
                    imageProductLogo.setImageResource(R.mipmap.ic_launcher);

                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        btnIrToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductosSQlite.this, ProductListSQlite.class);
                startActivity(intent);
            }
        });

    }


    private byte[] imageProductLogoToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == RQUEST_CODE_GALLERY){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, RQUEST_CODE_GALLERY);
            }
            else{
                Toast.makeText(getApplicationContext(),"no tienes permiso",Toast.LENGTH_SHORT).show();
            }
            return;

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == RQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageProductLogo.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void init(){
        edtCodProducto = (EditText)findViewById(R.id.edtCodProducto);
        edtNameProduct = (EditText)findViewById(R.id.edtNameProduct);
        edtMarcaProduct = (EditText)findViewById(R.id.edtMarcaProduct);
        edtCateforia = (EditText)findViewById(R.id.edtCateforia);
        edtCantidad = (EditText)findViewById(R.id.edtCantidad);
        edtPriceUnit = (EditText)findViewById(R.id.edtPriceUnit);

        btnChoiceImage = (Button)findViewById(R.id.btnChoiceImage);
        btnIrToList = (Button)findViewById(R.id.btnIrToList);
        btnAgregar = (Button)findViewById(R.id.btnAgregar);

        imageProductLogo = (ImageView)findViewById(R.id.imageProductLogo);
    }

}
