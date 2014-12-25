/**
 * 
 */
package Coursework;

import java.util.ArrayList;

/**
 * @author christianheiler
 *
 */
public class ElevatorImpl implements Elevator {
	private int currentFloor;
	private int NUM_OF_FLOORS;
	private ArrayList<Customer> registerList = new ArrayList<Customer>();
	private int direction= 1;
	
	/**
	 * 
	 */
	public ElevatorImpl(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	@Override
	public void setFloors(int floors) {
		this.NUM_OF_FLOORS = floors;
	}

	@Override
	public int getFloors() {	
		return this.NUM_OF_FLOORS;
	}

	@Override
	public void move() {
		this.currentFloor += this.direction;
		if(this.currentFloor == 13) this.currentFloor += this.direction;

	}

	@Override
	public int getCurrentFloor() {
		int output = this.currentFloor;
		//if(output >= 13) output++;
		return output;
	}

	@Override
	public ArrayList<Customer> getRegisterList() {
		return this.registerList;
	}

	public static Object create() {
		//assumption: Elevator always starts at ground floor.
		return new ElevatorImpl(0);
	}

	@Override
	public void customerLeaves(Customer cust) {
		this.registerList.remove(cust);
		
	}

	@Override
	public void customerJoins(Customer cust) {
		this.registerList.add(cust);
		
	}

	@Override
	public void setDirection(int direction) {
		this.direction = direction;
		
	}

	@Override
	public int getDirection() {
		return this.direction;
	}

	@Override
	public void changeDirection() {
		this.direction = this.direction * -1;
	}

	@Override
	public void setCurrentFloor(int i) {
		this.currentFloor = i;	
	}

	@Override
	public String getCustomersInElevatorString() {
		String s = "";
		for(Customer cust : this.getRegisterList()){
			s = s + cust.getId()+" ";
		}
		return s;
	}

	@Override
	public boolean customerInElevator(Customer cust) {
		return this.registerList.contains(cust);

	}
	
	
	
	


	
	

}
