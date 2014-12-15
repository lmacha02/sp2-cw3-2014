/**
 * 
 */
package Coursework;

import java.util.ArrayList;

/**
 * @author christianheiler
 *
 */
public class BuildingImpl implements Building{
	private int NUM_OF_FLOORS;
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private Elevator elevator;
	
	/**
	 * 
	 */
	public BuildingImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setFloors(int numberFloors) {
		this.NUM_OF_FLOORS = numberFloors;
	}

	@Override
	public int getFloors() {
		return this.NUM_OF_FLOORS;
	}

	@Override
	public void addCustomer(Customer cust) {
		this.customerList.add(cust);
		
	}

	@Override
	public ArrayList<Customer> getCustomerList() {
		return this.customerList;
	}

	@Override
	public void addElevator(Elevator e) {
		this.elevator = e;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		//process logic(s);
		
	}
	
	

}
