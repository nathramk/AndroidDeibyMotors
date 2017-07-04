package com.home.example.notepatt;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.home.example.notepatt.adapter.*;
import com.home.example.notepatt.bean.Products;

import java.util.ArrayList;

import static com.home.example.notepatt.commons.Commons.NAME_TABLE_PRODUCT;

public class MainPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_salir) {


            Intent i= new Intent(this, LoginActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_pedido) {
            // Handle the camera action
            Intent i= new Intent(MainPrincipal.this, QuickCopyMain.class);
            startActivity(i);
        } else if (id == R.id.nav_person) {

            Intent ii= new Intent(MainPrincipal.this, ContactActivity.class);
            startActivity(ii);
        } else if (id == R.id.nav_address) {

            Intent iii= new Intent(MainPrincipal.this, MapsActivity.class);
            startActivity(iii);

        } else if (id == R.id.nav_product) {

            Intent iiii= new Intent(MainPrincipal.this, ProductActivity.class);
            startActivity(iiii);

        } else if (id == R.id.nav_tab) {

            Intent jj= new Intent(MainPrincipal.this, TabActivity.class);
            startActivity(jj);
        } else if (id == R.id.nav_send) {

            Intent jjj= new Intent(MainPrincipal.this, MainRegistProductActivity.class);
            startActivity(jjj);

        } else if (id == R.id.crear_product) {
            Intent ss= new Intent(MainPrincipal.this, ProductosSQlite.class);
            startActivity(ss);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
