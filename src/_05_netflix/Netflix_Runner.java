package _05_netflix;

public class Netflix_Runner {
public static void main(String[] args) {
	Movie a = new Movie("Diary of a Wimpy Kid: Mid-Life Crisis",3);
	a.getRating();
	a.getTitle();
	a.getTicketPrice();
	
	Movie b = new Movie("Spider-Man: Finally at Home",4);
	b.getRating();
	b.getTitle();
	
	Movie c = new Movie("Captain America: The New Generation",5);
	c.getRating();
	c.getTitle();
	
	Movie d = new Movie("Covid-19: The Virus that Changed Everything",2);
	d.getRating();
	d.getTitle();
	
	Movie e = new Movie("Joker 2: Joker's Unfinished Business", 5);
	e.getRating();
	e.getTitle();
	
	NetflixQueue n = new NetflixQueue();
	n.addMovie(a);
	n.addMovie(b);
	n.addMovie(c);
	n.addMovie(d);
	n.addMovie(e);
	n.printMovies();
	n.getBestMovie();
	System.out.println("The best movie is " + n.getBestMovie());
	System.out.println("The second best movie is " + n.getSecondBestMovie());
}
}
