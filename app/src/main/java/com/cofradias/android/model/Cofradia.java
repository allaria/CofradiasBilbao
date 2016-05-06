package com.cofradias.android.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alaria on 25/04/2016.
 */
public class Cofradia implements Serializable {
    //@Expose
    private String nombreCofradia;
    //@Expose
    private int fundacion;
    //@Expose
    private String sede;
    //@Expose
    private String imagenEscudo;
    //@Expose
    private String imagenDetalle;
    //@Expose
    private int numeroPasos;
    //@Expose
    private String texto;
    //@Expose
    private String hermanoAbad;
    //@Expose
    private String tunica;
    private int numeroProcesiones;

    @SerializedName("Recorrido")
    private List<Recorrido> recorridos;


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

    public String getEscudo() {
        return imagenEscudo;
    }

    public void setEscudo(String escudo) {
        this.imagenEscudo = imagenEscudo;
    }

    public String getImgagenDetalle() {
        return imagenDetalle;
    }

    public void getImgagenDetalle(String imagenDetalle) {
        this.imagenDetalle = imagenDetalle;
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

    public int getNumeroProcesiones() {
        return numeroProcesiones;
    }

    public void getNumeroProcesiones(int numeroProcesiones) {
        this.numeroProcesiones = numeroProcesiones;
    }

    public String getTunica() {
        return tunica;
    }

    public void setTunica(String tunica) {
        this.tunica = tunica;
    }

    public List<Recorrido> getRecorridos() {
        return recorridos;
    }

    public void setRecorridos(List<Recorrido> recorrido) {
        this.recorridos = recorrido;
    }


    public Cofradia() {
        this.recorridos = new ArrayList<Recorrido>();
    }

   /* public Cofradia(String nombreCofradia, int fundacion, String sede, String imagenEscudo, int numeroPasos, String texto, String hermanoAbad, String tunica, Recorrido[] recorrido) {
        this.nombreCofradia = nombreCofradia;
        this.fundacion = fundacion;
        this.sede = sede;
        this.imagenEscudo = imagenEscudo;
        this.numeroPasos = numeroPasos;
        this.texto = texto;
        this.hermanoAbad = hermanoAbad;
        this.tunica = tunica;
        this.recorrido = recorrido;
    }*/
}