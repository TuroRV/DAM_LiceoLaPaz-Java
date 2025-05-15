package com.liceolapaz.des.jarv;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        do {
            showMenu();
            int opcion = leerEntero();
            switch (opcion) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                    showMenu2();
                    int opcion2 = leerEntero();
                    switch (opcion2) {
                        case 0:
                            break;
                        case 1:
                            System.out.println("Escriba el valor del primer operando: ");
                            int valor1 = leerEntero();
                            System.out.println("Escriba el valor del segundo operando: ");
                            int valor2 = leerEntero();
                            Entero op1 = new Entero(valor1);
                            Entero op2 = new Entero(valor2);
                            Numero resultado = null;
                            switch (opcion) {
                                case 1:
                                    resultado = op1.suma(op2);
                                    break;
                                case 2:
                                    resultado = op1.resta(op2);
                                    break;
                                case 3:
                                    resultado = op1.producto(op2);
                                    break;
                                case 4:
                                    resultado = op1.division(op2);
                                    break;
                            }
                            if (resultado != null) {
                                System.out.println("El resultado de la operación es: " + resultado.mostrar());
                            }
                            break;
                        case 2:
                            System.out.println("Escriba el numerador del primer operando: ");
                            int numerador1 = leerEntero();
                            System.out.println("Escriba el denominador del primer operando: ");
                            int denominador1 = leerEntero();
                            System.out.println("Escriba el numerador del segundo operando: ");
                            int numerador2 = leerEntero();
                            System.out.println("Escriba el denominador del segundo operando: ");
                            int denominador2 = leerEntero();
                            Racional rac1 = new Racional(numerador1, denominador1);
                            Racional rac2 = new Racional(numerador2, denominador2);
                            Numero resultado2 = null;
                            switch (opcion) {
                                case 1:
                                    resultado2 = rac1.suma(rac2);
                                    break;
                                case 2:
                                    resultado2 = rac1.resta(rac2);
                                    break;
                                case 3:
                                    resultado2 = rac1.producto(rac2);
                                    break;
                                case 4:
                                    resultado2 = rac1.division(rac2);
                                    break;
                            } if (resultado2 != null){
                            System.out.println("El resultado de la operación es: " + resultado2.mostrar());
                        }
                            break;
                        case 3:
                            System.out.println("Escriba la parte real del primer operando: ");
                            int real1 = leerEntero();
                            System.out.println("Escriba la parte imaginaria del primer operando: ");
                            int imag1 = leerEntero();
                            System.out.println("Escriba la parte real del segundo operando: ");
                            int real2 = leerEntero();
                            System.out.println("Escriba la parte imaginaria del segundo operando: ");
                            int imag2 = leerEntero();
                            Complejo complejo1 = new Complejo(real1, imag1);
                            Complejo complejo2 = new Complejo(real2, imag2);
                            Numero resultado3 = null;
                            switch (opcion) {
                                case 1:
                                    resultado3 = complejo1.suma(complejo2);
                                    break;
                                case 2:
                                    resultado3 = complejo1.resta(complejo2);
                                    break;
                                case 3:
                                    resultado3 = complejo1.producto(complejo2);
                                    break;
                                case 4:
                                    resultado3 = complejo1.division(complejo2);
                                    break;
                            }
                                    if (resultado3!=null){
                                        System.out.println("El resultado de la operación es: " + resultado3.mostrar());
                                    }
                            break;
                        default:
                            System.out.println("Opcion no válida");
                            break;
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (true);
    }

    private static void showMenu2() {
        System.out.println("Tipo de números\n" +
                "1. Números enteros\n" +
                "2. Números racionales\n" +
                "3. Números complejos\n" +
                "0. Cancelar\n" +
                "Escoja una opción:");
    }

    private static int leerEntero() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void showMenu() {
        System.out.println("CALCULADORA\n" +
                "1. Suma\n" +
                "2. Resta\n" +
                "3. Producto\n" +
                "4. División\n" +
                "0. Salir\n" +
                "Escoja una opción:");
    }
}
