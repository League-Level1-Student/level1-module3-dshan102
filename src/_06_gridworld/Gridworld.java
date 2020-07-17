package _06_gridworld;

import java.awt.Color;
import java.util.Random;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class Gridworld {
	int x;
	int y;
	int random_int = (int)(Math.random() * (10 - 1) + 1);
	 World world = new World();
	
	Bug bug = new Bug();
	Bug bug1 = new Bug();
	Color bugcolor = new Color(0,0,255);
	
	Flower flower = new Flower();
	Flower flower1 = new Flower();
	Flower flower2 = new Flower();
	
	Location location = new Location(5,5);
	Location location1 = new Location(random_int,random_int);
	Location location2 = new Location(random_int+1,random_int);
	Location location3 = new Location(random_int-1,random_int);
	Location location4 = new Location(x,y);
	
	public void run() {
		world.show();
		world.add(location, bug);
		world.add(location1, bug1);
		bug1.setColor(bugcolor);
		bug1.setDirection(90);
		world.add(location2, flower);
		world.add(location3, flower1);
		for(x=0; x<10; x++) {
			for(y=0;y<10;y++) {
				location4 = new Location(x,y);
				world.add(location4, flower2);
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Gridworld().run();
	}
}

