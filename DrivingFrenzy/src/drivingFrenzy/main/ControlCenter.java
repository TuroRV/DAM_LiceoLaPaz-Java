package drivingFrenzy.main;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import drivingFrenzy.race.Section;
import drivingFrenzy.race.StandardIndoorSection;
import drivingFrenzy.race.StandardOutsideSection;
import drivingFrenzy.race.Track;
import drivingFrenzy.vehicles.Kart;
import drivingFrenzy.vehicles.Scooter;
import drivingFrenzy.vehicles.Vehicle;

/**
 * @author ismael This is the Control Center. It is the entry point of the
 *         application, where the races are created, vehicles are added...
 */
public class ControlCenter {

	private final static String USAGE = "El programa genera un n�mero aleatorio de veh�culos y secciones de pista y realiza la carrera. \n"
			+ "El programa autom�ticamente para tras imprimir una l�nea, esperando a que el usuario pulse enter para continuar.";

	/**
	 * @param minSections
	 * @param maxSections
	 * @param minVehicles
	 * @param maxVehicles
	 * @param minVehicleSpeed
	 * @param maxVehicleSpeed
	 * @param minSectionLenght
	 * @param maxSectionLength
	 * @param minSectionSpeed
	 * @param maxSectionSpeed
	 * @throws IOException
	 *
	 *
	 * This method creates simple race with StandarIndoorSection sections
	 * and Scooters, with initial random stats
	 */

	private static void simpleRandomRace(int minSections, int maxSections, int minVehicles, int maxVehicles,
			int minVehicleSpeed, int maxVehicleSpeed, int minSectionLenght, int maxSectionLength, int minSectionSpeed,
			int maxSectionSpeed) throws IOException {
		// We will need a variable to return random numbers to generate the initial
		// conditions.
		Random random = new Random();

		// first, we randomly decide on the race conditions.

		int numberOfSections = random.nextInt(minSections, maxSections+1);
		int numberOfVehicles = random.nextInt(minVehicles, maxVehicles+1);

		// next, we create the track.
		Section[] sections = new Section[numberOfSections];

		for (int i = 0; i < numberOfSections; i++) {
			sections[i] = new StandardIndoorSection(random.nextInt(minSectionLenght, maxSectionLength+1),
					"una recta sencilla", random.nextInt(minSectionSpeed, maxSectionSpeed+1));
		}

		Track track = new Track(sections);

		// Next, we create some vehicles
		Vehicle[] vehicles = new Vehicle[numberOfVehicles];
		
		for (int i = 0; i < numberOfVehicles; i++) {
			vehicles[i] = new Scooter(i, "un conductor an�nimo", 0, random.nextInt(minVehicleSpeed, maxVehicleSpeed),
					"scooter");
		}
		
		start(track, vehicles);
	}

	//método defaultRace
	private static void defaultRace(int minSections, int maxSections, int minVehicles, int maxVehicles,
									int minVehicleSpeed, int maxVehicleSpeed, int minSectionLenght,
									int maxSectionLength, int minSectionSpeed, int maxSectionSpeed) throws IOException {

		Section[] sections = new Section[5];
		sections[0] = new StandardIndoorSection(1000,"una recta sencilla",110);
		sections[1] = new StandardIndoorSection(2000,"una recta sencilla",70);
		sections[2] = new StandardIndoorSection(3000,"una recta sencilla",200);
		sections[3] = new StandardIndoorSection(2000,"una recta sencilla",180);
		sections[4] = new StandardIndoorSection(1000,"una recta sencilla",50);

		Track defaultTrack = new Track(sections);

		Vehicle[] vehicles = new Vehicle[3];

		vehicles[0] = new Scooter(33,"Pepiño",20,130,"Conductor temerario");
		vehicles[1]  = new Scooter(34,"Juan",30,120,"Derrapes extremos");
		vehicles[2]  = new Scooter(23,"Gila",70,140,"Pedal a fondo");

		start(defaultTrack,vehicles);
	}

	private static void defaultKartRace (int minSections, int maxSections, int minVehicles, int maxVehicles,
										 int minVehicleSpeed, int maxVehicleSpeed, int minSectionLenght,
										 int maxSectionLength, int minSectionSpeed, int maxSectionSpeed) throws IOException {
		Section[] sections = new Section[5];
		sections[0] = new StandardIndoorSection(1000,"una recta sencilla",110);
		sections[1] = new StandardIndoorSection(2000,"una recta sencilla",70);
		sections[2] = new StandardIndoorSection(3000,"una recta sencilla",200);
		sections[3] = new StandardIndoorSection(2000,"una recta sencilla",180);
		sections[4] = new StandardIndoorSection(1000,"una recta sencilla",50);

		Track track = new Track(sections);
		Vehicle[] vehicles = new Vehicle[3];


		vehicles[0] = new Kart("Motor V12",110,20,"Arturo",77);
		vehicles[1] = new Kart("Motor V8",130,20,"Juan",12);
		vehicles[2] = new Kart("Motor Turbo",15,20,"Gila",8);

		start(track,vehicles);
	}

	private static void randomKartRace (int minSections, int maxSections, int minVehicles, int maxVehicles,
										int minVehicleSpeed, int maxVehicleSpeed, int minSectionLenght,
										int maxSectionLength, int minSectionSpeed, int maxSectionSpeed) throws IOException {
		Random rc = new Random();

		int numberOfSections = rc.nextInt(minSections, maxSections+1);
		int numberOfVehicles = rc.nextInt(minVehicles, maxVehicles+1);

		Section[] sections = new Section[numberOfSections];

		for (int i = 0; i < numberOfSections; i++) {
			sections[i] = new StandardIndoorSection(rc.nextInt(minSectionLenght,maxSectionLength+1),
											"Una recta sencilla",rc.nextInt(minSectionSpeed,maxSectionSpeed+1));
		}

		Track track = new Track(sections);

		Vehicle[] vehicles = new Vehicle[numberOfVehicles];
		String[] models = {"MK2000","Aprilia 200X","Extreme 105","Terminator Max Power","Renault 5 Copa Turbo","MuebleV","Saxo reventado","MegaKart250cc","MagicKarting 2000"};
		String[] drivers = {"Pepito Piscinas","Manolo el del Bombo","M. Rajoy","The Stig","Un jubilado aburrido","Bori","Un empresario peligroso","Ramón el Vanidoso","El serpiente","Baby Driver","Tony Montana","Rápido de Bouzas","Pistón","El canijo","El zanahorio","El panadero con prisas","Hombre topo Hans","Michael Scott","Dwight Schrute"};

		for (int i = 0; i < numberOfVehicles; i++) {
			vehicles[i] = new Kart(models[rc.nextInt(0,models.length)],rc.nextInt(minVehicleSpeed,maxVehicleSpeed+1),
								    0,drivers[rc.nextInt(0, drivers.length)],i );
		}
		start(track,vehicles);
	}

	/*Este método es una carrera entre scooters y karts en pistas standardoutsidesections a la que le afecta el clima*/

	public static void randomScooterKartRace (int minSections,int maxSections,int minVehicles,int maxVehicles,
											  int minVehicleSpeed,int maxVehicleSpeed,int minSectionLength,
											  int maxSectionLength, int minSectionSpeed, int maxSectionSpeed) throws IOException {
		Random rc = new Random();

		int numberOfSections = rc.nextInt(minSections, maxSections+1);
		int numberOfVehicles = rc.nextInt(minVehicles, maxVehicles+1);

		Section[] sections = new Section[numberOfSections];

		double[] multipliers = {0.8,0.9};
		String[] weather = {"La lluvia arrecia!","Hay una ligera lluvia","Hace un día nublado","El clima es ideal!"};

		for (int i = 0; i < numberOfSections; i++) {
			sections[i] = new StandardOutsideSection(rc.nextInt(minSectionLength,maxSectionLength),
													rc.nextInt(minSectionSpeed,maxSectionSpeed),multipliers[rc.nextInt(multipliers.length)],
											weather[rc.nextInt(0,weather.length)]);
		}

		Track track = new Track(sections);

		Vehicle[] vehicles = new Vehicle[numberOfVehicles];
		String[] models = {"MK2000","Aprilia 200X","Extreme 105","Terminator Max Power","Renault 5 Copa Turbo","MuebleV","Saxo reventado","MegaKart250cc","MagicKarting 2000"};
		String[] drivers = {"Pepito Piscinas","Manolo el del Bombo","M. Rajoy","The Stig","Un jubilado aburrido","Bori","Un empresario peligroso","Ramón el Vanidoso","El serpiente","Baby Driver","Tony Montana","Rápido de Bouzas","Pistón","El canijo","El zanahorio","El panadero con prisas","Hombre topo Hans","Michael Scott","Dwight Schrute"};

		for(int i =0;i<numberOfVehicles/2;i++){
			vehicles[i] = new Kart(models[rc.nextInt(0,models.length)],rc.nextInt(minVehicleSpeed,maxVehicleSpeed),
						0,drivers[rc.nextInt(0,drivers.length)],i);
		}
		for (int i = numberOfVehicles/2; i < numberOfVehicles; i++) {
			vehicles[i] = new Scooter(i,drivers[rc.nextInt(0,drivers.length)],0,rc.nextInt(minVehicleSpeed,maxVehicleSpeed),models[rc.nextInt(0,models.length)]);
		}

		start(track,vehicles);
	}

	/**
	 * This method receives a track and a list of cars and it starts a race, showing the results in command line. 
	 * @throws IOException 
	 */
	private static void start(Track track, Vehicle[] vehicles) throws IOException {
		// At the end, who won the race? We should re-order the results. TODO.

		// We will track the total time per vehicle in an array matching positions. However, this should be done differently, with proper Java Objects.
		double[] times = new double[vehicles.length];

		// NOW WE START THE RACE!!!! We have to get the times for each vehicle per
		// section, and then the total time.
		nextComment(
				"Bienvenidos a la carrera simple en l�nea recta indoor. Hoy tenemos algunas scooters tratando de realizar el trayecto lo m�s r�pido posible!");
		nextComment("Comencemos con alguna informaci�n sobre la pista:");
		nextComment(track.getDescription());
		nextComment("Tenemos hoy " + vehicles.length + " competidores: ");
		for (Vehicle vehicle : vehicles) {
			nextComment("Con el n�mero " + vehicle.getNumber() + " tenemos un " + vehicle.getDescription()
					+ " pilotado por " + vehicle.getDriver() + ". Este veh�culo alcanza una velocidad m�xima de "
					+ vehicle.getMaxSpeed() + " km/h");
		}
		nextComment("Comienza la carrera!");
		
		for (int i=0; i<vehicles.length; i++) {
			Vehicle vehicle = vehicles[i];
			// for each vehicle, we want to track its total time.
			int currentSectionPosition = 1;
			double totalTime = 0;
			nextComment("El siguiente piloto es " + vehicle.getDriver() + " con el n�mero " + vehicle.getNumber()
					+ ". Se prepara para salir!");
			for (Section section : track.getSections()) {
				nextComment("\tEl siguiente tramo es el n�mero " + currentSectionPosition + ", "
						+ section.getDescription() + " de " + section.getLength()
						+ " metros de longitud, con una velocidad m�xima permitida de "
						+ section.getTheoreticalMaxSpeed() + "km/h");
				// The driver modifies the speed based on the section about to enter
				String action = vehicle.adaptSpeed(section);

				// Esta parte hará que los vehículos se salgan de la pista si su currentSpeed excede
				// la theoreticalMaxSpeed

				if (vehicle.getCurrentSpeed() > section.getActualMaxSpeed()) {
					System.out.println("El vehículo " + vehicle.getDescription() + " conducido por " + vehicle.getDriver() + " iba tan rápido que se salió de la pista en la sección " + section.getDescription() + " destrozando su coche! Queda descalificado!");
					vehicle.setDisqualified(true);
					break;

				} else {

					double secondsThisSection = section.getLength() / (vehicle.getCurrentSpeed() * 1d / 1000 * 3600);
					nextComment("\t" + action);
					nextComment("\tPasa la secci�n en " + secondsThisSection + " segundos.");
					totalTime += secondsThisSection;
					nextComment("\tSu tiempo total tras el tramo " + currentSectionPosition + " es de " + timeTo2Decimals(totalTime) + " segundos");
					currentSectionPosition++;
				}
				nextComment("\tFinaliza el recorrido! Su tiempo total es de " + timeTo2Decimals(totalTime) + " segundos.");
				times[i] = totalTime;
			}
		}
		
		// MODIFY THIS to show the results sorted by total time. 
		nextComment("Y acaba la carrera! Los tiempos de los pilotos son: ");
/* Este trozo de código ordena los tiempos de menor a mayor. Como el array de tiempos está igualado
* al array de coches, cambiamos las posiciones al mismo tiempo, por lo que ordenamos tanto
* el array de tiempos como el de coches por orden de llegada */
		for (int i=0; i<vehicles.length;i++) {
			for (int j = i; j < times.length; j++) {
				if (times[j] < times[i]) {
					double timesTemp = 0;
					timesTemp = times[j];
					Vehicle vehiclesTemp = vehicles[j];
					times[j] = times[i];
					vehicles[j] = vehicles[i];
					times[i] = timesTemp;
					vehicles[i] = vehiclesTemp;
				}
			}
			Vehicle vehicle = vehicles[i];
			if (vehicle.getDisqualified()) {
				nextComment("\t" + vehicle.getDriver() + " con el n�mero " + vehicle.getNumber() + " ha sido descalificado!");
			} else {
				nextComment("\t" + vehicle.getDriver() + " con el n�mero " + vehicle.getNumber() + " ha hecho un tiempo de " + timeTo2Decimals(times[i]) + " segundos.");
			}
		}
	}

	private static String timeTo2Decimals(double time) {
		return 0.01 * Math.round(time*100)+"";
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(USAGE);
		//simpleRandomRace(50, 100, 2, 5, 40, 150, 500, 2000, 70, 150);
		//defaultRace(10,15,3,3,15,150,100,5000,50,150);
		//defaultKartRace(2,5,3,3,20,150,100,5000,10,200);
		//randomKartRace(1,5,5,15,30,180,500,5000,60,200);
		randomScooterKartRace(1,5,4,10,60,200,1000,5000,70,150);
	}

	/*
	 * This method is just used as a convenience method to print a comment and await
	 * for the user to click enter to go to the next comment.
	 */
	private static void nextComment(String comment) throws IOException {
		System.out.println(comment);
//		System.in.read();
	}


}
