package Testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import Coursework.Customer;
import Coursework.CustomerImpl;
import Coursework.Building;

import Coursework.Elevator;


public class BuildingTest {

	@Test
	public void customerTest() {
		Customer c1 = new CustomerImpl();
		Customer c2 = new CustomerImpl();
		Customer c3 = new CustomerImpl();
		
		assertEquals("Wrong Answer!", c3.getId(), 11);
		
	}

	@Test
	public void BuilingListTest() {
		Customer c1 = new CustomerImpl();
		Customer c2 = new CustomerImpl();
		Customer c3 = new CustomerImpl();
		Building b = (Building)Building.create();
		b.addCustomer(c1);
		b.addCustomer(c2);
		b.addCustomer(c3);
		
		int temp = b.getCustomerList().get(1).getId();
		
		assertEquals("Wrong Answer!", temp, c2.getId());	
	}
	
	@Test
	public void CustomerCheckFloor() {
		Building b = (Building)Building.create();
		Elevator e = (Elevator)Elevator.create();
		
		b.addElevator(e);
		
		Customer c1 = new CustomerImpl();
		c1.setStart(3);
		c1.setDestination(6);
		Customer c2 = new CustomerImpl();
		c2.setStart(3);
		c2.setDestination(8);
		Customer c3 = new CustomerImpl();
		c3.setStart(5);
		c3.setDestination(10);
		Customer c4 = new CustomerImpl();
		c4.setStart(12);
		c4.setDestination(5);
		
		b.addCustomer(c1);
		b.addCustomer(c2);
		b.addCustomer(c3);
		b.addCustomer(c4);
		
		for(int i=0; i<13; i++){
			b.getElevator().move();
			int current = b.getElevator().getCurrentFloor();
			System.out.print("Elevator on floor " + current + ": ");
			for(Customer cust : b.getCustomerList()){
				if (current == cust.getStart()){
					System.out.print(cust.getId() + "("+cust.getDirection()+") ");
				}
			}
			System.out.println();
			
		}
	}
	
	
	
	@Test
	public void BuildingTransitTest() {
		Building b = (Building)Building.create();
		Elevator e = (Elevator)Elevator.create();
		
		b.addElevator(e);
		
		Customer c1 = new CustomerImpl();
		c1.setStart(3);
		c1.setDestination(6);
		Customer c2 = new CustomerImpl();
		c2.setStart(3);
		c2.setDestination(8);
		Customer c3 = new CustomerImpl();
		c3.setStart(5);
		c3.setDestination(10);
		Customer c4 = new CustomerImpl();
		c4.setStart(12);
		c4.setDestination(5);
		
		b.addCustomer(c1);
		b.addCustomer(c2);
		b.addCustomer(c3);
		b.addCustomer(c4);
		
		int temp = b.getCustomersInTransit();
		assertEquals("Expected Transit incorrect!", 4, temp);
	}
	
	@Test
	public void BuildingStart1() {
		Building b = (Building)Building.create();
		b.setFloors(15);
		Elevator e = (Elevator)Elevator.create();
		
		b.addElevator(e);
		
		Customer c1 = new CustomerImpl();
		c1.setStart(3);
		c1.setDestination(6);
		Customer c2 = new CustomerImpl();
		c2.setStart(3);
		c2.setDestination(8);
		Customer c3 = new CustomerImpl();
		c3.setStart(5);
		c3.setDestination(10);
		Customer c4 = new CustomerImpl();
		c4.setStart(14);
		c4.setDestination(5);
		
		b.addCustomer(c1);
		b.addCustomer(c2);
		b.addCustomer(c3);
		b.addCustomer(c4);
		
		b.start(1);
	}

}
