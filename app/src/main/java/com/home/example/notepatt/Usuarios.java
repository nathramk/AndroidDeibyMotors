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

import com.home.example.notepatt.dao.UserDao;

import java.util.ArrayList;

/**
 * Created by HPINTEL on 02/07/2017.
 */

public class Usuarios extends Fragment{



    public static int layouts = android.R.layout.simple_list_item_1;


    SQLiteDatabase db;
    UserDao userDAO;
    ListView listUser;
    int userId;
    ArrayList<String> lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.usuarios_tab, container, false);

        userDAO = new UserDao(getActivity());
        listUser = (ListView) view.findViewById(R.id.listUser);

        lista = userDAO.llenar_list();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), layouts, lista);
        listUser.setAdapter(adapter);

        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), lista.get(position),Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton floDelt = (FloatingActionButton) view.findViewById(R.id.floDelt);
        floDelt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                eliminarUser(userId);


            }
        });


        return view;
    }

    public void eliminarUser(int id){
        UserDao usDAO = new UserDao(getActivity());
        SQLiteDatabase db = usDAO.getWritableDatabase();
        String sql = "delete from User where id="+id;
        db.execSQL(sql);
        db.close();

    }



}
