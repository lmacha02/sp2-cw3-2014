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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void move(int direction) {
		if (direction == -1){
			this.currentFloor -= 1;
		} else if(direction == 1) {
			this.currentFloor += 1;
		} else {
			
		}
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

	@Override
	public Object create(int floors) {
		// TODO Auto-generated method stub
		return new ElevatorImpl(floors);
	}

	@Override
	public void customerLeaves(Object customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void customerJoins(Object customer) {
		// TODO Auto-generated method stub
		
	}


	
	

}
