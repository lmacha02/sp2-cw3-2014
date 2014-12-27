/**
 * 
 */
package Coursework;

import java.util.ArrayList;

/**
 * The Interface Building.
 *
 * @author cheile01
 */
public interface Building {
	

	int numFloors = 0;
	
	
	/**
	 * Sets the maximum number of floors.
	 *
	 * @param numberFloors the floors of the building
	 */
	public void setFloors(int numberFloors);
	
	/**
	 * Gets the floors.
	 *
	 * @return the floors
	 */
	public int getFloors();
	
	/**
	 * Adds a new Customer.
	 *
	 * @param cust the Customer
	 */
	public void addCustomer(Customer cust);
	
	/**
	 * Gets the customer list.
	 *
	 * @return the customer list
	 */
	public ArrayList<Customer> getCustomerList();
	
	/**
	 * Adds the elevator.
	 *
	 * @param e the Elevator
	 */
	public void addElevator(Elevator e);
	
	/**
	 * Gets the elevator of the building.
	 *
	 * @return the elevator
	 */
	public Elevator getElevator();
	
	/**
	 * Creates the Building
	 *
	 * @return the Building object
	 */
	public static Building create(){
		return new BuildingImpl();
	}
	
	/**
	 * Start the logic to transport customers
	 *
	 * @param logic (1)Default (2)Improved

	 */
	public void start(int logic);
	
	/**
	 * Customer on current floor.
	 *
	 * @param cust the cust
	 * @return true, if successful
	 */
	boolean customerOnCurrentFloor(Customer cust);
	
	/**
	 * Gets the amount of customers in transit.
	 *
	 * @return the customers in transit
	 */
	public int getCustomersInTransit();
	
	
	public int getMaxStartFloor(int direction); 
	
	
}
