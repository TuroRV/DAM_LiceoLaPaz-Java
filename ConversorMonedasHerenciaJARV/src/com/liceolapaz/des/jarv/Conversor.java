package com.liceolapaz.des.jarv;

import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
        boolean init = true;
        while (init) {showMenu();
            int option = readOption();
            switch (option) {
                case 1:
                    System.out.println("Introduzca una cantidad en Dólares");
                    double dolares = readMoney();
                    Dolar dolar = new Dolar(dolares);
                    double resultado = dolar.cantidadEnEuros();
                    System.out.println(dolares + "$ equivalen a: " + resultado + "€");
                    break;
                case 2:
                    System.out.println("Introduzca una cantidad den Libras");
                    double libras = readMoney();
                    Libra libra = new Libra(libras);
                    double resultado2 = libra.cantidadEnEuros();
                    System.out.println(libras + "£ equivalen a: " + resultado2 + "€");
                    break;
                case 3:
                    System.out.println("Introduzca una cantidad en Yenes");
                    double yenes = readMoney();
                    Yen yen = new Yen(yenes);
                    double resultado3 = yen.cantidadEnEuros();
                    System.out.println(yenes + "¥ equivalen a: " + resultado3 + "€");
                    break;
                case 0:
                    System.out.println("Cerrando aplicación");
                    init = false;
                    break;
                default:
                    System.out.println("Introduce una opción válida");
            }

}
    }

    private static double readMoney() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    private static int readOption() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void showMenu() {
        System.out.println("CONVERSOR DE MONEDAS\n" +
                "1. Dólares\n" +
                "2. Libras\n" +
                "3. Yens\n" +
                "0. Salir\n" +
                "Escoja una opción:");
    }
}
