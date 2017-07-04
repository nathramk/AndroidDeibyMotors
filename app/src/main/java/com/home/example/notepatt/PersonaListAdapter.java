package com.home.example.notepatt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.home.example.notepatt.bean.Person;

import java.util.List;

/**
 * Created by HPINTEL on 02/07/2017.
 */

public class PersonaListAdapter extends ArrayAdapter<Person> {


    private Context contextGeneral;

    private class ViewHolder{
        TextView name;
        TextView lastNameF;
        TextView lastNameM;
        TextView site;
        TextView address;
        ImageView photo;
    }

    public PersonaListAdapter(Context context, List<Person> rowItem) {
        super(context, R.layout.list_person, rowItem);
    }

    public View getView(int position, View contentView, ViewGroup parent){
        Person person = getItem(position);

        ViewHolder viewHolder;
        if(contentView==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater=LayoutInflater.from(getContext());
            contentView = inflater.inflate(R.layout.list_person,null);
            viewHolder.name = (TextView)contentView.findViewById(R.id.name);
            viewHolder.lastNameF = (TextView)contentView.findViewById(R.id.lastNameF);
            viewHolder.lastNameM = (TextView)contentView.findViewById(R.id.lastNameM);
            viewHolder.site = (TextView)contentView.findViewById(R.id.site);
            viewHolder.address = (TextView)contentView.findViewById(R.id.address);
            viewHolder.photo = (ImageView)contentView.findViewById(R.id.photo);
            contentView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)contentView.getTag();
        }
        viewHolder.name.setText(person.getName());
        viewHolder.lastNameF.setText(person.getLastNameF());
        viewHolder.lastNameM.setText(person.getLastNameM());

        viewHolder.site.setText(person.getSite());
        viewHolder.address.setText(person.getAddress());
        viewHolder.photo.setImageResource(person.getPhoto());

        return contentView;
    }
}
