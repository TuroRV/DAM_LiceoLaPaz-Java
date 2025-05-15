package com.liceolapaz.des.jarv;

public class Pentagono implements FiguraGeometrica {

    double lado;
    double apotema;
    double nLados;

    public Pentagono(double lado, double apotema, int nLados) {
        this.lado = lado;
        this.apotema = apotema;
        this.nLados = nLados;
    }

    @Override
    public double calcularArea() {
        return (calcularPerimetro() * apotema)/2;
    }

    @Override
    public double calcularPerimetro() {
        return lado*nLados;
    }
}
