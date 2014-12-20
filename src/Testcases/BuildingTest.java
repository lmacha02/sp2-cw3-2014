package Testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import Coursework.Customer;
import Coursework.CustomerImpl;
import Coursework.Building;
import Coursework.BuildingImpl;

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
		
		int temp = b.getCustomerList().get(2).getId();
		
		assertEquals("Wrong Answer!", temp, c3.getId());	
	}
	
	
	
	
}
