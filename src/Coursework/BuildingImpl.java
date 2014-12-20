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
	public Elevator getElevator() {
		return this.elevator;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		//process logic(s);
		
	}
	
	public static Object create() {
		return (Object)Building.create();
	}

	@Override
	public boolean customerInElevator(Customer cust) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean customerOnFloor(int f) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
