package com.liceolapaz.des.jarv;

public class Racional implements Numero{
    private int numerador;
    private int denominador;

    public Racional(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    @Override
    public Numero suma(Numero operando) {
        Numero resultado = null;
        if (operando instanceof Racional) {
            Racional rac = (Racional) operando;
            int nuevoNumerador = (this.numerador * rac.denominador) + (this.denominador * rac.numerador);
            int nuevoDenominador = this.denominador * rac.denominador;
            while (nuevoNumerador % 2 == 0 && nuevoDenominador % 2 == 0) {
                nuevoNumerador = nuevoNumerador / 2;
                nuevoDenominador = nuevoDenominador / 2;
            }
            while (nuevoNumerador % 3 == 0 && nuevoDenominador % 3 == 0) {
                nuevoNumerador = nuevoNumerador / 3;
                nuevoDenominador = nuevoDenominador / 3;
            }
            while (nuevoNumerador % 5 == 0 && nuevoDenominador % 5 == 0) {
                nuevoNumerador = nuevoNumerador / 5;
                nuevoDenominador = nuevoDenominador / 5;
            }
            resultado = new Racional(nuevoNumerador, nuevoDenominador);
        } else {
            System.out.println("Sólo se puede operar con números racionales");
        }
        return resultado;
    }

    @Override
    public Numero resta(Numero operando) {
        Numero resultado = null;
        if (operando instanceof Racional) {
            Racional rac = (Racional) operando;
            int nuevoNumerador = (this.numerador * rac.denominador)-(this.denominador * rac.numerador);
            int nuevoDenominador = this.denominador * rac.denominador;
            while (nuevoNumerador % 2 == 0 && nuevoDenominador % 2 == 0) {
                nuevoNumerador = nuevoNumerador / 2;
                nuevoDenominador = nuevoDenominador / 2;
            }
            while (nuevoNumerador % 3 == 0 && nuevoDenominador % 3 == 0) {
                nuevoNumerador = nuevoNumerador / 3;
                nuevoDenominador = nuevoDenominador / 3;
            }
            while (nuevoNumerador % 5 == 0 && nuevoDenominador % 5 == 0) {
                nuevoNumerador = nuevoNumerador / 5;
                nuevoDenominador = nuevoDenominador / 5;
            }
            resultado = new Racional(nuevoNumerador, nuevoDenominador);
        } else {
            System.out.println("Sólo se puede operar con números racionales");
        }
        return resultado;
    }

    @Override
    public Numero producto(Numero operando) {
        Numero resultado = null;
        if (operando instanceof Racional) {
            Racional rac = (Racional) operando;
            int nuevoNumerador = this.numerador * rac.numerador;
            int nuevoDenominador = this.denominador * rac.denominador;
            while (nuevoNumerador % 2 == 0 && nuevoDenominador % 2 == 0) {
                nuevoNumerador = nuevoNumerador / 2;
                nuevoDenominador = nuevoDenominador / 2;
            }
            while (nuevoNumerador % 3 == 0 && nuevoDenominador % 3 == 0) {
                nuevoNumerador = nuevoNumerador / 3;
                nuevoDenominador = nuevoDenominador / 3;
            }
            while (nuevoNumerador % 5 == 0 && nuevoDenominador % 5 == 0) {
                nuevoNumerador = nuevoNumerador / 5;
                nuevoDenominador = nuevoDenominador / 5;
            }
            resultado = new Racional(nuevoNumerador, nuevoDenominador);
        } else {
            System.out.println("Sólo se puede operar con números racionales");
        }
        return resultado;
    }

    @Override
    public Numero division(Numero operando) {
        Numero resultado = null;
        if (operando instanceof Racional) {
            Racional rac = (Racional) operando;
            int nuevoNumerador = this.numerador * rac.denominador;
            int nuevoDenominador = this.denominador * rac.numerador;
            while (nuevoNumerador % 2 == 0 && nuevoDenominador % 2 == 0) {
                nuevoNumerador = nuevoNumerador / 2;
                nuevoDenominador = nuevoDenominador / 2;
            }
            while (nuevoNumerador % 3 == 0 && nuevoDenominador % 3 == 0) {
                nuevoNumerador = nuevoNumerador / 3;
                nuevoDenominador = nuevoDenominador / 3;
            }
            while (nuevoNumerador % 5 == 0 && nuevoDenominador % 5 == 0) {
                nuevoNumerador = nuevoNumerador / 5;
                nuevoDenominador = nuevoDenominador / 5;
            }
            resultado = new Racional(nuevoNumerador, nuevoDenominador);
        } else {
            System.out.println("Sólo se puede operar con números racionales");
        }
        return resultado;
    }

    @Override
    public String mostrar() {
        if (this.denominador == 1) {
            return "" + this.numerador;
        } else {
        return "" + this.numerador + "/" + this.denominador;
    }
}
}