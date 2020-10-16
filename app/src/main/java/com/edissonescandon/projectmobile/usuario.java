package com.edissonescandon.projectmobile;

public class usuario {
    private String loguin;
    private String contraseña;
    private  String Telefono;
    private String Correo;
    private String Direccion;

    public usuario(String loguin) {
        this.loguin = loguin;
    }

    public usuario(String loguin, String contraseña, String telefono, String correo, String direccion) {
        this.loguin = loguin;
        this.contraseña = contraseña;
        Telefono = telefono;
        Correo = correo;
        Direccion = direccion;
    }

    public String getUsuario() {
        return loguin;
    }

    public void setUsuario(String loguin) {
        this.loguin = loguin;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
     public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
}
