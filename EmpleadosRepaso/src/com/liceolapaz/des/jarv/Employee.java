package com.liceolapaz.des.jarv;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    String dni;
    String name;
    String surname1;
    String surname2;
    Date birthDate;
    double salary;
    int departmentNumber;
    String bossDni;

    public Employee(String dni, String name, String surname1, String surname2, Date birthDate, double salary, int departmentNumber, String bossDni) {
        this.dni = dni;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.birthDate = birthDate;
        this.salary = salary;
        this.departmentNumber = departmentNumber;
        this.bossDni = bossDni;
    }

    @Override
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
        String formattedBirthDate = sdf.format(birthDate);
        String texto = "";
        texto += "('"+this.dni+"', '";
        texto += this.name+"', '";
        texto += this.surname1+"', ";
        if (this.surname2 == null ) {
            texto += "NULL, '";
        } else if (this.surname2.isEmpty()) {
            texto += "NULL, '";
        } else {
            texto += "'"+this.surname2+"', '";
        }
        texto += formattedBirthDate + "', '";
        texto += salary +"', ";
        texto += departmentNumber + ", ";
        if (this.bossDni == null) {
            texto += "NULL)";
        } else if (this.bossDni.isEmpty()) {
            texto += "NULL)";
        }
        else {
            texto += bossDni+"')";
        }
return texto;
    }
}
