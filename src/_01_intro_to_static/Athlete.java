package _01_intro_to_static;

public class Athlete {
	    static int nextBibNumber;
	    static String raceLocation = "New York";
	    static String raceStartTime = "9.00am";

	     static String name;
	     static int speed;
	     static int bibNumber;

	    Athlete (String name, int speed, int bibNumber){
	        this.name = name;
	        this.speed = speed;
	        this.bibNumber = bibNumber;
	    }

	    public static void main(String[] args) {
	        //create two athletes
	        //print their names, bibNumbers, and the location of their race. 
	    	Athlete("Jeff", 5, 21);
	    	System.out.println(name);
	    	System.out.println(bibNumber);
	    	System.out.println(raceLocation);
	    	Athlete("John", 5, 22);
	    	System.out.println(name);
	    	System.out.println(bibNumber);
	    	System.out.println(raceLocation);
	    	
	    }
}
