package Testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import Coursework.Customer;
import Coursework.CustomerImpl;

public class BuildingTest {

	@Test
	public void customerTest() {
		Customer c1 = new CustomerImpl(10);
		Customer c2 = new CustomerImpl(10);
		Customer c3 = new CustomerImpl(10);
		
		assertEquals("Wrong Answer!", c3.getId(), 3);
		
	}
 // bla bka
}
