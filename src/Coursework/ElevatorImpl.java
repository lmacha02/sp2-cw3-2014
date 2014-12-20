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
	private int direction;
	
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

	}

	@Override
	public int getCurrentFloor() {
		return this.currentFloor;
	}

	@Override
	public ArrayList<Object> registerList() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object create() {
		//assumption: Elevator always starts at ground floor.
		return new ElevatorImpl(0);
	}

	@Override
	public void customerLeaves(Object customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void customerJoins(Object customer) {
		// TODO Auto-generated method stub
		
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
	
	


	
	

}
