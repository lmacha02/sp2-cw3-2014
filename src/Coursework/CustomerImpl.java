package Coursework;
import java.util.Random;

/**
 * @author lmacha02
 *
 */


//testing stupid github
//testing github agaaain

public class CustomerImpl implements Customer {
	
	private Boolean inElevator = false;
	private Boolean finished = false;
	private static int ID = 0;
	private int start;
	private int destination;
	
	public CustomerImpl(int topFloor) {
		this.ID++;
		
		// I was thinking of having the random generator here for simplicity, im not sure 
		// if it actually makes it easier tho.. 
		this.setDestination(this.randInt(topFloor));
		this.setStart(this.randInt(topFloor));			
	}
	
	// to generate the random int from 0 to top floor (the 13th floor issue should be dealt with
	// somewhere else
	private int randInt(int max) {
		int min = 0;
		
	    Random random = new Random();
	    int randomInt = random.nextInt((max - min) + 1) + min;

	    return randomInt;
	}
	

	public void setStart(int start) {
		this.start = start;
	}

	public int getStart() {
		return start;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public int getDestination() {
		return destination;
	}

	public int getId() {
		return this.ID;
	}

	public void setFinished() {
		finished = true;
	}
	
	public Boolean getFinished() {
		return finished;
	}

	public void setInElevator() {
		inElevator = true;
	}

	public Boolean getInElevator() {
		return inElevator;
	}
}