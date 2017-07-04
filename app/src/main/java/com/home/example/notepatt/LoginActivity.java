package com.home.example.notepatt;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.home.example.notepatt.dao.UserDao;

public class LoginActivity extends AppCompatActivity {


    EditText edtUserLog;
    EditText edtPasswordLog;
    Button btnIngresar;
    Button btnRegister;
    UserDao userDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtUserLog = (EditText)findViewById(R.id.edtUserLog);
        edtPasswordLog = (EditText)findViewById(R.id.edtPassowrndLog);
        btnIngresar = (Button)findViewById(R.id.btnIngresar);
        btnRegister = (Button)findViewById(R.id.btnRegister);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDAO = new UserDao(LoginActivity.this);

                String usss = edtUserLog.getText().toString();
                String passs = edtPasswordLog.getText().toString();

                String pssword = userDAO.getRegistered(usss);




                if (passs.equals(pssword)){

                    Toast.makeText(getApplicationContext(), "as ingresado correctamente!!",Toast.LENGTH_SHORT).show();
                    Intent rawrr = new Intent(LoginActivity.this, MainPrincipal.class);
                    startActivity(rawrr);

                }else {

                    Toast.makeText(LoginActivity.this, "Usuario o password estan incorrectos",Toast.LENGTH_SHORT).show();
                    edtUserLog.setText("");
                    edtPasswordLog.setText("");

                }

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainRegistActivity.class));
            }
        });


    }
}
