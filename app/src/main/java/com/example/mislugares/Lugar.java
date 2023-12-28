package com.example.mislugares;

public class Lugar {
    int foto;
    String nombre;
    String direccion;
    String web;
    String tlf;
    String descrip;
    String tipo;

    public Lugar(int foto, String nombre, String direccion, String web, String tlf, String descrip, String tipo) {
        this.foto = foto;
        this.nombre = nombre;
        this.direccion = direccion;
        this.web = web;
        this.tlf = tlf;
        this.descrip = descrip;
        this.tipo = tipo;
    }

    public Lugar(int foto, String nombre, String descripcion) {
        this.foto = foto;
        this.nombre = nombre;
        this.direccion = descripcion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
