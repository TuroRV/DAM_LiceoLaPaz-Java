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

    public int getDepNumber() {
        return depNumber;
    }

    public void setDepNumber(int depNumber) {
        this.depNumber = depNumber;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepShortName() {
        return depShortName;
    }

    public void setDepShortName(String depShortName) {
        this.depShortName = depShortName;
    }

    public int getDepFloor() {
        return depFloor;
    }

    public void setDepFloor(int depFloor) {
        this.depFloor = depFloor;
    }

    public String getDirectorCif() {
        return directorCif;
    }

    public void setDirectorCif(String directorCif) {
        this.directorCif = directorCif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return depNumber + ";" + depName + ";" + depShortName + ";" + depFloor + ";" + directorCif + ";" + email;
    }
}
