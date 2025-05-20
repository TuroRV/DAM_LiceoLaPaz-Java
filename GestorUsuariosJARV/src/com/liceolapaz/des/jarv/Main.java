package com.liceolapaz.des.jarv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
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
        System.out.println("Introduzca el id del usuario que desea eliminar: ");
        try {
            int id = readInt();
            if (!users.containsKey(id)) {
                System.out.println("El usuario no existe");
                return;
            }
            System.out.println("Está seguro que desea eliminar al usuario: " + users.get(id) + "? S/N");
            String answer = readString();
            while (!answer.equalsIgnoreCase("S") && !answer.equalsIgnoreCase("N")) {
                System.out.println("Introduzca una opción correcta");
                answer = readString();
            }
            if (answer.equalsIgnoreCase("S")) {
                users.remove(id);
                System.out.println("Usuario eliminado");
                return;
            }
            if (answer.equalsIgnoreCase("N")) {
                System.out.println("Borrado cancelado");
                return;
            }

        } catch (InputMismatchException e) {
            System.out.println("El id debe ser un número entero");
        }
    }

    private static void modifyUser() {
        System.out.println("Introduzca el id del usuario a modificar:");
        try {
            int id = readInt();
            if (!users.containsKey(id)) {
                System.out.println("El usuario no existe");
                return;
            }
            System.out.println("Escoja la opción a modificar para el usuario con id: " +id);
            while (true) {
                showModifyMenu();
                try {
                    int option = readInt();
                    switch (option) {
                        case 0:
                            break;
                        case 1:
                            System.out.println("Introduzca el nuevo email de usuario");
                            String newEmail = readString();
                            if (!checkEmail(newEmail)) {
                                System.out.println("Email no válido");
                                return;
                            }
                            users.get(id).setEmail(newEmail);
                            System.out.println("Email actualizado correctamente");
                            break;
                        case 2:
                            System.out.println("Introduzca el nuevo nombre de usuario");
                            String newFirstName = readString();
                            users.get(id).setFirstName(newFirstName);
                            System.out.println("Nombre actualizado correctamente");
                            break;
                        case 3:
                            System.out.println("Introduzca el nuevo apellido de usuario");
                            String newLastName = readString();
                            users.get(id).setLastName(newLastName);
                            System.out.println("Apellido actualizado correctamente");
                            break;
                        case 4:
                            System.out.println("Introduzca el nuevo avatar de usuario");
                            String newAvatar = readString();
                            users.get(id).setAvatar(newAvatar);
                            System.out.println("Avatar actualizado correctamente");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("La opción debe ser un número entero");
                }
                break;
            }
        } catch (InputMismatchException e) {
            System.out.println("El id debe ser un número entero");
        }
    }

    private static void showModifyMenu() {
        System.out.println("1.Email\n" +
                "2. Nombre\n" +
                "3.Apellido\n" +
                "4.Avatar\n" +
                "0.Salir");
    }

    private static void addUser() {
        System.out.println("Introduzca el id del usuario a añadir");
        try {
            int id = readInt();
            if (users.containsKey(id)) {
                System.out.println("El id: " + id + " ya se encuentra registrado");
                return;
            }
            System.out.println("Introduzca el email del usuario a añadir");
            String email = readString();
            if (!checkEmail(email)) {
                System.out.println("Formato del email incorrecto");
                return;
            }
            System.out.println("Introduzca el nombre del usuario a añadir");
            String firstName = readString();
            if (firstName.isEmpty()) {
                System.out.println("El nombre del usuario no puede estar vacio");
                return;
            }
            System.out.println("Introduzca el apellido del usuario a añadir");
            String lastName = readString();
            if (lastName.isEmpty()) {
                System.out.println("El apellido del usuario no puede estar vacio");
                return;
            }
            System.out.println("Introduzca el avatar del usuario a añadir");
            String avatar = readString();
            if (avatar.isEmpty()) {
                System.out.println("El avatar no puede estar vacío");
                return;
            }

            User user = new User(id, email, firstName, lastName, avatar);
            users.put(id, user);
            System.out.println("Usuario añadido correctamente");

        } catch (InputMismatchException e) {
            System.out.println("El id debe ser un número entero");
        }
    }

    private static void importUsers() {
        System.out.println("Introduzca la ruta del archivo a importar:");
        String path = readString();
        File file = new File(path);
        if (!file.isFile()) {
            System.out.println("Archivo no encontrado");
            return;
        }

            try {
               Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                line = sc.nextLine();
                if (line.equals("]")) {
                    break;
                }
                line = sc.nextLine();
                String[] parts = line.split(": ");
                String trimmedPart = parts[1].substring(0, parts[1].length() - 1);
                try {
                    int id = Integer.parseInt(trimmedPart);
                    if (users.containsKey(id)) {
                        System.out.println("El id: " + id + " ya se encuentra registrado");
                    }
                    line = sc.nextLine();
                    parts = line.split(": \"");
                    trimmedPart = parts[1].substring(0, parts[1].length() - 2);
                    String email = trimmedPart;
                    if (!checkEmail(email)) {
                        System.out.println("Formato de email no válido");
                        return;
                    }
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
                } catch (NumberFormatException e) {
                    System.out.println("El id no es un número entero");
                    return;
                }
            }
        } catch (FileNotFoundException e) {
        System.out.println("Archivo no encontrado");
        }
        System.out.println("Usuarios importados correctamente");
    }

    private static boolean checkEmail(String email) {
        String regexPattern = "^(.+)@(\\S+)$";
        if (!email.matches(regexPattern)) {
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
