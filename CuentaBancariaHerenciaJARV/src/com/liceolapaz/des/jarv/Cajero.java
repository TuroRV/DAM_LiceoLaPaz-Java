package com.liceolapaz.des.jarv;

import java.util.Scanner;

public class Cajero {
    static boolean init=true;
    public static void main(String[] args) {
        CuentaBancaria cuentaBancaria = null;
        while (init){
            showMenu();
            int option = readOption();
            switch(option){
                case 1:
                    showMenu2();
                    int option2 = readOption();
                    switch(option2){
                        case 1:
                            System.out.println("Introduzca el saldo para la cuenta normal: ");
                            double saldoNormal = readDouble();
                            cuentaBancaria = new CuentaNormal(saldoNormal);
                            break;
                        case 2:
                            System.out.println("Introduzca el saldo para la cuenta premium: ");
                            double saldoPremium = readDouble();
                            cuentaBancaria = new CuentaPremium(saldoPremium);
                            break;
                        case 0:
                            break;
                    }
                    break;
                case 2:
                    if (cuentaBancaria == null){
                        System.out.println("El usuario no tiene una cuenta creada.");
                    } else {
                        System.out.println("Introduzca la cantidad a ingresar");
                        double ingreso = readDouble();
                        cuentaBancaria.ingresarDinero(ingreso);
                        System.out.println("Se han ingresado " + ingreso + " en su cuenta. El saldo actual es " + cuentaBancaria.consultarSaldo());
                    }
                    break;
                case 3:
                    if (cuentaBancaria == null){
                        System.out.println("El usuario no tiene una cuenta creada.");
                    } else {
                        System.out.println("Introduzca la cantidad a retirar");
                        double retirada = readDouble();
                        cuentaBancaria.retirarDinero(retirada);
                        if (cuentaBancaria.consultarSaldo() >= retirada){
                            System.out.println("Se han retirado " + retirada + " de su cuenta. El saldo actual es " + cuentaBancaria.consultarSaldo());
                        }
                    }
                    break;
                case 4:
                    if (cuentaBancaria == null){
                        System.out.println("El usuario no tiene una cuenta creada.");
                    } else {
                        cuentaBancaria.consultarSaldo();
                    }
                    break;
                case 0:
                    System.out.println("Cerrando aplicación");
                    init = false;
                    break;
                default:
                    System.out.println("Introduzca una opción válida");
                    break;
            }
        }

    }

    private static void showMenu2() {
        System.out.println("Tipo de cuenta\n" +
                "1. Cuenta normal\n" +
                "2. Cuenta Premium\n" +
                "0. Cancelar\n" +
                "Escoja una opción:");
    }

    private static double readDouble() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    private static int readOption() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void showMenu() {
        System.out.println("BANCO\n" +
                "1. Crear cuenta\n" +
                "2. Ingresar dinero\n" +
                "3. Retirar dinero\n" +
                "4. Consultar saldo\n" +
                "0. Salir\n" +
                "Escoja una opción:");
    }
}
