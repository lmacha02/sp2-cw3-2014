package Coursework;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class ElevatorImpl.
 *
 * @author christianheiler
 */
public class ElevatorImpl implements Elevator {
	
	/** The current floor. */
	private int currentFloor;
	
	/** The num of floors. */
	private int NUM_OF_FLOORS;
	
	/** The register list. */
	private ArrayList<Customer> registerList = new ArrayList<Customer>();
	
	/** The direction. */
	private int direction= 1;
	
	/**
	 * Instantiates a new elevator impl.
	 *
	 * @param currentFloor the current floor
	 */
	public ElevatorImpl(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	/* (non-Javadoc)
	 * @see Coursework.Elevator#setFloors(int)
	 */
	@Override
	public void setFloors(int floors) {
		this.NUM_OF_FLOORS = floors;
	}

	/* (non-Javadoc)
	 * @see Coursework.Elevator#getFloors()
	 */
	@Override
	public int getFloors() {	
		return this.NUM_OF_FLOORS;
	}

	/* (non-Javadoc)
	 * @see Coursework.Elevator#move()
	 */
	@Override
	public void move() {
		this.currentFloor += this.direction;
		if(this.currentFloor == 13) this.currentFloor += this.direction;

	}

	/* (non-Javadoc)
	 * @see Coursework.Elevator#getCurrentFloor()
	 */
	@Override
	public int getCurrentFloor() {
		int output = this.currentFloor;
		//if(output >= 13) output++;
		return output;
	}

	/* (non-Javadoc)
	 * @see Coursework.Elevator#getRegisterList()
	 */
	@Override
	public ArrayList<Customer> getRegisterList() {
		return this.registerList;
	}

	/**
	 * Creates the Elevator and returns an Elevator Object.
	 *
	 * @return the elevator object
	 */
	public static Elevator create() {
		//assumption: Elevator always starts at ground floor.
		return new ElevatorImpl(0);
	}

	/* (non-Javadoc)
	 * @see Coursework.Elevator#customerLeaves(Coursework.Customer)
	 */
	@Override
	public void customerLeaves(Customer cust) {
		this.registerList.remove(cust);
		
	}

	/* (non-Javadoc)
	 * @see Coursework.Elevator#customerJoins(Coursework.Customer)
	 */
	@Override
	public void customerJoins(Customer cust) {
		this.registerList.add(cust);
		
	}

	/* (non-Javadoc)
	 * @see Coursework.Elevator#setDirection(int)
	 */
	@Override
	public void setDirection(int direction) {
		this.direction = direction;
		
	}

	/* (non-Javadoc)
	 * @see Coursework.Elevator#getDirection()
	 */
	@Override
	public int getDirection() {
		return this.direction;
	}

	/* (non-Javadoc)
	 * @see Coursework.Elevator#changeDirection()
	 */
	@Override
	public void changeDirection() {
		this.direction = this.direction * -1;
	}

	/* (non-Javadoc)
	 * @see Coursework.Elevator#setCurrentFloor(int)
	 */
	@Override
	public void setCurrentFloor(int i) {
		this.currentFloor = i;	
	}

	/* (non-Javadoc)
	 * @see Coursework.Elevator#getCustomersInElevatorString()
	 */
	@Override
	public String getCustomersInElevatorString() {
		String s = "";
		for(Customer cust : this.getRegisterList()){
			s = s + cust.getId()+" ";
		}
		return s;
	}

	/* (non-Javadoc)
	 * @see Coursework.Elevator#customerInElevator(Coursework.Customer)
	 */
	@Override
	public boolean customerInElevator(Customer cust) {
		return this.registerList.contains(cust);

	}

	/* (non-Javadoc)
	 * @see Coursework.Elevator#getCustomerMaxTargetFloor()
	 */
	@Override
	public int getCustomerMaxTargetFloor() {
		int temp = this.getCurrentFloor()-this.getDirection();
		for(Customer cust : this.getRegisterList()){
			if(this.getDirection() == 1){
				if(cust.getDestination() > temp) temp = cust.getDestination();
			} else if (this.getDirection() == -1){
				if(cust.getDestination() < temp) temp = cust.getDestination();
			}
		}
		return temp;
	}
	

}
