package com.edissonescandon.projectmobile;

public class DetalleProducto {
    private String nombre;
    private String cantidad;
    private String total_pagar;
    private String fecha_compra;
    private String descripcion;

    public DetalleProducto(String nombre, String cantidad, String total_pagar, String fecha_compra, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.total_pagar = total_pagar;
        this.fecha_compra = fecha_compra;
        this.descripcion = descripcion;
    }

    public DetalleProducto() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTotal_pagar() {
        return total_pagar;
    }

    public void setTotal_pagar(String total_pagar) {
        this.total_pagar = total_pagar;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
