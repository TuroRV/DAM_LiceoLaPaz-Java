package com.liceolapaz.des.jarv;

public class Socio {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String email;
    private String fechaNacimiento;
    private int numeroSocio;
    private int numberOfBorrowedBooks = 0;
    private Libro[] borrowedBooks = new Libro[5];

    public Socio(String nombre, String apellido1, String apellido2, String dni, String email, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void addBook(Libro libro) {
        boolean full = true;
        for (int i = 0; i < borrowedBooks.length; i++) {
            if (borrowedBooks[i] == null) {
                borrowedBooks[i] = libro;
                full = false;
                break;
            }
        }
        if (full) {
            System.out.println("Error, no se pueden retirar más de 5 libros");
        }
    }

    public void returnBook(Libro libro) {
        for (int i = 0; i < borrowedBooks.length; i++) {
            if (borrowedBooks[i] == libro) {
                borrowedBooks[i] = null;
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    public int getNumberOfBorrowedBooks() {
        return numberOfBorrowedBooks;
    }

    public void setNumberOfBorrowedBooks(int numberOfBorrowedBooks) {
        this.numberOfBorrowedBooks = numberOfBorrowedBooks;
    }

    public Libro[] getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Libro[] borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
