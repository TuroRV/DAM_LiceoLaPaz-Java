package com.liceolapaz.des.jarv;

public class CuentaNormal extends CuentaBancaria{

    public CuentaNormal(double saldo) {
        super(saldo);
    }

    @Override
    protected void retirarDinero(double cantidad) {

        if (cantidad > consultarSaldo()) {
            System.out.println("Error, el saldo no puede ser negativo en las cuentas normales");
    }   else {
            super.retirarDinero(cantidad);
            }
    }
}
