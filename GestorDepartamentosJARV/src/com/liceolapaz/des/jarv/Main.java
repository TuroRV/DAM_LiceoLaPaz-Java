package com.liceolapaz.des.jarv;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static ArrayList<Department> departments = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            showMenu();
            int option;
            try {
                option = readInt();
            } catch (InputMismatchException e) {
                System.out.println("El valor debe ser un número entero.");
                return;
            }
            switch (option) {
                case 0:
                    System.out.println("Cerrando aplicación");
                    System.exit(0);
                    break;
                case 1:
                    importDepartments();
                    break;
                case 2:
                    addDepartments();
                    break;
            }
        }
    }

    private static void addDepartments() {
        System.out.println("Introduzca el número de departamento a añadir");
        try {
            int depNumber = readInt();
            if (departments.contains(depNumber)) {xx}

        } catch (InputMismatchException e) {
            System.out.println("El número de departamento tiene que ser un número entero");
        }
    }

    private static void importDepartments() {
        System.out.println("Introduzca la ruta del archivo de departamentos: ");
        String path = readString();
        File file = new File(path);
        if (!file.isFile()) {
            System.out.println("Ruta incorrecta o el archivo no existe.");
            return;
        }
        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] line1 = line.split(";");
                int depNumber = 0;
                try {
                    depNumber = Integer.parseInt(line1[0]);
                } catch (InputMismatchException e) {
                    System.out.println("Error, número de departamento debe ser un número entero");
                    return;
                }
                if (depNumber == 0) {
                    System.out.println("Error, el número de departamento no puede ser 0");
                    return;
                }
                String name = line1[1];
                if (name.isEmpty()) {
                    System.out.println("Error, nombre de departamento vacío.");
                    return;
                }
                String shortName = line1[2];
                if (shortName.isEmpty()) {
                    System.out.println("Error, abreviatura de departamento vacía.");
                    return;
                }
                int depFLoor = 0;
                try {
                    depFLoor = Integer.parseInt(line1[3]);
                } catch (InputMismatchException e) {
                    System.out.println("Error, el número de planta debe ser un número entero.");
                    return;
                }
                String cifDirector = line1[4];
                if (cifDirector.isEmpty()) {
                    System.out.println("Error, CIF de director vacío.");
                    return;
                }
                if (!checkCIF(cifDirector)) {
                    System.out.println("Error, CIF de director no valido.");
                    return;
                }
                ;
                String email = line1[5];
                if (email.isEmpty()) {
                    System.out.println("Error, email vacío.");
                    return;
                }
                if (!checkEmail(email)) {
                    System.out.println("Error, formato de email no válido.");
                    return;
                }
                Department department = new Department(depNumber, name, shortName, depFLoor, cifDirector, email);
                departments.add(department);
            }

            System.out.println("Se han importado " + departments.size() + " departamentos");

        } catch (FileNotFoundException e) {
            System.out.println("Ruta incorrecta o el archivo no existe.");
        }

    }

    private static boolean checkEmail(String email) {

        String regexPattern = "^(.+)@(\\S+)$";
        if (!email.matches(regexPattern)) {
            return false;
        }
        return true;
    }

    private static boolean checkCIF(String cifDirector) {
        String[] parts = cifDirector.split("-");
        if (parts[0].length() != 8) {
            System.out.println("Error, formato de CIF incorrecto");
            return false;
        }
        String letters = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        if (!letters.contains(parts[1])) {
            System.out.println("Error, letra de CIF incorrecta");
            return false;
        }
        return true;
    }

    private static String readString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static int readInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void showMenu() {
        System.out.println("GESTOR DEPARTAMENTOS\n" +
                "1. Importar departamentos\n" +
                "2. Añadir departamento\n" +
                "3. Modificar departamento\n" +
                "4. Eliminar departamento\n" +
                "5. Exportar departamentos\n" +
                "0. Salir\n" +
                "Escoja una opción:");
    }
}
