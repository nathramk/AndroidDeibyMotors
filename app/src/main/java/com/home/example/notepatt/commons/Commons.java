package com.home.example.notepatt.commons;

/**
 * Created by HPINTEL on 02/07/2017.
 */

public class Commons {


    public static final String NAME_DATABASE = "usuarios.db";
    public static final String NAME_TABLE = "User";
    public static final String CREATE_TABLE = "create table User" +
            "(" +
            "id integer primary key," +
            "name text," +
            "lastName text," +
            "usuario text," +
            "password text," +
            "email text," +
            "address text," +
            "phone text" +
            ");";

    public static final String DROP_TABLE = "DROP TABLE IF EXIST User";

    public static final String NAME_DATABASE1 = "productos.db";
    public static final String NAME_TABLE1 = "Productos";
    public static final String CREATE_TABLE1 = "create table Productos" +
            "(" +
            "id integer primary key," +
            "nameProductos text," +
            "description text" +
            ");";
    public static final String DROP_TABLE1 = "DROP TABLE IF EXIST Productos";

    public static final String NAME_TABLE_PRODUCT = "Product";
    public static final String CREATE_TABLE_PRODUCT = "create table Product" +
            "(" +
            "id integer primary key," +
            "codProduct text," +
            "nameProdcut text," +
            "marcaProducto text," +
            "cantidadProducto text," +
            "categoriaProdcuto text," +
            "pecioUnit text," +
            "image BLOB" +
            ");";
    public static final String DROP_TABLE_PRODUCT = "DROP TABLE IF EXIST Product";

}
