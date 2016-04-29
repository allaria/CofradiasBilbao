package com.cofradias.android.model;

import java.io.Serializable;

/**
 * Created by alaria on 29/04/2016.
 */
public class Coordenadas implements Serializable {

    private String longitud, latitud;

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        latitud = latitud;
    }
}
