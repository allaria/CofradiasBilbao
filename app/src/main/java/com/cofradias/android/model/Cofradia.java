package com.cofradias.android.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by alaria on 25/04/2016.
 */
public class Cofradia implements Serializable {
    @Expose
    private String nombreCofradia;

    @Expose
    private int fundacion;

    @Expose
    private String sede;

    @Expose
    private int numeroPasos;

    @Expose
    private String texto;

    @Expose
    private String hermanoAbad;

    @Expose
    private String tunica;


    public String getNombreCofradia() {
        return nombreCofradia;
    }

    public void setNombreCofradia(String nombreCofradia) {
        this.nombreCofradia = nombreCofradia;
    }

    public int getFundacion() {
        return fundacion;
    }

    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getNumeroPasos() {
        return numeroPasos;
    }

    public void setNumeroPasos(int numeroPasos) {
        this.numeroPasos = numeroPasos;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getHermanoAbad() {
        return hermanoAbad;
    }

    public void setHermanoAbad(String hermanoAbad) {
        this.hermanoAbad = hermanoAbad;
    }

    public String getTunica() {
        return tunica;
    }

    public void setTunica(String tunica) {
        this.tunica = tunica;
    }


    public Cofradia() {
    }

    public Cofradia(String nombreCofradia, int fundacion, String sede, int numeroPasos, String texto, String hermanoAbad, String tunica) {
        this.nombreCofradia = nombreCofradia;
        this.fundacion = fundacion;
        this.sede = sede;
        this.numeroPasos = numeroPasos;
        this.texto = texto;
        this.hermanoAbad = hermanoAbad;
        this.tunica = tunica;
    }
}