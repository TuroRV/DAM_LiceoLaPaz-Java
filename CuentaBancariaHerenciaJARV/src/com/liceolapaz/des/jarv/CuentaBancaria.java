package com.liceolapaz.des.jarv;

public abstract class CuentaBancaria {

    private double saldo;

    public CuentaBancaria(double saldo) {
        this.saldo = saldo;
    }

    protected void ingresarDinero(double cantidad){
        if (cantidad <=0) {
            System.out.println("El valor a ingresar debe ser un número positivo");
        }
        else {
        this.saldo += cantidad;
        System.out.println(cantidad + "ingresado, el nuevo saldo es: " + this.saldo);
        }
    }
    protected void retirarDinero(double cantidad) {
        {
            if (cantidad <= 0) {
                System.out.println("El valor a retirar tiene que ser un número positivo");
            } else {
                this.saldo -= cantidad;
                System.out.println(cantidad + " retirado. El saldo actual es: " + this.saldo);
            }
        }
    }
    protected double consultarSaldo(){
        return this.saldo;
    }
}
