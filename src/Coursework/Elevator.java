/**
 * 
 */
package Coursework;

import java.util.ArrayList;


/**
 * @author christianheiler
 *
 */
public interface Elevator {
	int currentFloor = 0;
	int NUM_OF_FLOORS = 0;
	int direction = 0;
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	
	public void setFloors(int floors);
	public int getFloors();
	
	/* move elevator
	 * move elevator in the current direction
	 */
	public void move();
	
	public int getCurrentFloor();
	
	public ArrayList<Object> registerList();
	
	/*
	 * Create Object
	 * @param floors - number of floors in the 
	 * @return Elevator Object.
	 */
	public Object create(int floors);
	
	/*
	 * customerLeaves
	 * @param customer
	 * deregisters customer from customerList
	 */
	public void customerLeaves(Object customer);
	
	/*
	 * customerJoins
	 * @param customer
	 * registers customer to customerList
	 */
	public void customerJoins(Object customer);
	
	public void setDirection(int direction);
	
	public int getDirection();
	
	/*
	 * changeDirection
	 * changeCurrentDirection	
	 */
	public void changeDirection();
	
	public void setCurrentFloor(int i);
	
	
	
	
	
	
}
