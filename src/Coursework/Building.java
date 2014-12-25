/**
 * 
 */
package Coursework;

import java.util.ArrayList;

/**
 * @author cheile01
 *
 */
public interface Building {
	int numFloors = 0;
	
	
	/*
	 * @param numberFloors number of floors 
	 */
	public void setFloors(int numberFloors);
	
	public int getFloors();
	
	public void addCustomer(Customer cust);
	
	public ArrayList<Customer> getCustomerList();
	
	public void addElevator(Elevator e);
	
	public Elevator getElevator();
	
	public static Building create(){
		return new BuildingImpl();
	}
	
	public void start(int logic);
	
	boolean customerOnCurrentFloor(Customer cust);
	
	public int getCustomersInTransit();
	
	
}
