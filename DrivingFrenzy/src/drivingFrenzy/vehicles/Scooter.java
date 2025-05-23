package drivingFrenzy.vehicles;

import drivingFrenzy.race.Section;

public class Scooter implements Vehicle {

	private int number;
	private String driver;
	private int currentSpeed;
	private int maxSpeed;
	private String description;
	private boolean disqualified = false;
	
	public Scooter(int number, String driver, int currentSpeed, int maxSpeed, String description) {
		super();
		this.number = number;
		this.driver = driver;
		this.currentSpeed = currentSpeed;
		this.maxSpeed = maxSpeed;
		this.description = description;
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
	public boolean setDisqualified(boolean disqualified) {
		this.disqualified = disqualified;
		return disqualified;
	}

	@Override
	public String adaptSpeed(Section nextSection) {
		String result = "";
		if (nextSection.getTheoreticalMaxSpeed() > currentSpeed) {
			int nextSpeed =  Math.min(maxSpeed, nextSection.getTheoreticalMaxSpeed());
			result += "El número " + number + " acelera desde " + currentSpeed + " a " + nextSpeed + ". ";
			currentSpeed = nextSpeed;
			if (maxSpeed == currentSpeed) {
				result += driver + " aprieta a fondo, pero su " + description + " está al límite!";
			}
		} else {
			currentSpeed = nextSection.getTheoreticalMaxSpeed();
			result += "El número " + number + " reduce la velocidad a " + currentSpeed;
		}
		return result;
	}

}
