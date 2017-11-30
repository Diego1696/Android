package com.example.dal32.comedor;

/**
 * Created by dal32 on 26/10/2017.
 */

public class Comedor {

    public String getPlato1() {
        return plato1;
    }

    public void setPlato1(String plato1) {
        this.plato1 = plato1;
    }

    public String getPlato2() {
        return plato2;
    }

    public void setPlato2(String plato2) {
        this.plato2 = plato2;
    }

    public String getPostre() {
        return postre;
    }

    public void setPostre(String postre) {
        this.postre = postre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    //TITULO, DESCRIPCION, FECHA, CATEGORIA
    private String plato1, plato2, postre, fecha;

}
