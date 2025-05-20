package com.liceolapaz.des.jarv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static HashMap<Integer, User> users = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int option = readInt();
            switch (option) {
                case 0:
                    System.out.println("Cerrando aplicación");
                    break;
                case 1:
                    importUsers();
                    break;
                case 2:
                    addUser();
                    break;
                case 3:
                    modifyUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    exportUsers();
                    break;
            }
        }

    }


    private static void exportUsers() {
    }

    private static void deleteUser() {
    }

    private static void modifyUser() {
    }

    private static void addUser() {
    }

    private static void importUsers() {
        System.out.println("Introduzca la ruta del archivo a importar:");
        String path = readString();
        File file = new File(path);
        if (!file.isFile()) {
            System.out.println("Archivo no encontrado");
            return;
        }
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = sc.nextLine();
            if (line.equals("]")) {
                break;
            }
            line = sc.nextLine();
            String[] parts = line.split(": ");
            String trimmedPart = parts[1].substring(0, parts[1].length() - 1);
            int id = Integer.parseInt(trimmedPart);
            line = sc.nextLine();
            parts = line.split(": \"");
            trimmedPart = parts[1].substring(0, parts[1].length() - 2);
            String email = trimmedPart;
            line = sc.nextLine();
            parts = line.split(": \"");
            trimmedPart = parts[1].substring(0, parts[1].length() - 2);
            String firstName = trimmedPart;
            line = sc.nextLine();
            parts = line.split(": \"");
            trimmedPart = parts[1].substring(0, parts[1].length() - 2);
            String lastName = trimmedPart;
            line = sc.nextLine();
            parts = line.split(": \"");
            trimmedPart = parts[1].substring(0, parts[1].length() - 1);
            String avatar = trimmedPart;

            User user = new User(id, email, firstName, lastName, avatar);
            users.put(id, user);
        }
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
        System.out.println("GESTOR USUARIOS\n" +
                "1. Importar usuarios\n" +
                "2. Añadir usuario\n" +
                "3. Modificar usuario\n" +
                "4. Eliminar usuario\n" +
                "5. Exportar usuarios\n" +
                "0. Salir\n" +
                "Escoja una opción:");
    }
}
