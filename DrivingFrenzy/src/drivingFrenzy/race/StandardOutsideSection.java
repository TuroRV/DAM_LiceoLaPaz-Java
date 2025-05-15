package drivingFrenzy.race;

public class StandardOutsideSection implements Section {

    private int length;
    private int theoreticalMaxSpeed;
    private double speedMultiplier;
    private int actualMaxSpeed;
    private String description;

    public StandardOutsideSection(int length, int theoreticalMaxSpeed,
                                  double speedMultiplier, String description) {
        this.length = length;
        this.theoreticalMaxSpeed = theoreticalMaxSpeed;
        this.speedMultiplier = speedMultiplier;
        double finalSpeed = theoreticalMaxSpeed * speedMultiplier;
        this.actualMaxSpeed = (int) finalSpeed;
        this.description = description;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getTheoreticalMaxSpeed() {
        return theoreticalMaxSpeed;
    }

    @Override
    public int getActualMaxSpeed() {
        return actualMaxSpeed;
    }
}
