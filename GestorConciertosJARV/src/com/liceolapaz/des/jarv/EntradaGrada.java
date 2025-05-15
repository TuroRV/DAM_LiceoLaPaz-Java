package com.liceolapaz.des.jarv;

public class EntradaGrada extends Entrada {
protected int fila;
protected int asiento;
protected static final double PRECIO_GRADA = 59.99;

    public EntradaGrada(int código,int fila, int asiento) {
        super(código, PRECIO_GRADA);
        this.fila = fila;
        this.asiento = asiento;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    @Override
    public String toString() {
        return "Entrada " + código + " de grada " + "Fila: " +fila + " Asiento: " + asiento + " Precio: " + PRECIO_GRADA;
    }
}
