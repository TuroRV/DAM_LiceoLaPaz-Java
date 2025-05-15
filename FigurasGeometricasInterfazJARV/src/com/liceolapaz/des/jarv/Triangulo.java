package com.liceolapaz.des.jarv;

public class Triangulo implements FiguraGeometrica {

    double lado1, lado2, lado3 , altura;

    public Triangulo(double lado1, double lado2, double lado3, double altura) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (lado1 * altura)/2;
    }

    @Override
    public double calcularPerimetro() {
        return lado1+lado2+lado3;
    }
}
