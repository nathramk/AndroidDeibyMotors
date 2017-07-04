package com.home.example.notepatt.bean;

/**
 * Created by HPINTEL on 02/07/2017.
 */

public class Product {

    private int id;
    private String nameProduct;
    private String price;
    private  String disponibilidad;
    private  String statusProduct;
    private  String stockProduct;
    private Integer photo;


    public Product(){}


    public Product(int id, String nameProduct, String price, String disponibilidad, String statusProduct,Integer photo, String stockProduct ) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.disponibilidad = disponibilidad;
        this.statusProduct = statusProduct;
        this.photo = photo;
        this.stockProduct = stockProduct;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(String statusProduct) {
        this.statusProduct = statusProduct;
    }

    public String getStockProduct() {
        return stockProduct;
    }

    public void setStockProduct(String stockProduct) {
        this.stockProduct = stockProduct;
    }

    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return  nameProduct +" "+ price +" " + disponibilidad +" " + statusProduct + " "+ stockProduct;
    }
}
