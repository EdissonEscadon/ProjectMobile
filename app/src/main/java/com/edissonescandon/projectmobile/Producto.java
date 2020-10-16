package com.edissonescandon.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Producto  {
    private String id_producto;
    private String nombre;
    private String precio;
    private String modelo;
    private  String descripcion;
    private String id_compra;


    public Producto(String id_producto, String nombre, String precio, String modelo, String descripcion, String id_compra) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.id_compra = id_compra;
    }

    public Producto() {
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId_compra() {
        return id_compra;
    }

    public void setId_compra(String id_compra) {
        this.id_compra = id_compra;
    }
}