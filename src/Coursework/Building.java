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
	
	public static Object create(){
		return (Object)Building.create();
	}
	
	public void start();
	
}
