package com.liceolapaz.des.jarv;

public class Dolar extends Moneda{
    protected double tasaConversion = 0.883509299;

    public Dolar(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    protected double cantidadEnEuros() {

        return cantidad * tasaConversion;
    }
}

