package com.liceolapaz.des.jarv;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Empleado {
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechaNacimiento;
    private double salario;
    private int departamento;
    private String dniJefe;

    public Empleado(String dni, String nombre, String apellido1, String apellido2, Date fechaNacimiento, double salario, int departamento, String dniJefe) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
        this.departamento = departamento;
        this.dniJefe = dniJefe;
    }

    @Override
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
        String fechaNac = sdf.format(fechaNacimiento);

        return "DNI: " + this.dni + "\n"
                + "Nombre: " + this.nombre + "\n"
                + "Primer apellido: " + this.apellido1 + "\n"
                + "Segundo apellido: " + this.apellido2 + "\n"
                + "Fecha de Nacimiento: " + fechaNac + "\n"
                + "Salario: " + this.salario + "\n"
                + "Número de departamento: " + this.departamento + "\n"
                + "DNI Jefe: " + this.dniJefe + "\n";

    }
}
