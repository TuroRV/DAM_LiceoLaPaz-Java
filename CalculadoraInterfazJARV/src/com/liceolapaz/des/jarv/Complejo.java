package com.liceolapaz.des.jarv;

public class Complejo implements Numero {
    private int real;
    private int imaginario;

    public Complejo(int real, int imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    @Override
    public Numero suma(Numero operando) {
        Numero resultado = null;
        if (operando instanceof Complejo) {
            Complejo complejo = (Complejo) operando;
            int nuevoReal = this.real + complejo.real;
            int nuevoImag = this.imaginario + complejo.imaginario;
            resultado = new Complejo(nuevoReal,nuevoImag);
        }
        return resultado;
    }

    @Override
    public Numero resta(Numero operando) {
        Numero resultado = null;
        if (operando instanceof Complejo) {
            Complejo complejo = (Complejo) operando;
            int nuevoReal = this.real - complejo.real;
            int nuevoImag = this.imaginario - complejo.imaginario;
            resultado = new Complejo(nuevoReal,nuevoImag);
        }
        return resultado;
    }

    @Override
    public Numero producto(Numero operando) {
        Numero resultado = null;
        if (operando instanceof Complejo) {
            Complejo complejo = (Complejo) operando;
            int a = this.real;
            int b = this.imaginario;
            int c = complejo.real;
            int d = complejo.imaginario;
            int nuevoReal = ((a * c) - (b * d));
            int nuevoImag = ((a * d) + (b * c));
            //int nuevoReal = (this.real * complejo.real)-(this.imaginario * complejo.imaginario);
            //int nuevoImag = (this.real * complejo.imaginario)+(this.imaginario * complejo.real);
            resultado = new Complejo(nuevoReal,nuevoImag);
        }
        return resultado;
    }

    @Override
    public Numero division(Numero operando) {
        Numero resultado = null;
        if (operando instanceof Complejo) {
            Complejo complejo = (Complejo) operando;
            int a = this.real;
            int b = this.imaginario;
            int c = complejo.real;
            int d = complejo.imaginario;
            if (complejo.real == 0 && complejo.imaginario == 0) {
                System.out.println("No se puede dividir entre 0");
            } else {
                int nuevoReal = ((a * c) + (b * d)) / ((c*c) + (d * d));
                int nuevoImag = ((b * c) - (a * d)) / ((c*c) + (d * d));
                //int nuevoReal = ((this.real * complejo.real) + (this.imaginario * complejo.imaginario)) / (int) (Math.pow(complejo.real, 2) + Math.pow(complejo.imaginario, 2));
                //int nuevoImag = ((this.imaginario * complejo.real) - (this.real * complejo.imaginario)) / (int) (Math.pow(complejo.real, 2) + Math.pow(complejo.imaginario, 2));
                resultado = new Complejo(nuevoReal, nuevoImag);
            }
        }
        return resultado;
    }

    @Override
    public String mostrar() {
        if (this.imaginario < 0 ){
            return "" + this.real + " - " + Math.abs(this.imaginario) + "i";
        } else {
            return "" + this.real + " + " + this.imaginario + "i";
        }
    }
}
