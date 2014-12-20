package Testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import Coursework.Customer;
import Coursework.CustomerImpl;
import Coursework.ElevatorImpl;
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
		Elevator e = (Elevator) Elevator.create();
		Customer c1 = new CustomerImpl(10);
		Customer c2 = new CustomerImpl(10);
		Customer c3 = new CustomerImpl(10);
		
		e.customerJoins(c1);
		int temp = e.getRegisterList().get(0).getId();

		assertEquals("Wrong Answer!", temp, 1);
	}
	

}
