/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenfinalfinal;

/**
 *
 * @author willy
 */
public class Piso {

    public String getIdentificadorZona() {
        return identificadorZona;
    }

    public void setIdentificadorZona(String identificadorZona) {
        this.identificadorZona = identificadorZona;
    }

    public String getIdentificadorPiso() {
        return identificadorPiso;
    }

    public void setIdentificadorPiso(String identificadorPiso) {
        this.identificadorPiso = identificadorPiso;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public int getMetroCuadrados() {
        return metroCuadrados;
    }

    public void setMetroCuadrados(int metroCuadrados) {
        this.metroCuadrados = metroCuadrados;
    }

    public String getNombrePropietario() {
        return NombrePropietario;
    }

    public void setNombrePropietario(String NombrePropietario) {
        this.NombrePropietario = NombrePropietario;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public boolean isReservado() {
        return Reservado;
    }

    public void setReservado(boolean Reservado) {
        this.Reservado = Reservado;
    }

    public Piso(String identificadorZona, String identificadorPiso, String tipoOperacion, int metroCuadrados, String NombrePropietario, int Telefono, int Precio, boolean Reservado) {
        this.identificadorZona = identificadorZona;
        this.identificadorPiso = identificadorPiso;
        this.tipoOperacion = tipoOperacion;
        this.metroCuadrados = metroCuadrados;
        this.NombrePropietario = NombrePropietario;
        this.Telefono = Telefono;
        this.Precio = Precio;
        this.Reservado = Reservado;
    }
    String identificadorZona;
String identificadorPiso;
 String tipoOperacion;
 int metroCuadrados;
 String NombrePropietario;
 int Telefono;
 int Precio;
 boolean Reservado;
}
