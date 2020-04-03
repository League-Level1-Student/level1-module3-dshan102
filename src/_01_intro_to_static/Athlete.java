package _01_intro_to_static;

public class Athlete {
	static String raceLocation = "New York";
	static String raceStartTime = "9.00am";
	static String name1;
	static String name2;
	static int speed1;
	static int speed2;
	static int bibNumber = 1;
	static int nextBibNumber = bibNumber + 1;

	private static void Athlete1(String name1, int speed1) {
		
	}
	public static void Athlete2 (String name2, int speed3) {
		
	}

	public static void main(String[] args) {
		// create two athletes
		// print their names, bibNumbers, and the location of their race.
		Athlete1("Jeff", 5);
		System.out.println(name1);
		System.out.println(speed1);
		System.out.println(bibNumber);
		System.out.println(raceLocation);
		Athlete2("John", 5);
		System.out.println(name2);
		System.out.println(nextBibNumber);
		System.out.println(raceLocation);

	}

}
 