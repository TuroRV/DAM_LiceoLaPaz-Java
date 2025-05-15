package com.liceolapaz.des.jarv;

public class Yen extends Moneda{
    double tasaYen = 0.00779327499;

    public Yen(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    protected double cantidadEnEuros() {
        return cantidad * tasaYen;
    }
}
