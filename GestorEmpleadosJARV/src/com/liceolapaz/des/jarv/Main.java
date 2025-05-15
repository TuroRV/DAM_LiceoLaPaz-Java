package com.liceolapaz.des.jarv;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static HashMap<String,Empleado> empleados = new HashMap<>();

    public static void main(String[] args) {
        do {
            escribirMenu();
            int opcion;
            try {
                opcion = leerOpcion(); }
            catch (InputMismatchException e) {
                System.out.println("La opción debe ser un número entero");
                continue;
            }
                switch (opcion) {
                    case 0:
                        System.out.println("Cerrando aplicación");
                        System.exit(0);
                        break;
                    case 1:
                        importarEmpleados();
                        break;
                    case 2:
                        agregarEmpleado();
                        break;
                    case 3:
                        modificarEmpleado();
                        break;
                    case 4:
                        eliminarEmpleado();
                        break;
                    case 5:
                        exportarEmpleados();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            
        } while (true);
    }

    private static void exportarEmpleados() {
        System.out.println("Escriba la ruta completa del fichero a exportar: ");
        String ruta = leerTexto();
        try {
            FileWriter fw = new FileWriter(ruta);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            LocalDateTime fechaActual = LocalDateTime.now();
            String linea;
            linea = "Fecha: " + fechaActual.getDayOfMonth() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
            pw.println(linea);
            linea = "Hora" + fechaActual.getHour() + ":" + fechaActual.getMinute() + ":" + fechaActual.getSecond();
            pw.println(linea);
            linea = "Número de empleados: " + empleados.size();
            pw.println(linea);
            int contador = 1;
            for (Empleado empleado : empleados.values()) {
                linea =  "=================";
                pw.println(linea);
                linea = "Empleados: " + contador;
                pw.println(linea);
                linea =  "=================";
                pw.println(linea);
                linea = empleado.toString();
                pw.println(linea);
                contador++;
            }
            pw.close();
            fw.close();
            bw.close();
            System.out.println("Empleados exportados correctamente en: " + ruta);

        } catch (IOException e) {
            System.out.println("Error al escribir el fichero");
        }

    }

    private static void eliminarEmpleado() {
        System.out.println("Escriba el DNI del empleado: ");
        String dni = leerTexto();
        if (!comprobarDni(dni)) {
            System.out.println("El formato del DNI es incorrecto.");
            return;
        }
        if (!empleados.containsKey(dni)) {
            System.out.println("El empleado no existe");
            return;
        }
        empleados.remove(dni);
    }

    private static void modificarEmpleado() {
        System.out.println("Escriba el DNI del empleado: ");
        String dni = leerTexto();
        if (!comprobarDni(dni)) {
            System.out.println("El formato del DNI es incorrecto.");
            return;
        }
        if (!empleados.containsKey(dni)) {
            System.out.println("El empleado no existe");
            return;
        }
        System.out.println("Escriba el nombre del empleado: ");
        String nombre = leerTexto();
        System.out.println("Escriba el primer apellido del empleado");
        String apellido = leerTexto();
        System.out.println("Escriba el segundo apellido del empleado");
        String apellido2 = leerTexto();
        if (apellido2.isEmpty()) {
            apellido = null;
        }

        System.out.println("Escriba la fecha de nacimiento en formato yyyy/mm/dd");
        String fechaTexto = leerTexto();
        Date fechaNacimiento = comprobarFecha(fechaTexto);
        if (fechaNacimiento == null) {
            return;
        }
        System.out.println("Escriba el salario: ");
        String salarioTexto = leerTexto();
        double salario;
        try {
            salario = Double.parseDouble(salarioTexto);
        }
        catch (NumberFormatException e) {
            System.out.println("Formato de salario incorrecto");
            return;
        }
        System.out.println("Escriba el departamento:");
        String departamentoTexto = leerTexto();
        int departamento;
        try {
            departamento = Integer.parseInt(departamentoTexto);
        } catch (NumberFormatException e) {
            System.out.println("Formato de departamento incorrecto");
            return;
        }
        System.out.println("Escriba el DNI del jefe");
        String dniJefe = leerTexto();
        if (dniJefe.isEmpty()) {
            dniJefe = null;
        } else {
            if (!comprobarDni(dniJefe)) {
                System.out.println("Formato de DNI incorrecto");
                return;
            }
        }
        Empleado empleado = new Empleado(dni,nombre,apellido,apellido2,fechaNacimiento,salario,departamento,dniJefe);
        empleados.replace(dni,empleado);
        System.out.println("Empleado modificado correctamente. ");
    }

    private static void agregarEmpleado() {
        System.out.println("Escriba el DNI del empleado: ");
        String dni = leerTexto();
        if (!comprobarDni(dni)) {
            System.out.println("El formato del DNI es incorrecto.");
            return;
        }
        if (empleados.containsKey(dni)) {
            System.out.println("El empleado ya existe");
            return;
        }
        System.out.println("Escriba el nombre del empleado: ");
        String nombre = leerTexto();
        System.out.println("Escriba el primer apellido del empleado");
        String apellido = leerTexto();
        System.out.println("Escriba el segundo apellido del empleado");
        String apellido2 = leerTexto();
        if (apellido2.isEmpty()) {
            apellido = null;
        }

        System.out.println("Escriba la fecha de nacimiento en formato yyyy/mm/dd");
        String fechaTexto = leerTexto();
        Date fechaNacimiento = comprobarFecha(fechaTexto);
        if (fechaNacimiento == null) {
            return;
        }
        System.out.println("Escriba el salario: ");
        String salarioTexto = leerTexto();
        double salario;
        try {
            salario = Double.parseDouble(salarioTexto);
        }
        catch (NumberFormatException e) {
            System.out.println("Formato de salario incorrecto");
            return;
        }
        System.out.println("Escriba el departamento:");
        String departamentoTexto = leerTexto();
        int departamento;
        try {
            departamento = Integer.parseInt(departamentoTexto);
        } catch (NumberFormatException e) {
            System.out.println("Formato de departamento incorrecto");
            return;
        }
        System.out.println("Escriba el DNI del jefe");
        String dniJefe = leerTexto();
        if (dniJefe.isEmpty()) {
            dniJefe = null;
        } else {
            if (!comprobarDni(dniJefe)) {
            System.out.println("Formato de DNI incorrecto");
            return;
        }
        }
        Empleado empleado = new Empleado(dni,nombre,apellido,apellido2,fechaNacimiento,salario,departamento,dniJefe);
        empleados.put(dni,empleado);
        System.out.println("Empleado añadido correctamente. ");
        }


    private static void importarEmpleados() {
        System.out.println("Escriba la ruta completa del fichero de empleados: ");
        String ruta = leerTexto();
        File fichero = new File(ruta);
        if (!fichero.isFile()) {
            System.out.println("La ruta " + ruta + " no es un fichero.");
            return;
        }
        try {
            Scanner scanner = new Scanner(fichero);
            HashMap<String, Empleado> empleadosFichero = new HashMap<>();
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            } while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(", ");
                if (partes.length != 8) {
                    System.out.println("Formato de datos incorrectos");
                    return;
                }
                String dni = partes[0].substring(2,partes[0].length()-1);
                if (!comprobarDni(dni)) {
                    return;
                }
                String nombre = partes[1].substring(1, partes[1].length()-1);
                String apellido1 = partes[2].substring(1, partes[2].length()-1);
                String apellido2;
                if (partes[3].equals("NULL")) {
                    apellido2 = null;
                } else {apellido2 = partes[3].substring(1, partes[3].length()-1);
                }
                String fechaTexto = partes[4].substring(1, partes[4].length()-1);
                Date fechaNacimiento = comprobarFecha(fechaTexto);
                if (fechaNacimiento == null) {
                    return;
                }
                String salarioTexto = partes[5].substring(1, partes[5].length()-1);
                double salario;
                try {
                    salario = Double.parseDouble(salarioTexto);
                }
                catch (NumberFormatException e) {
                    System.out.println("Formato de salario incorrecto");
                    return;
                }
                String departamentoTexto = partes[6];
                int departamento;
                try {
                    departamento = Integer.parseInt(departamentoTexto);
                } catch (NumberFormatException e) {
                    System.out.println("Formato de departamento incorrecto");
                    return;
                }
                String dniJefe;
                if (partes[7].equals("NULL)")) {
                    dniJefe = null;
                }
                else {
                    dniJefe = partes[7].substring(1, partes[7].length()-2);
                    if (!comprobarDni(dniJefe)) {
                        return;
                    }
                }
                Empleado empleado = new Empleado(dni,nombre,apellido1,apellido2,fechaNacimiento,salario,departamento,dniJefe);
                empleadosFichero.put(dni,empleado);
            }
            empleados.putAll(empleadosFichero);
            System.out.println("Empleados importados correctamente.");

        } catch (FileNotFoundException e) {
            System.out.println("La ruta " + ruta + " no es un fichero.");
        }
    }

    private static Date comprobarFecha(String fechaTexto) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
        sdf.setLenient(false);
        try {
            return sdf.parse(fechaTexto);
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto");
            return null;
        }
    }

    private static boolean comprobarDni(String dni) {
        if (dni.length() != 9) {
            System.out.println("Formato de DNI incorrecto. Ej: 12345678A");
            return false;
        }
        String parteNumerica = dni.substring(0,8);
        try {
            Integer numero = Integer.parseInt(parteNumerica);
            Character letra = dni.charAt(8);
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            char letracorrecta = letras.charAt(numero%letras.length());
            if (letracorrecta != letra) {
                System.out.println("Formato de DNI incorrecto. La letra no corresponde con los dígitos");
            }
        } catch (NumberFormatException e) {
            System.out.println("Formato de DNI incorrecto. Ej: 12345678A");
            return false;
        }

        return true;
    }

    private static String leerTexto() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static int leerOpcion() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void escribirMenu() {
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
