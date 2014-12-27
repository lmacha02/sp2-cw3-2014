package Coursework;

import java.util.ArrayList;

/**
 * The Class BuildingImpl.
 * Implements Building
 *
 * @author christianheiler
 */
public class BuildingImpl implements Building{
	
	/** The lowest floor. */
	private static int LOWEST_FLOOR = 0; //assumption: There is no basement
	
	/** The num of floors. */
	private int NUM_OF_FLOORS;
	
	/** The customer list. */
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	/** The elevator. */
	private Elevator elevator;
	

	/* (non-Javadoc)
	 * @see Coursework.Building#setFloors(int)
	 */

	@Override
	public void setFloors(int numberFloors) {
		if(numberFloors == 13){
			System.out.println("Building can't have 13 floors, setting to 14");
			numberFloors = 14;
		}
		this.NUM_OF_FLOORS = numberFloors;
	}

	/* (non-Javadoc)
	 * @see Coursework.Building#getFloors()
	 */

	@Override
	public int getFloors() {
		return this.NUM_OF_FLOORS;
	}

	/* (non-Javadoc)
	 * @see Coursework.Building#addCustomer(Coursework.Customer)
	 */

	@Override
	public void addCustomer(Customer cust) {
		this.customerList.add(cust);
		
	}

	/* (non-Javadoc)
	 * @see Coursework.Building#getCustomerList()
	 */

	@Override
	public ArrayList<Customer> getCustomerList() {
		return this.customerList;
	}

	/* (non-Javadoc)
	 * @see Coursework.Building#addElevator(Coursework.Elevator)
	 */

	@Override
	public void addElevator(Elevator e) {
		this.elevator = e;
	}
	
	/* (non-Javadoc)
	 * @see Coursework.Building#getElevator()
	 */

	@Override
	public Elevator getElevator() {
		return this.elevator;
	}

	/* (non-Javadoc)
	 * @see Coursework.Building#start(int)
	 */
	@Override
	public void start(int logic) {
		if(logic == 1) this.logic1();
		if(logic == 2) this.logic2();
	}
	
	/**
	 * Creates the Building and returns it.
	 *
	 * @return the building
	 */
	public static Building create() {
		return Building.create();
	}

	/* (non-Javadoc)
	 * @see Coursework.Building#customerOnCurrentFloor(Coursework.Customer)
	 */
	@Override
	public boolean customerOnCurrentFloor(Customer cust) {
		int current = this.elevator.getCurrentFloor();
		if( current == cust.getStart() ) return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see Coursework.Building#getCustomersInTransit()
	 */
	@Override
	public int getCustomersInTransit() {
		int count = 0;
		for(Customer cust : this.customerList){
			if(cust.getFinished() == false){
				count++;
			}
		}
		return count;
	}
	
	
	
	
	/**
	 * Logic1.
	 * The default logic of the building.
	 * Takes in all customers on each floor and lets them step out on the correct floor.
	 * 
	 */
	private void logic1(){
		while(this.getCustomersInTransit()>0){
			int current = this.getElevator().getCurrentFloor();
			System.out.print(current+": ");
			for(Customer cust : this.customerList){
				if(!cust.getFinished()){
					if( !cust.getInElevator() && current == cust.getStart()){
						this.getElevator().customerJoins(cust);
						cust.setInElevator(true);
						System.out.print(cust.getId()+"+ ");
					}
					if( cust.getInElevator() && current == cust.getDestination()){
						this.getElevator().customerLeaves(cust);
						cust.setInElevator(false);
						cust.setFinished();
						System.out.print(cust.getId()+"- ");
					}
				}//END IF !cust.get.Finished()
			}//END FOR loop
			if (current == this.NUM_OF_FLOORS) {
				this.getElevator().setDirection(-1);
				System.out.print(" DOWN ");
			}
			//Make Elevator turn around in case it has reached top or bottom floor.
			if (current == LOWEST_FLOOR) {
				this.getElevator().setDirection(1);
				System.out.print(" UP ");
			}
			System.out.println("["+this.getElevator().getCustomersInElevatorString()+"]");
			this.getElevator().move();
		}//END WHILE no more customers needing transportation.
	}
	
	/**
	 * Logic2.
	 * Improved logic for the elevator
	 * Only takes customers in the direction of the elevator.
	 */
	/**
	 * 
	 */
	private void logic2(){
		while(this.getCustomersInTransit()>0){
			int current = this.getElevator().getCurrentFloor();
			System.out.print(current+": ");
			//Make elevator turn around if there are no customers ahead that need to get Off.
			int temp = this.getMaxStartFloor(this.getElevator().getDirection());
			int temp2 = this.getElevator().getCustomerMaxTargetFloor();
			
			if(this.getElevator().getDirection() == 1){
				if(temp < temp2) temp = temp2;
			} else if (this.getElevator().getDirection() == -1){
				if(temp > temp2) temp = temp2;
			}
			
			if(current == temp){
				this.getElevator().changeDirection();
				System.out.print(" CHANGE ");
			}			
			//Make Elevator turn around in case it has reached top or bottom floor.
			//these should never be invoked but are here in case of a calculation error
			if (current == this.NUM_OF_FLOORS) {
				this.getElevator().setDirection(-1);
				System.out.print(" DOWN ");
			} else if (current == LOWEST_FLOOR) {
				this.getElevator().setDirection(1);
				System.out.print(" UP ");
			}
			
			
			for(Customer cust : this.customerList){
				if(!cust.getFinished()){
					if( !this.getElevator().customerInElevator(cust) 
							&& current == cust.getStart() 
							&& cust.getDirection() == this.getElevator().getDirection()){
						this.getElevator().customerJoins(cust);
						cust.setInElevator(true);
						System.out.print(cust.getId()+"+ ");
					}
					if( this.getElevator().customerInElevator(cust) && current == cust.getDestination()){
						this.getElevator().customerLeaves(cust);
						cust.setInElevator(false);
						cust.setFinished();
						System.out.print(cust.getId()+"- ");
					}
				}//END IF !cust.get.Finished()
			}//END FOR loop
			
			System.out.println("["+this.getElevator().getCustomersInElevatorString()+"]");
			this.getElevator().move();

		}//END WHILE no more customers needing transportation.
	}

	
	/**
	 * Gets the max start floor.
	 *
	 * @param direction the direction
	 * @return the max start floor
	 */
	@Override
	public int getMaxStartFloor(int direction) {
		int temp = 0;
		if(direction == -1) temp = this.getFloors(); //set top floor to count down from.
		
		for(Customer cust : this.getCustomerList()){
			//only count customers that are still active and not already in elevator
			if(!cust.getFinished() && !cust.getInElevator()){
				if(direction == 1){
					if(cust.getStart() > temp) temp = cust.getStart();
				} else if (direction == -1){
					if(cust.getStart() < temp) temp = cust.getStart();
				}
				
			}	
		}
		return temp;
	}
	
	
	
	
	
	

}
