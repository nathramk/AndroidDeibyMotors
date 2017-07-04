package com.home.example.notepatt.bean;

/**
 * Created by HPINTEL on 03/07/2017.
 */

public class Productos {

    private  int id;
    private String nameProductos;
    private String description;



    public  Productos(){}

    @Override
    public String toString() {
        return nameProductos + " " + description ;
    }

    public Productos(int id, String nameProductos, String description) {
        this.id = id;
        this.nameProductos = nameProductos;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProductos() {
        return nameProductos;
    }

    public void setNameProductos(String nameProductos) {
        this.nameProductos = nameProductos;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
