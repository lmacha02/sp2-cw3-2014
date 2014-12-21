package Testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import Coursework.Customer;
import Coursework.CustomerImpl;
import Coursework.Building;
import Coursework.BuildingImpl;
import Coursework.Elevator;

public class BuildingTest {

	@Test
	public void customerTest() {
		Customer c1 = new CustomerImpl(10);
		Customer c2 = new CustomerImpl(10);
		Customer c3 = new CustomerImpl(10);
		
		assertEquals("Wrong Answer!", c3.getId(), 3);
		
	}

	@Test
	public void BuilingListTest() {
		Customer c1 = new CustomerImpl(10);
		Customer c2 = new CustomerImpl(10);
		Customer c3 = new CustomerImpl(10);
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
		
		Customer c1 = new CustomerImpl(10);
		c1.setStart(3);
		c1.setDestination(6);
		Customer c2 = new CustomerImpl(10);
		c2.setStart(4);
		c2.setDestination(8);
		Customer c3 = new CustomerImpl(10);
		c3.setStart(5);
		c3.setDestination(10);
		Customer c4 = new CustomerImpl(10);
		c3.setStart(6);
		c3.setDestination(12);
		
		b.addCustomer(c1);
		b.addCustomer(c2);
		b.addCustomer(c3);
		b.addCustomer(c4);
		
		
		
		
		assertEquals("Is IN in elevator", false,e.getRegisterList().contains(c2));
	}
	
	
	
}
