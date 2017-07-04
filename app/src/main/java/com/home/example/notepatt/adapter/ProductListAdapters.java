package com.home.example.notepatt.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.home.example.notepatt.R;
import com.home.example.notepatt.bean.Products;

import java.util.ArrayList;

/**
 * Created by Usuario on 04/07/2017.
 */

public class ProductListAdapters extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Products> productList;

    public ProductListAdapters(Context context, int layout, ArrayList<Products> productList) {
        this.context = context;
        this.layout = layout;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        ImageView imagePrduct;
        TextView textView1, textView2, textView3, textView4, textView5, textView6;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ViewHolder holder = new ViewHolder();
        if (row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.textView1 = (TextView) row.findViewById(R.id.textView1);
            holder.textView2 = (TextView) row.findViewById(R.id.textView2);
            holder.textView3 = (TextView) row.findViewById(R.id.textView3);
            holder.textView4 = (TextView) row.findViewById(R.id.textView4);
            holder.textView5 = (TextView) row.findViewById(R.id.textView5);
            holder.textView6 = (TextView) row.findViewById(R.id.textView6);
            holder.imagePrduct = (ImageView) row.findViewById(R.id.imagePrduct);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }
        Products products = productList.get(position);
        holder.textView1.setText(products.getCodProducto());
        holder.textView2.setText(products.getEdtNameProduct());
        holder.textView3.setText(products.getEdtMarcaProduct());
        holder.textView4.setText(products.getEdtCateforia());
        holder.textView5.setText(products.getEdtCantidad());
        holder.textView6.setText(products.getEdtPriceUnit());

        byte[] productImage = products.getImageProductLogo();
        Bitmap bitmap = BitmapFactory.decodeByteArray(productImage, 0, productImage.length);
        holder.imagePrduct.setImageBitmap(bitmap);


        return row;
    }
}
