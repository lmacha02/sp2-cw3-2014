package Coursework;
import java.util.Random;
import java.util.Scanner;


public class Controller {
	public static void main(String[] args) {
		//create building and elevators

		int inFloors = getPositiveInteger("Set number of floors:");

		int inCustomer = getPositiveInteger("Set number of customers:");
		
		System.out.println("Creating Building with "+inFloors+" Floors and "+inCustomer+" Customers");
		
		Building b1 = Building.create();
		Elevator e1 = Elevator.create();
		b1.addElevator(e1);
		b1.setFloors(inFloors);
		
		Building b2 = Building.create();
		Elevator e2 = Elevator.create();
		b2.addElevator(e2);
		b2.setFloors(inFloors);		
		
		System.out.println("Created");
		
		int start = 0;
		int dest = 0;
		
		for(int i = 0;i < inCustomer;i++){
			//creating 2 customers that have the same start and destination floors for comparison.
			Customer cust1 = Customer.create();
			Customer cust2 = Customer.create();
			start = rnd(inFloors);
			dest = rnd(inFloors);
			
			cust1.setStart(start);
			cust1.setDestination(dest);
			
			cust2.setStart(start);
			cust2.setDestination(dest);
			
			System.out.println("Creating Customer " +cust1.getId() +": Start: "+cust1.getStart()+" Dest: "+cust1.getDestination());
			b1.addCustomer(cust1);
			b2.addCustomer(cust2);
		}
		System.out.println("Starting the Elevator:");
		b1.start(1);
		System.out.println("Starting Logic 2");
		b2.start(2);
		
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
