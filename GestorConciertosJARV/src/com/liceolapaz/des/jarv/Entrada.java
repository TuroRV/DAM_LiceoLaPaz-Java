package com.liceolapaz.des.jarv;

public abstract class Entrada {
    protected int código;
    protected double precio;

    public Entrada(int código, double precio) {
        this.código = código;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCódigo() {
        return código;
    }

    public void setCódigo(int código) {
        this.código = código;
    }
}
