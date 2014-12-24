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
	
	public ArrayList<Customer> getRegisterList();
	
	/*
	 * Create Object
	 * @return Elevator Object.
	 */
	public static Object create(){
		return ElevatorImpl.create();
	}
	
	/*
	 * customerLeaves
	 * @param customer
	 * deregisters customer from customerList
	 */
	public void customerLeaves(Customer cust);
	
	/*
	 * customerJoins
	 * @param customer
	 * registers customer to customerList
	 */
	public void customerJoins(Customer cust);
	
	public void setDirection(int direction);
	
	public int getDirection();
	
	/*
	 * changeDirection
	 * changeCurrentDirection	
	 */
	public void changeDirection();
	
	public void setCurrentFloor(int i);
	
	public String getCustomersInElevatorString();
	
	public boolean customerInElevator(Customer cust);
	

	
	
}
