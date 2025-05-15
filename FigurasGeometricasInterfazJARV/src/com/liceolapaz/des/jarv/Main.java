package com.liceolapaz.des.jarv;

import java.util.Scanner;

public class Main {
    public static boolean init = true;

    public static void main(String[] args) {
        while (init) {
showMenu();
int option = readOption();
switch (option) {
    case 1:
        System.out.println("Introduzca el valor del primer lado (base) del triángulo: ");
        double base = readOptionDouble();
        System.out.println("Introduzca el valor del segundo lado del triángulo: ");
        double lado2 = readOptionDouble();
        System.out.println("Introduzca el valor del tercer lado del triángulo: ");
        double lado3 = readOptionDouble();
        System.out.println("Introduzca la altura del triángulo: ");
        double altura = readOptionDouble();
        Triangulo triangulo1 = new Triangulo(base,lado2,lado3,altura);
        double areaT = triangulo1.calcularArea();
        double perimetroT = triangulo1.calcularPerimetro();
        System.out.println("El área del triángulo es: " + areaT + "\n" + "El perímetro del triángulo es: " + perimetroT);
        break;
    case 2:
        System.out.println("Introduzca la base del rectángulo: ");
        double baseR = readOptionDouble();
        System.out.println("Introduzca la altura del rectangulo: ");
        double alturaR = readOptionDouble();
        Rectangulo rectangulo1 = new Rectangulo(baseR,alturaR);
        double areaR = rectangulo1.calcularArea();
        double perimetroR = rectangulo1.calcularPerimetro();
        System.out.println("El área del rectángulo es: " + areaR + "\n" + "El perímetro del rectángulo es: " + perimetroR);
        break;
    case 3:
        System.out.println("Introduzca el lado del cuadrado: ");
        double ladoC = readOptionDouble();
        Cuadrado cuadrado1 = new Cuadrado(ladoC);
        double areaC = cuadrado1.calcularArea();
        double perimetroC = cuadrado1.calcularPerimetro();
        System.out.println("El área del cuadrado es: " + areaC + "\n" + "El perímetro del cuadrado es: " + perimetroC);
        break;
    case 4:
        System.out.println("Introduzca el número de lados del polígono: ");
        int nLados = readOption();
        System.out.println("Introduzca la longitud del lado del polígono: ");
        double ladoPoligono = readOptionDouble();
        System.out.println("Introduzca el apotema del polígono: ");
        double apotema = readOptionDouble();
        Pentagono poligono = new Pentagono(ladoPoligono,apotema,nLados);
        double areaP = poligono.calcularArea();
        double perimetroP = poligono.calcularPerimetro();
        System.out.println("El área del polígono es: " + areaP + "\n" + "El perímetro del polígono es: " + perimetroP);
        break;
    case 0:
        System.out.println("Saliendo de la aplicación");
        init = false;
        break;
    default:
        System.out.println("Opción no válida");
}
    }
    }

    private static double readOptionDouble() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }


    private static int readOption() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void showMenu() {
        System.out.println("FIGURAS GEOMÉTRICAS\n" +
                "1. Triángulo\n" +
                "2. Rectángulo\n" +
                "3. Cuadrado\n" +
                "4. Pentágono\n" +
                "0. Salir\n" +
                "Escoja una opción:");
    }

}
