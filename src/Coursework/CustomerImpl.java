package Coursework;
import java.util.Random;

/**
 * @author lmacha02
 *
 */

public class CustomerImpl implements Customer {
	
	private Boolean inElevator = false;
	private Boolean finished = false;
	private static int COUNTER = 0;
	private int ID = ++COUNTER;
	private int start;
	private int destination;
	
	public CustomerImpl() {
		
	}
	


	public void setStart(int start) {
		if(start == 13){
			System.out.println("Customer "+this.getId()+" on non-existent floor!");
			start=0;
		}
		this.start = start;
	}

	public int getStart() {
		return start;
	}

	public void setDestination(int destination) {
		if(destination == 13){
			System.out.println("Customer "+this.getId()+" destination to non-existent floor!");
			destination=0;
		}
		this.destination = destination;
	}

	public int getDestination() {
		return destination;
	}

	public int getId() {
		return this.ID;
	}

	public void setFinished() {
		this.finished = true;
	}
	
	public Boolean getFinished() {
		return this.finished;
	}

	public void setInElevator(boolean status) {
		this.inElevator = status;
	}

	public Boolean getInElevator() {
		return this.inElevator;
	}

	@Override
	public int getDirection() {
		if(this.start<this.destination && !this.getFinished()) return 1;
		if(this.start>this.destination && !this.getFinished()) return -1;
		this.setFinished();
		return 0;
	}
	
	public static Customer create() {
		return new CustomerImpl();
	}
}