package com.example.liset.proyec_final;

/**
 * Created by LISET on 29/11/2017.
 */

public class user {


    String fecha;
    int tarjeta_id;
    int cliente_id;
    double recarga;

    public double getRecarga() {
        return recarga;
    }

    public void setRecarga(double recarga) {
        this.recarga = recarga;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTarjeta_id() {
        return tarjeta_id;
    }

    public void setTarjeta_id(int tarjeta_id) {
        this.tarjeta_id = tarjeta_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }



}
