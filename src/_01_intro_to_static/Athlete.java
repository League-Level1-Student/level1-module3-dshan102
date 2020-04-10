package _01_intro_to_static;

public class Athlete {
	static String name;
	static int speed;
	static int athleteNumber;
	static int bibNumber = 1;
    static int nextBibNumber = bibNumber+1;
    static String raceLocation = "New York";
    static String raceStartTime = "9.00am";

    Athlete (String name, int speed, int athleteNumber){
        this.name = name;
        this.speed = speed;
        this.athleteNumber = athleteNumber;
    }
    public String getName() {
    	return name;
    }
    public int getBibNumber() {
    	if (athleteNumber == 1) {
        	bibNumber = bibNumber;
    	}
    	else if (athleteNumber == 2){
    		bibNumber = nextBibNumber;
    	}
    		return bibNumber;
    }
    public String getRaceLocation() {
    	return raceLocation;
    }


    public static void main(String[] args) {
        //create two athletes
        //print their names, bibNumbers, and the location of their race. 
    	Athlete Jeff = new Athlete("Jeff",5,1);
    	Jeff.getName();
    	System.out.println(name);
    	Jeff.getBibNumber();
    	System.out.println(bibNumber);
    	Jeff.getRaceLocation();
    	System.out.println(raceLocation);
    	
    	Athlete John = new Athlete("John",5,2);
    	John.getName();
    	System.out.println(name);
    	John.getBibNumber();
    	System.out.println(bibNumber);
    	John.getRaceLocation();
    	System.out.println(raceLocation);
    }
}