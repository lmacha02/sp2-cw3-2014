package Coursework;
import java.util.Random;
import java.util.Scanner;


public class Controller {
	public static void main(String[] args) {
		//create building and elevators
		

		
		
		
		
		Scanner scanner = new Scanner(System.in);
		 
		
		System.out.print("Set number of floors: ");
		int inFloors = scanner.nextInt();// exception handling to be added
		System.out.print("Set number of customers:");
		int inCustomer = scanner.nextInt();// exception handling to be added
		
		scanner.close();
		
		System.out.println("Creating Building with "+inFloors+" Floors and "+inCustomer+" Customers");
		
		Building b = Building.create();
		Elevator e = Elevator.create();
		b.addElevator(e);
		b.setFloors(inFloors);
		
		System.out.println("Created");
		
		for(int i = 0;i < inCustomer;i++){
			Customer cust = Customer.create();
			cust.setStart(rnd(inFloors));
			cust.setDestination(rnd(inFloors));
			System.out.println("Creating Customer " +cust.getId() +": Start: "+cust.getStart()+" Dest: "+cust.getDestination());
			b.addCustomer(cust);
		}
		System.out.println("Starting the Elevator:");
		b.start(1);
		
		
	}
	
	//generate random number with max i excluding 13
	public static int rnd(int i){
		Random rn = new Random();
		int rand = 0;
		do{
			rand = rn.nextInt(i*10000) + 10000;
			rand = rand/10000;
		}while(rand == 13);
		
		return rand;
	}
	
	
	
}
