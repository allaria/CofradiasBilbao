package com.cofradias.android.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alaria on 27/04/2016.
 */
public class Recorrido implements Serializable {

    private String nombreProcesion, imagenProcesion, ruta;

    @SerializedName("coordenadas")
    private List<Coordenadas> coordenadas;

    public String getNombreProcesion() {
        return nombreProcesion;
    }

    public void setNombreProcesion(String nombreProcesion) {
        this.nombreProcesion = nombreProcesion;
    }

    public String getImagenProcesion() {
        return imagenProcesion;
    }

    public void getImagenProcesion(String imagenProcesion) {
        this.imagenProcesion = imagenProcesion;
    }

    public String getRutaProcesion() {
        return ruta;
    }

    public void getRutaProcesion(String ruta) {
        this.ruta = ruta;
    }

    public List<Coordenadas> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(List<Coordenadas> coordenada) {
        this.coordenadas = coordenada;
    }


    public Recorrido() {
        this.coordenadas = new ArrayList<Coordenadas>();
    }
}
