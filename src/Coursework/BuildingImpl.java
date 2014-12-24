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
				}
			}
			if (current == this.NUM_OF_FLOORS) {
				this.getElevator().setDirection(-1);
				System.out.print(" DOWN ");
			}
			if (current == LOWEST_FLOOR) {
				this.getElevator().setDirection(1);
				System.out.print(" UP ");
			}
			System.out.println("["+this.getElevator().getCustomersInElevatorString()+"]");
			this.getElevator().move();
		}
		
	}
	
	public static Object create() {
		return (Object)Building.create();
	}

	@Override
	public boolean customerOnCurrentFloor(Customer cust) {
		int current = this.elevator.getCurrentFloor();
		if( current == cust.getStart() ) return true;
		return false;
	}

	@Override
	public boolean customerOnFloor(int f, Customer cust) {
		// TODO Auto-generated method stub
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
	
	
	
	

}
