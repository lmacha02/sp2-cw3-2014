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
	private static int LOWEST_FLOOR = 0; //assumption: There is no basement
	private int NUM_OF_FLOORS;
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private Elevator elevator;
	

	@Override
	public void setFloors(int numberFloors) {
		if(numberFloors == 13){
			System.out.println("Building can't have 13 floors, setting to 14");
			numberFloors = 14;
		}
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
	public void start(int logic) {
		if(logic == 1) this.logic1();
	}
	
	public static Building create() {
		return Building.create();
	}

	@Override
	public boolean customerOnCurrentFloor(Customer cust) {
		int current = this.elevator.getCurrentFloor();
		if( current == cust.getStart() ) return true;
		return false;
	}

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
	
	private void logic1(){
		while(this.getCustomersInTransit()>0){
			int current = this.getElevator().getCurrentFloor();
			System.out.print(current+": ");
			for(Customer cust : this.customerList){
				if(!cust.getFinished()){
					if( !this.getElevator().customerInElevator(cust) && current == cust.getStart()){
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
	
	
	

}
