package Testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import Coursework.Building;
import Coursework.Customer;
import Coursework.CustomerImpl;
import Coursework.Elevator;

// TODO: Auto-generated Javadoc
/**
 * The Class ElevatorTest.
 */
public class ElevatorTest {

	/**
	 * Test.
	 */
	@Test
	public void test() {
		Elevator e = (Elevator) Elevator.create();
		e.setCurrentFloor(5);
		assertEquals("Wrong Answer!", e.getCurrentFloor(), 5);
	}
	
	/**
	 * Movetest up.
	 */
	@Test
	public void movetestUp() {
		Elevator e = (Elevator) Elevator.create();
		e.setCurrentFloor(5);
		e.setDirection(1);
		e.move();
		assertEquals("Wrong Answer!", e.getCurrentFloor(), 6);
	}
	
	/**
	 * Movetest down.
	 */
	@Test
	public void movetestDown() {
		Elevator e = (Elevator) Elevator.create();
		e.setCurrentFloor(5);
		e.setDirection(-1);
		e.move();
		assertEquals("Wrong Answer!", e.getCurrentFloor(), 4);
	}
	
	/**
	 * Customer in test.
	 */
	@Test
	public void CustomerInTest() {
		Elevator e = (Elevator)Elevator.create();
		Customer c1 = new CustomerImpl();
		Customer c2 = new CustomerImpl();
		Customer c3 = new CustomerImpl();
		Customer c4 = new CustomerImpl();
		
		e.customerJoins(c1);
		e.customerJoins(c2);
		e.customerJoins(c3);
		e.customerJoins(c4);
		
		int temp = e.getRegisterList().get(2).getId();
		
		assertEquals("Wrong Customer ID!", c3.getId(),temp);
	}
	
	/**
	 * Customer is in test.
	 */
	@Test
	public void CustomerIsInTest() {
		Elevator e = (Elevator)Elevator.create();
		Customer c1 = new CustomerImpl();
		Customer c2 = new CustomerImpl();
		Customer c3 = new CustomerImpl();
		Customer c4 = new CustomerImpl();
		
		e.customerJoins(c1);
		e.customerJoins(c2);
		e.customerJoins(c3);
		e.customerJoins(c4);
		
	
		assertEquals("Is NOT in elevator", true,e.getRegisterList().contains(c2));
	}
	
	/**
	 * Customer leaves test.
	 */
	@Test
	public void CustomerLeavesTest() {
		Elevator e = (Elevator)Elevator.create();
		Customer c1 = new CustomerImpl();
		Customer c2 = new CustomerImpl();
		Customer c3 = new CustomerImpl();
		Customer c4 = new CustomerImpl();
		
		e.customerJoins(c1);
		e.customerJoins(c2);
		e.customerJoins(c3);
		e.customerJoins(c4);
		
		e.customerLeaves(c2);
		
		assertEquals("Is IN in elevator", false,e.getRegisterList().contains(c2));
	}
	
	/**
	 * Customer max floor check.
	 */
	@Test
	public void CustomerMaxFloorCheck() {

		Elevator e = (Elevator)Elevator.create();
		
		Customer c1 = new CustomerImpl();
		c1.setStart(3);
		c1.setDestination(6);
		Customer c2 = new CustomerImpl();
		c2.setStart(3);
		c2.setDestination(8);
		Customer c3 = new CustomerImpl();
		c3.setStart(5);
		c3.setDestination(9);
		Customer c4 = new CustomerImpl();
		c4.setStart(12);
		c4.setDestination(5);
				
		e.customerJoins(c1);
		e.customerJoins(c2);
		e.customerJoins(c3);
		e.customerJoins(c4);	
		
		e.setCurrentFloor(5);
		e.setDirection(1);
		
		assertEquals("Max Floor for customers", e.getCustomerMaxTargetFloor(),9);
		
		
	}
	
	
	

}
