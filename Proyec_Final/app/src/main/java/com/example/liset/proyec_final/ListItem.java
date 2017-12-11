package com.example.liset.proyec_final;

/**
 * Created by LISET on 29/11/2017.
 */

public class ListItem {

    private Integer nombre;
    private String apellido;
    private Integer monto;


    public ListItem(Integer nombre,Integer monto, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.monto = monto;

    }

    public Integer getMonto() {
        return monto;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getNombre() {
        return nombre;
    }}
