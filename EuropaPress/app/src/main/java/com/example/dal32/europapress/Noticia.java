package com.example.dal32.europapress;

import android.app.Activity;
import android.view.LayoutInflater;

import java.security.AccessControlContext;

/**
 * Created by dal32 on 18/10/2017.
 */

public class Noticia {


    //TITULO, DESCRIPCION, FECHA, CATEGORIA
    private String titulo, descripcion, fecha, categoria;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
