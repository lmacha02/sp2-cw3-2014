package Coursework;
import java.util.Random;
import java.util.Scanner;


public class Controller {
	public static void main(String[] args) {
		//create building and elevator

		int inFloors = getPositiveInteger("Set number of floors:");

		int inCustomer = getPositiveInteger("Set number of customers:");
		
		System.out.println("Creating Building with "+inFloors+" Floors and "+inCustomer+" Customers");
		
		Building b1 = Building.create();
		Elevator e1 = Elevator.create();
		b1.addElevator(e1);
		b1.setFloors(inFloors);		
		
		System.out.println("Created");
		
		int start = 0;
		int dest = 0;
		
		for(int i = 0;i < inCustomer;i++){
			//creating customer 
			Customer cust1 = Customer.create();
			start = rnd(inFloors);
			dest = rnd(inFloors);
			
			cust1.setStart(start);
			cust1.setDestination(dest);
			
			System.out.println("Creating Customer " +cust1.getId() +": Start: "+cust1.getStart()+" Dest: "+cust1.getDestination());
			//add customer to building
			b1.addCustomer(cust1);
		}
		System.out.println("Starting the Elevator:");
		b1.start(1);
		System.out.println("Starting Logic 2");
		
		//make customers active again
		for(Customer cust : b1.getCustomerList()){
			cust.setUnfinished();
		}
		//reset elevator
		b1.getElevator().setCurrentFloor(0);
		b1.getElevator().setDirection(1);
		
		b1.start(2);
		
	}
	
	//generate random number with max i excluding 13
	public static int rnd(int i){
		Random rn = new Random();
		int rand = 0;
		do{
			rand = rn.nextInt(i*10000 + 10000);//creating a variable between 0 and NumberOfFloors.
			rand = rand/10000;
		}while(rand == 13);
		
		return rand;
	}
	
	public static int getPositiveInteger(String message){
		Scanner in = new Scanner(System.in);
		System.out.print(message+" ");
		int temp = 0;
		do{
			if(in.hasNextInt()){
				temp = in.nextInt();
				if(temp < 1){
					System.out.print("A positive integer please! ");
					temp = 0;
				}
			} else {
				System.out.print("A positive integer please! ");
				in.next();
			}
			
		}while(temp < 1);

		return temp;
		
	}
	
	
}
