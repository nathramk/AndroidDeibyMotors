package com.home.example.notepatt.bean;

/**
 * Created by Usuario on 04/07/2017.
 */

public class Products {

   private int id;
   private String codProducto;
   private String edtNameProduct;
   private String edtMarcaProduct;
   private String edtCateforia;
   private String edtCantidad;
   private String edtPriceUnit;
   private byte[] imageProductLogo;

    public Products(int id, String codProducto, String edtNameProduct, String edtMarcaProduct, String edtCateforia, String edtCantidad, String edtPriceUnit, byte[] imageProductLogo) {
        this.id = id;
        this.codProducto = codProducto;
        this.edtNameProduct = edtNameProduct;
        this.edtMarcaProduct = edtMarcaProduct;
        this.edtCateforia = edtCateforia;
        this.edtCantidad = edtCantidad;
        this.edtPriceUnit = edtPriceUnit;
        this.imageProductLogo = imageProductLogo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getEdtNameProduct() {
        return edtNameProduct;
    }

    public void setEdtNameProduct(String edtNameProduct) {
        this.edtNameProduct = edtNameProduct;
    }

    public String getEdtMarcaProduct() {
        return edtMarcaProduct;
    }

    public void setEdtMarcaProduct(String edtMarcaProduct) {
        this.edtMarcaProduct = edtMarcaProduct;
    }

    public String getEdtCateforia() {
        return edtCateforia;
    }

    public void setEdtCateforia(String edtCateforia) {
        this.edtCateforia = edtCateforia;
    }

    public String getEdtCantidad() {
        return edtCantidad;
    }

    public void setEdtCantidad(String edtCantidad) {
        this.edtCantidad = edtCantidad;
    }

    public String getEdtPriceUnit() {
        return edtPriceUnit;
    }

    public void setEdtPriceUnit(String edtPriceUnit) {
        this.edtPriceUnit = edtPriceUnit;
    }

    public byte[] getImageProductLogo() {
        return imageProductLogo;
    }

    public void setImageProductLogo(byte[] imageProductLogo) {
        this.imageProductLogo = imageProductLogo;
    }
}
