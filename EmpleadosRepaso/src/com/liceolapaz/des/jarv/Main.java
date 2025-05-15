package com.liceolapaz.des.jarv;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static HashMap<String, Employee> employeesList = new HashMap<>();
    public static void main(String[] args) {

        do {
            writeMenu();
            int option;
            try {
                option = readInt();
            } catch (InputMismatchException e) {
                System.out.println("La opción debe ser un número entero");
                continue;
            }
            switch (option) {
                case 0:
                    System.out.println("Cerrando aplicación");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Introduzca la ruta del fichero para importar los empleados:");
                    String path = readString();
                    importEmployees(path);
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    modifyEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Introduzca la ruta para exportar los empleados:");
                    String destinationPath = readString();
                    exportEmployees(destinationPath);
                    break;
            }
        }
        while(true);
    }

    private static void exportEmployees(String destinationPath) {
        File file = new File(destinationPath);
        if (file.exists()) {
            System.out.println("El archivo ya existe");
        } else {
            try {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println("(DNI, Nombre, Primer_Apellido, Segundo_Apellido, Fecha_Nacimiento, Salario, Departamento, DNI_Jefe)");
                for (Employee empleado: employeesList.values()) {
                    pw.println(empleado.toString());
                }
                pw.close();
            } catch (IOException e) {
                System.out.println("Error escribiendo fichero");
            }
        }
    }

    private static void deleteEmployee() {
        System.out.println("Introduzca el DNI del empleado que desea eliminar: ");
        String dni = readString();
        if (!employeesList.containsKey(dni)) {
            System.out.println("El empleado no existe");
        }
        else {
            System.out.println("Está seguro que desea eliminar al empleado " + employeesList.get(dni).name + " " + employeesList.get(dni).surname1 + " " + employeesList.get(dni).surname2 + "? S/N");
            String option = readString();
            while (!option.equals("S") && !option.equals("N") && !option.equals("s") && !option.equals("n")) {
                System.out.println("Introduzca S o N para seleccionar su opción");
                option = readString();
            }
            if (option.equals("S") | option.equals("s")) {
                employeesList.remove(dni);
                System.out.println("Empleado eliminado correctamente");
            } else if (option.equals("N") | option.equals("n")) {
                System.out.println("Operación cancelada");
            }
        }
    }

    private static void modifyEmployee() {
        System.out.println("Introduzca el dni del empleado que desea modificar:");
        String dni = readString();
        if (!employeesList.containsKey(dni)) {
            System.out.println("El empleado no existe");
        }
        else {
            System.out.println("¿Qué desea modificar del empleado" + dni +"?\n" +
                    "1. Nombre\n" +
                    "2. Apellido 1\n" +
                    "3. Apellido 2\n" +
                    "4. Fecha de nacimiento\n" +
                    "5. Salario\n" +
                    "6. Número de departamento\n" +
                    "7. DNI de jefe"
                    );
            int option = readInt();
            switch (option) {
                case 1:
                    System.out.println("Introduzca el nuevo nombre");
                    String newName = readString();
                    employeesList.get(dni).name = newName;
                    System.out.println("Nombre actualizaco correctamente");
                    break;
                case 2:
                    System.out.println("Introduzca el nuevo primer apellido");
                    String newSurname1 = readString();
                    employeesList.get(dni).surname1 = newSurname1;
                    System.out.println("Apellido actualizaco correctamente");
                    break;
                case 3:
                    System.out.println("Introduzca el nuevo segundo apellido");
                    String newSurname2 = readString();
                    employeesList.get(dni).surname2 = newSurname2;
                    System.out.println("Apellido actualizado correctamente");
                    break;
                case 4:
                    System.out.println("Introduzca el nuevo año de la fecha de nacimeinto");
                    int newYear = readInt();
                    System.out.println("Introduzca el nuevo mes de la fecha de nacimiento");
                    int newMonth = readInt();
                    System.out.println("Introduzca el nuevo día de la fecha de nacimiento");
                    int newDay = readInt();
                    Date newDate = new Date(newYear, newMonth, newDay);
                    employeesList.get(dni).birthDate = newDate;
                    System.out.println("Fecha de nacimiento actualizada correctamente");
                    break;
                case 5:
                    System.out.println("Introduzca el nuevo salario");
                    double newSalary = readDouble();
                    employeesList.get(dni).salary = newSalary;
                    System.out.println("Salario actualizado correctamente");
                    break;
                case 6:
                    System.out.println("Introduzca el nuevo numero de departamento");
                    int newDepNumber = readInt();
                    employeesList.get(dni).departmentNumber = newDepNumber;
                    System.out.println("Numero de departamento actualizado correctamente");
                    break;
                case 7:
                    System.out.println("Introduzca el nuevo DNI de jefe");
                    String newBossDni = readString();
                    if (newBossDni.isEmpty()) {
                        newBossDni = null;
                        employeesList.get(dni).bossDni = newBossDni;
                        System.out.println("Dni de jefe actualizado correctamente");
                    } else {
                        if (!checkDni(newBossDni)) {
                            System.out.println("Error en el formato del DNI");
                            break;
                        }
                        employeesList.get(dni).bossDni = newBossDni;
                        System.out.println("Dni de jefe actualizado correctamente");
                        break;
                    }
            }
        }
    }

    private static void addEmployee() {
        System.out.println("Introduzca el DNI del empleado:");
        String dni = readString();
        if (!checkDni(dni)) {
            System.out.println("Error en el formato del DNI " + dni);
        } else {
            System.out.println("Introduzca el nombre del empleado:");
            String name = readString();
            if (name.isEmpty()) {
                System.out.println("El campo no puede estar vacío");
                return;
            }
            System.out.println("Introduzca el primer apellido del empleado:");
            String surname1 = readString();
            if (surname1.isEmpty()) {
                System.out.println("El campo no puede estar vacío");
                return;
            }
            System.out.println("Introduzca el segundo apellido del empleado:");
            String surname2 = readString();
            if (surname2.isEmpty()) {
                surname2 = null;
            }
            System.out.println("Introduzca la fecha de nacimiento del empleado en formato: AAAA/M/D");
            String date = readString();
            Date birthdate = checkDate(date);
            System.out.println("Introduzca el salario del empleado:");
            double salary = 0;
            try {
                salary = readDouble();
            } catch (InputMismatchException e) {
                System.out.println("El salario debe ser un valor numérico");
            }
            System.out.println("Introduzca el número de departamento del empleado:");
            int depNumber = 0;
            try {
                depNumber = readInt();
            } catch (InputMismatchException e) {
                System.out.println("Introduce un número entero");
            }
            System.out.println("Introduzca el DNI del jefe del empleado:");
            String bossDni = readString();
            if (bossDni.isEmpty()) {
                bossDni = null;

                Employee employee = new Employee(dni, name, surname1, surname2, birthdate, salary, depNumber, bossDni);
                employeesList.put(dni, employee);
                System.out.println("Empleado añadido correctamente.");

            }
            else {
                if (!checkDni(bossDni)) {
                    System.out.println("Error en el formato del DNI " + bossDni);
                    return;
                }

                Employee employee = new Employee(dni, name, surname1, surname2, birthdate, salary, depNumber, bossDni);
                employeesList.put(dni, employee);
                System.out.println("Empleado añadido correctamente.");

        }
    }
    }

    private static double readDouble() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    private static void importEmployees(String path) {
        File file = new File(path);
        HashMap<String, Employee> employeestemp = new HashMap<>();
        if (!file.isFile()) {
            System.out.println("El archivo no existe o la ruta es incorrecta");
        }
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            br.readLine();
            String[] nEmployeesArray = br.readLine().split(": ");
            int nEmployees = Integer.parseInt(nEmployeesArray[1]);

            for (int i = 0; i < nEmployees; i++) {
                br.readLine();
                br.readLine();
                br.readLine();

                String dni = br.readLine();
                String[] parts = dni.split(": ");
                dni = parts[1];
                if (!checkDni(dni)) {
                    System.out.println("El formato del DNI es incorrecto");
                    return;
                }
                String name = br.readLine();
                String[] parts1 = name.split(": ");
                name = parts1[1];
                String surname1 = br.readLine();
                String[] parts2 = surname1.split(": ");
                surname1 = parts2[1];
                String surname2 = br.readLine();
                String[] parts3 = surname2.split(": ");
                surname2 = parts3[1];
                if (surname2.equals("null")) {surname2 = null;}
                String date = br.readLine();
                String[] parts4 = date.split(": ");
                date = parts4[1];
                Date birthDate = checkDate(date);
                if (birthDate == null) {
                    System.out.println("Error en el formato de la fecha");
                    return;
                }
                String salary = br.readLine();
                String[] salaryparts = salary.split(": ");
                salary = salaryparts[1];
                String depNumber = br.readLine();
                String[] depNumberparts = depNumber.split(": ");
                depNumber = depNumberparts[1];
                String bossDni = br.readLine();
                String[] bossDniparts = bossDni.split(": ");
                bossDni = bossDniparts[1];
                if (bossDni.equals("null")) {
                    bossDni = null;} else {
                if (!checkDni(bossDni)) {
                    System.out.println("Formato de DNI de jefe incorrecto");
                    return;
                }
            }

                Employee employee = new Employee(dni, name, surname1, surname2, birthDate, Double.parseDouble(salary), Integer.parseInt(depNumber), bossDni);
                employeestemp.put(dni, employee);
            }

            employeesList.putAll(employeestemp);
            System.out.println("Empleados importados correctamente");

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado o ruta incorrecta");
        } catch (IOException e) {
            System.out.println("Error leyendo fichero");
        }

    }

    private static Date checkDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/M/d");
        simpleDateFormat.setLenient(false);
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            System.out.println("Error en el formato de fecha");
        }
        return null;
    }

    private static boolean checkDni(String dni) {
        if (dni.length() != 9) {
            System.out.println("Longitud del DNI incorrecta");
            return false;
        }
        String dniNumbers = dni.substring(0,8);
        Integer numbers = Integer.parseInt(dniNumbers);
        Character letter = dni.charAt(8);
        String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
        char correctLetter = letters.charAt(numbers%letters.length());

            if (correctLetter!=letter) {
                System.out.println(
                        "Formato de DNI incorrecto");
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

    private static void writeMenu() {
        System.out.println("GESTOR EMPLEADOS\n" +
                "1. Importar empleados\n" +
                "2. Añadir empleado\n" +
                "3. Modificar empleado\n" +
                "4. Eliminar empleado\n" +
                "5. Exportar empleados\n" +
                "0. Salir\n" +
                "Escoja una opción:");
    }
}
