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
                case 3:
                    modifyDepartment();
                    break;
                case 4:
                    deleteDepartment();
                    break;
                case 5:
                    exportDepartments();
                    break;
            }
        }
    }

    private static void exportDepartments() {
        if (departments.isEmpty()) {
            System.out.println("No hay departamentos a exportar.");
            return;
        }
        System.out.println("Introduzca la ruta del archivo para exportar los departamentos");
        String destinationPath = readString();
        File file = new File(destinationPath);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println("num_depto;nombre;nombre_corto;planta;cif_director;correo_e");
            for (Department department : departments) {
                pw.println(department);
            }
            pw.close();
            System.out.println("Departamentos exportados correctamente");
        } catch (IOException e) {
            System.out.println("Error escribiendo fichero");
        }

    }

    private static void deleteDepartment() {
        System.out.println("Introduzca el id del departamento a borrar:");
        int searchDepNumber = readInt();
        boolean hasDepartment = false;
        for (Department department : departments) {
            if (department.getDepNumber()!=searchDepNumber) {
                hasDepartment = false;
            } else {
                hasDepartment = true;
                System.out.println("Está seguro de que desea borrar el departamento " + department.getDepNumber() + " " + department.getDepName() + "?");
                System.out.println("S/N");
                String answer = readString();
                while (!answer.equalsIgnoreCase("s") && !(answer.equalsIgnoreCase("n"))) {
                    System.out.println("Introduzca una opción válida");
                    answer = readString();
                }
                if (answer.equalsIgnoreCase("S")) {
                    departments.remove(department);
                    System.out.println("Departamento borrado correctamente");
                    return;
                } else if (answer.equalsIgnoreCase("N")) {
                    System.out.println("Borrado cancelado por el usuario");
                    return;
                }
            }
        }
    }

    private static void modifyDepartment() {
        System.out.println("Introduzca el id del departamento a modificar:");
        int searchDepNumber = readInt();
        boolean hasDepartment = false;
        for (Department department : departments) {
            if (department.getDepNumber()!=searchDepNumber) {
                hasDepartment = false;
            } else {
                hasDepartment = true;
                System.out.println("Introudzca el nuevo nombre de departamento:");
                String newName = readString();
                department.setDepName(newName);
                System.out.println("Introduzca el nuevo nombre abreviado de departamento:");
                String newDepShortName = readString();
                department.setDepShortName(newDepShortName);
                System.out.println("Introduzca el nuevo número de piso de departamento:");
                try {
                int newDepFloorNumber = readInt();
                department.setDepFloor(newDepFloorNumber);
                System.out.println("Introduzca el CIF de director de departamento con formato \"00000000-X\": ");
                String newDirectorCif = readString();
                if (!checkCIF(newDirectorCif)) {
                    System.out.println("Error en el formato del CIF");
                    return;
                }
                department.setDirectorCif(newDirectorCif);
                System.out.println("Introduzca el nuevo email de departamento:");
                String newEmail = readString();
                if (!checkEmail(newEmail)) {
                    System.out.println("Error en el formato del email");
                    return;
                }
                department.setEmail(newEmail);
                System.out.println("Todos los datos actualizados correctamente");
                } catch (InputMismatchException e) {
                    System.out.println("El número de departamento tiene que ser un número entero");
                }

            }
        }

        if (!hasDepartment) {
            System.out.println("Departamento no encontrado");
        }
    }

    private static void addDepartments() {
        System.out.println("Introduzca el número de departamento a añadir");
        try {
            int depNumber = readInt();
            for (Department department: departments) {
                if (department.getDepNumber() == depNumber) {
                    System.out.println("Ya hay un departamento registrado con ese número");
                    return;
                }
            }
            System.out.println("Introduzca el nombre del departamento:");
            String depName = readString();
            System.out.println("Introduzca el nombre abreviado del departamento:");
            String depShortName = readString();
            System.out.println("Introduzca el número de piso del departamento:");
            int depFloor = readInt();
            System.out.println("Introduzca el CIF de director de departamento con formato \"00000000-X\": ");
            String directorCif = readString();
            if (!checkCIF(directorCif)) {
                System.out.println("Formato de CIF incorrecto");
                return;
            }
            System.out.println("Introduzca el email de departamento:");
            String email = readString();
            if (!checkEmail(email)) {
                System.out.println("El formato de email es incorrecto.");
                return;
            }

            Department department = new Department(depNumber, depName, depShortName, depFloor, directorCif, email);
            departments.add(department);
            System.out.println("Departamento añadido correctamente.");

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
