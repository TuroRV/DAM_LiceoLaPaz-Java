package com.liceolapaz.des.jarv;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Asistente[] asistentes = new Asistente[26000];
        EntradaPista[] entradasPista = new EntradaPista[1000];
        EntradaGrada[] entradasGrada = new EntradaGrada[25000];

        int backstage = 100;

boolean init = true;
while(init){
    System.out.println("GESTOR CONCIERTOS\n" +
            "1. Reservar entrada\n" +
            "2. Mostrar entrada\n" +
            "3. Listar entradas vendidas\n" +
            "4. Mostrar número de entradas disponibles\n" +
            "0. Salir\n" +
            "Escoja una opción:");

    int option = readOption();

    switch(option) {
        case 1:
            System.out.println("Escoja el tipo de entrada:\n" +
                    "1.Grada\n" +
                    "2.Pie de pista\n" +
                    "0.Volver atrás");

            int option2 = readOption();

            switch (option2) {
                case 1:
                    EntradaGrada grada1 = new EntradaGrada(0, 0, 0);
                    System.out.println("El precio de Entrada Grada es de: " + grada1.getPrecio() + "\n" +
                            "Desea continuar? S/N");
                    String answer = readString();

                    if (answer.equals("S")) {
                        System.out.println("Introduzca su nombre:");
                        String nombre = readString();
                        System.out.println("Introduzca el primer apellido:");
                        String apellido = readString();
                        System.out.println("Introduzca el segundo apellido:");
                        String apellido2 = readString();
                        System.out.println("Introduzca su DNI:");
                        String dni = readString();
                        System.out.println("Introduzca su email:");
                        String email = readString();
                        System.out.println("Introduzca su año de nacimiento:");
                        int nacimiento = readOption();

                        Asistente asistente1 = null;


                        for (int i = 0; i < asistentes.length; i++) {
                            if (asistentes[i] == null) {
                                asistentes[i] = new Asistente(nombre, apellido, apellido2, dni, email, nacimiento);
                                asistente1 = asistentes[i];
                                break;
                            }
                        }

                        System.out.println("Datos guardados.\n" +
                                "Introduzca el número de fila que desea entre 1-25:");
                        int fila = readOption();

                        System.out.println("Introduzca el número de asiento que desea entre 1-1000");
                        int asiento = readOption();

                        for (int i = 0; i < entradasGrada.length; i++) {
                            if (entradasGrada[i] == null) {
                                entradasGrada[i] = new EntradaGrada(i, fila, asiento);
                                asistente1.setEntradaAsistente(entradasGrada[i]);
                                break;
                            }
                        }

                        System.out.println("Entrada " + asistente1.getEntradaAsistente().getCódigo() + " correctamente asignada a usuario " + asistente1.getEmail());
                        break;

                    } else if (answer.equals("N")) {
                        break;
                    } else {
                        System.out.println("Opción no válida");
                    }
                    break;
                case 2:

            }
            break;
        case 2:
            System.out.println("Introduzca el email de usuario para buscar su entrada: ");
            String email = readString();
            for (int i = 0; i < asistentes.length; i++) {
                if (asistentes[i] != null) {

                    if (asistentes[i].getEmail().equals(email)) {
                        System.out.println("Los datos de la entrada del email: " + email + " son:\n" +
                                asistentes[i].getEntradaAsistente().toString());
                        break;
                    } else if (i == asistentes.length - 1) {
                        System.out.println("No se encuentra el email");
                        break;
                    }
                }
            }
            break;
        case 3:
            System.out.println("Entradas vendidas:");
            for (int i = 0; i < asistentes.length; i++) {
                if (asistentes[i] != null) {
                    System.out.println(asistentes[i].toString());
                }
            }
            break;
        case 4:

            int gradaDisponibles = 0;
            int pistaDisponibles = 0;

            for (int i = 0; i < entradasGrada.length; i++) {
                if (entradasGrada[i] == null) {
                    gradaDisponibles++;
                }
            }

            for (int i = 0; i < entradasPista.length; i++) {
                if (entradasPista[i] == null) {
                    pistaDisponibles++;
                }
            }

            System.out.println("Entradas de grada disponibles: " + gradaDisponibles + "\n" +
                    "Entradas de pista disponibles: " + pistaDisponibles + "\n" +
                    "Backstage: " + backstage);
            break;
        case 0:
            System.out.println("Cerrando aplicación");
            init = false;
            break;
        default:
            System.out.println("Introduzca una opción válida");
        }
    }

    }

    private static String readString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static int readOption() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
}
