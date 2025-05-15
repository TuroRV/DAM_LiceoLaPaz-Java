package com.liceolapaz.des.jarv;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static final Pattern RegexpDNI = Pattern.compile("[0-9]{8}[A-Z]");
    public static final Pattern RegexpEmail = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");

    public static void main(String[] args) {

        boolean init = true;
        Socio[] socios = new Socio[1000];
        Libro[] libros = new Libro[5000];

        libros[0] = new Libro("1","El señor de los anillos","Fantasía",1500);
        libros[1] = new Libro("2","La isla del tesoro","Fantasía",600);
        libros[2] = new Libro("3","Marathon Man","Thriller",497);
        libros[3] = new Libro("4","Mistborn","Fantasía",1230);
        libros[4] = new Libro("5","Muerte en el Nilo","Policíaco",950);

        socios[0] = new Socio("Pepe","Piscinas","Pérez","45688876B","pepep@gmail.com","25-12-1976");
        socios[0].setNumeroSocio(134);




        while (init) {
            showMenu();
            int option = readInt();
            switch (option) {
                case 1:
                    if (socios[999] != null) {
                        System.out.println("No se pueden añadir más socios");
                        break;
                    }

                    System.out.println("Introduce el nombre del usuario");
                    String nombre = readString();
                    System.out.println("Introduce el primer apellido del usuario");
                    String apellido1 = readString();
                    System.out.println("Introduce el segundo apellido del usuario");
                    String apellido2 = readString();
                    System.out.println("Introduce el DNI del usuario");
                    String dni = readString();

                    while (!validateDni(dni)) {
                        System.out.println("Introduce un DNI válido");
                        dni = readString();
                    }

                    System.out.println("Introduce el email del usuario");
                    String email = readString();
                    while (!validateEmail(email)) {
                        System.out.println("El email introducido no es válido");
                        email = readString();
                    }

                    System.out.println("Introduce la fecha de nacimiento del usuario");
                    String fechaNacimiento = readString();

                    for (int i = 0; i < socios.length; i++) {
                        if (socios[i] == null) {
                            socios[i] = new Socio(nombre, apellido1, apellido2, dni, email, fechaNacimiento);
                            socios[i].setNumeroSocio(i);
                            break;
                        }
                    }
                    break;
                case 2:
                    if (libros[4999] != null) {
                        System.out.println("No se pueden añadir más libros");
                        break;
                    }

                    System.out.println("Introduce el ISBN del libro:");
                    String ISBN = readString();
                    System.out.println("Introduce el título del libro:");
                    String titulo = readString();
                    System.out.println("Introduce el género del libro:");
                    String genero = readString();
                    System.out.println("Introduce el número de páginas del libro:");
                    int numPaginas = readInt();

                    for (int i = 0; i < libros.length; i++) {
                        if (libros[i] == null) {
                            libros[i] = new Libro(ISBN, titulo, genero, numPaginas);
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Introduce el número de socio:");
                    int numSocio = readInt();
                    System.out.println("Introduce el ISBN del libro:");
                    String ISBN2 = readString();

                    Libro libro = null;
                    Socio socio = null;

                    for (int i = 0; i < libros.length; i++) {
                        if (libros[i] != null) {
                            if (libros[i].getIsbn().equals(ISBN2) ) {
                                libro = libros[i];
                                break;
                                }
                            }
                        }

                    if (libro == null) {
                        System.out.println("Error, ISBN no encontrado o no válido");
                        continue;
                        }

                    for (int i = 0; i < socios.length; i++) {
                        if (socios[i] != null) {
                            if (socios[i].getNumeroSocio() == numSocio) {
                                socio = socios[i];
                                break;
                            }
                        }
                    }

                    if (socio == null) {
                        System.out.println("Error, número de socio no encontrado o no válido");
                        continue;
                    }

                    libro.setSocio(socio);
                    libro.setBorrowed(true);
                    socio.addBook(libro);
                    System.out.println("Libro " + libro.getTitulo() + " retirado por socio " + socio.getNumeroSocio());
                    break;
                case 4:
                    System.out.println("Introduce el número de socio");
                    numSocio = readInt();
                    System.out.println("Introduce el ISBN del libro:");
                    ISBN = readString();

                    Libro libro2 = null;
                    Socio socio2 = null;

                    for (int i = 0; i < socios.length; i++) {
                        if (socios[i] != null) {
                            if (socios[i].getNumeroSocio() == numSocio) {
                                socio2 = socios[i];
                                break;
                            }
                        }
                    }
                    if (socio2 == null) {
                        System.out.println("Error, número de socio no encontrado o no válido");
                    }

                    for (int i = 0; i < libros.length; i++) {
                        if (libros[i] != null) {
                            if (libros[i].getIsbn().equals(ISBN)) {
                                libro2 = libros[i];
                                break;
                            }
                        }
                    }
                    if (libro2 == null) {
                        System.out.println("Error, número de libro no encontrado o no válido");
                    }

                    libro2.setSocio(null);
                    libro2.setBorrowed(false);
                    socio2.returnBook(libro2);
                    System.out.println("Libro " + libro2.getTitulo() + " devuelto correctamente por " + socio2.getNumeroSocio());
                    break;

                case 5:
                    for (int i = 0; i < libros.length; i++) {
                        if (libros[i] != null && libros[i].getBorrowed() == false) {
                            System.out.println("ISBN: " + libros[i].getIsbn() + " Título: " + libros[i].getTitulo() + " Género: " + libros[i].getGenero() + " Número de páginas: " + libros[i].getnPaginas() + "\n");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Los libros no disponibles son: ");
                    for (int i = 0; i < libros.length; i++) {
                        if (libros[i] != null && libros[i].getBorrowed() == true) {
                            System.out.println("ISBN: " + libros[i].getIsbn() + " Título: " + libros[i].getTitulo() + " Género: " + libros[i].getGenero() + " Número de páginas: " + libros[i].getnPaginas() + "\n");
                        }
                    }
                    break;
                case 7:
                    System.out.println("Introduzca el número de socio");
                    numSocio = readInt();

                    Socio socio3 = null;

                    for (int i = 0; i < socios.length; i++) {
                        if (socios[i] != null) {
                            if (socios[i].getNumeroSocio() == numSocio) {
                                socio3 = socios[i];
                                break;
                            }
                        }
                    }
                    if (socio3 == null) {
                        System.out.println("Número de socio no encontrado o no válido");
                        break;
                    }

                    System.out.println("El socio " + socio3.getNumeroSocio() + ", " + socio3.getNombre() + " " + socio3.getApellido1()  + " " + socio3.getApellido2() + " ,tiene alquilados los siguientes libros: " + "\n");

                    for (int i = 0; i < socio3.getBorrowedBooks().length; i++) {
                        if (socio3.getBorrowedBooks()[i] != null) {
                            System.out.println("ISBN: " + socio3.getBorrowedBooks()[i].getIsbn() + " Título: " +  socio3.getBorrowedBooks()[i].getTitulo() + " Género: " + socio3.getBorrowedBooks()[i].getGenero() + " Número de páginas: " + socio3.getBorrowedBooks()[i].getnPaginas() + "\n");
                        }
                    }
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

    private static Date readDate() {
        Scanner sc = new Scanner(System.in);
        return new Date(sc.nextInt());
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
        System.out.println("GESTOR BIBLIOTECA\n" +
                "1. Crear socio\n" +
                "2. Crear libro\n" +
                "3. Llevarse libro\n" +
                "4. Devolver libro\n" +
                "5. Mostrar libros disponibles\n" +
                "6. Mostrar libros no disponibles\n" +
                "7. Mostrar libros de un socio\n" +
                "0. Salir\n" +
                "Escoja una opción:");
    }

    public static boolean validateDni(String dni) {
    return RegexpDNI.matcher(dni).matches();
    }

    public static boolean validateEmail(String email) {
        return RegexpEmail.matcher(email).matches();
    }

}
