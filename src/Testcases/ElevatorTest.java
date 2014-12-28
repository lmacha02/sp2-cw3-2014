package Testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import Coursework.Customer;
import Coursework.CustomerImpl;
import Coursework.Elevator;

public class ElevatorTest {

	@Test
	public void test() {
		Elevator e = (Elevator) Elevator.create();
		e.setCurrentFloor(5);
		assertEquals("Wrong Answer!", e.getCurrentFloor(), 5);
	}
	
	@Test
	public void movetestUp() {
		Elevator e = (Elevator) Elevator.create();
		e.setCurrentFloor(5);
		e.setDirection(1);
		e.move();
		assertEquals("Wrong Answer!", e.getCurrentFloor(), 6);
	}
	
	@Test
	public void movetestDown() {
		Elevator e = (Elevator) Elevator.create();
		e.setCurrentFloor(5);
		e.setDirection(-1);
		e.move();
		assertEquals("Wrong Answer!", e.getCurrentFloor(), 4);
	}
	
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
	
	
	
	
	
	

}
