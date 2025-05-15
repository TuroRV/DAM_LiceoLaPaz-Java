package com.liceolapaz.des.jarv;

public class Libra extends Moneda{
    double tasaLibra = 1.1029861;

    public Libra(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    protected double cantidadEnEuros() {
        return cantidad * tasaLibra;
    }
}
