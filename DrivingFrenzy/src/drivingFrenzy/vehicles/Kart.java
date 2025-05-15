package drivingFrenzy.vehicles;

import drivingFrenzy.race.Section;

import java.util.Random;

public class Kart implements Vehicle {

    private int number;
    private String driver;
    private int currentSpeed;
    private int maxSpeed;
    private String description;
    private int gears[] = new int[2];
    private int actualGear = 1;
    private int speedRange;
    private boolean disqualified = false;


    public Kart(String description, int maxSpeed, int currentSpeed, String driver, int number) {
        this.description = description;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = currentSpeed;
        this.driver = driver;
        this.number = number;
        this.speedRange = maxSpeed / gears.length;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String getDriver() {
        return driver;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getCurrentSpeed() {
        return currentSpeed;
    }

    @Override
    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public boolean getDisqualified() {
        return disqualified;
    }

    @Override
    public String adaptSpeed(Section nextSection) {
        String result = "";

        if (actualGear == 1 && nextSection.getTheoreticalMaxSpeed() > currentSpeed && nextSection.getTheoreticalMaxSpeed() > speedRange+1) {
            actualGear = 2;
            int newSpeed = speedRange+1;
            result += "El número " + number + " sube a la marcha " + actualGear + " y acelera desde " + currentSpeed + " a " + newSpeed + ". ";
            currentSpeed = newSpeed;}

        else if (actualGear == 2 && nextSection.getTheoreticalMaxSpeed() > currentSpeed && nextSection.getTheoreticalMaxSpeed() > maxSpeed) {
            int newSpeed = maxSpeed;
            result += "El número " + number + " acelera desde " + currentSpeed + " a " + newSpeed + ". ";
            currentSpeed = newSpeed;
        }
        else if (actualGear == 2 && currentSpeed == maxSpeed) {
            result += driver + " aprieta a fondo, pero su  " + description + " está al límite!";
        }
        else if (nextSection.getTheoreticalMaxSpeed() <= speedRange) {
            actualGear = 1;
            Random rd = new Random();
            int newSpeed = rd.nextInt(1,speedRange);
            result += "El número " + number + " baja a la marcha " + actualGear + " y frena desde " + currentSpeed + " a " + newSpeed + ".";
            currentSpeed = newSpeed;
        }
        else {
        currentSpeed = nextSection.getTheoreticalMaxSpeed();
            result += "El número " + number + " reduce la velocidad a " + currentSpeed;
        }

        return result;
    }

    public boolean setDisqualified(boolean disqualified) {
        this.disqualified = disqualified;
        return disqualified;
    }
}
