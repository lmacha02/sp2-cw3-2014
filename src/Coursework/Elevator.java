package Coursework;

import java.util.ArrayList;


/**
 * The Interface Elevator.
 *
 * @author christianheiler
 */
public interface Elevator {
	
	/** The current floor. */
	int currentFloor = 0;
	
	/** The num of floors. */
	int NUM_OF_FLOORS = 0;
	
	/** The direction. */
	int direction = 0;
	
	/** The customer list. */
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	
	/**
	 * Sets the floors of the building.
	 *
	 * @param floors the new floors
	 */
	public void setFloors(int floors);
	
	/**
	 * Gets the floors.
	 *
	 * @return the floors
	 */
	public int getFloors();
	
	/**
	 * move elevator
	 * move elevator in the current direction.
	 */
	public void move();
	
	/**
	 * Gets the current floor.
	 *
	 * @return the current floor
	 */
	public int getCurrentFloor();
	
	/**
	 * Gets the register list.
	 *
	 * @return the register list
	 */
	public ArrayList<Customer> getRegisterList();
	
	/**
	 * Creates the Elevator
	 *
	 * @return the elevator
	 */
	public static Elevator create(){
		return ElevatorImpl.create();
	}
	
	/**
	 * Customer leaves.
	 * Removes the customer from the customerList and sets the customer flag finished.
	 *
	 * @param cust the customer
	 */
	public void customerLeaves(Customer cust);
	
	/**
	 * Customer joins.
	 * Adds the customer to the customerList
	 *
	 * @param cust the cust
	 */
	public void customerJoins(Customer cust);
	
	/**
	 * Sets the direction.
	 *
	 * @param direction the new direction
	 */
	public void setDirection(int direction);
	
	/**
	 * Gets the direction.
	 *
	 * @return the direction
	 */
	public int getDirection();
	
	/**
	 * Change current direction.
	 */
	public void changeDirection();
	
	/**
	 * Sets the current floor.
	 *
	 * @param i the new current floor
	 */
	public void setCurrentFloor(int i);
	
	/**
	 * Gets the customers in elevator string.
	 *
	 * @return the customers in elevator string
	 */
	public String getCustomersInElevatorString();
	
	/**
	 * Determines if the customer in elevator.
	 *
	 * @param cust the customer to be checked
	 * @return true, if customer in elevator
	 */
	public boolean customerInElevator(Customer cust);
	
	
	/**
	 * Find the highest/lowest destination floor of all customers in customerList
	 * Depends on the direction set in setDirection
	 * 
	 * @return top/bottom floor a customer needs to exit the elevator
	 */
	public int getCustomerMaxTargetFloor();
	
	
}
