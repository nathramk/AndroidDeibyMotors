package com.home.example.notepatt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.home.example.notepatt.bean.Person;
import com.home.example.notepatt.bean.Product;

import java.util.List;

/**
 * Created by HPINTEL on 02/07/2017.
 */

public class ProductListAdapter extends ArrayAdapter<Product> {

    private Context contextGeneral;

    private class ViewHolder{
        TextView nameProduct;
        TextView price;
        TextView disponibilidad;
        TextView statusProduct;
        TextView stock;
        ImageView photo;
    }

    public ProductListAdapter(Context context, List<Product> rowItem) {
        super(context, R.layout.list_product, rowItem);
    }


    public View getView(int position, View contentView, ViewGroup parent){
        Product product = getItem(position);

        ViewHolder viewHolder;


        if(contentView==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater=LayoutInflater.from(getContext());

            contentView = inflater.inflate(R.layout.list_product,null);
            viewHolder.nameProduct = (TextView)contentView.findViewById(R.id.nameProduct);
            viewHolder.price = (TextView)contentView.findViewById(R.id.price);
            viewHolder.disponibilidad= (TextView)contentView.findViewById(R.id.disponibilidad);
            viewHolder.statusProduct= (TextView)contentView.findViewById(R.id.statusProduct);
            viewHolder.stock = (TextView)contentView.findViewById(R.id.stock);
            viewHolder.photo = (ImageView)contentView.findViewById(R.id.photoProduct);
            contentView.setTag(viewHolder);
        }else{
            viewHolder = (ProductListAdapter.ViewHolder)contentView.getTag();
        }
        viewHolder.nameProduct.setText(product.getNameProduct());
        viewHolder.price.setText(product.getPrice());
        viewHolder.disponibilidad.setText(product.getDisponibilidad());

        viewHolder.statusProduct.setText(product.getStatusProduct());
        viewHolder.stock.setText(product.getStockProduct());
        viewHolder.photo.setImageResource(product.getPhoto());

        return contentView;
    }

}
