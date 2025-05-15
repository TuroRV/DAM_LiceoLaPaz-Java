package com.liceolapaz.des.jarv;

public class Department {
private int depNumber;
private String depName;
private String depShortName;
private int depFloor;
private String directorCif;
private String email;

    public Department(int depNumber, String depName, String depShortName, int depFloor, String directorCif, String email) {
        this.depNumber = depNumber;
        this.depName = depName;
        this.depShortName = depShortName;
        this.depFloor = depFloor;
        this.directorCif = directorCif;
        this.email = email;
    }

    @Override
    public String toString() {
        return depNumber + ";" + depName + ";" + depShortName + ";" + depFloor + ";" + directorCif + ";" + email;
    }
}
