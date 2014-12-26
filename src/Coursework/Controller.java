package Coursework;
import java.util.Random;
import java.util.Scanner;


public class Controller {
	public static void main(String[] args) {
		//create building and elevators

		int inFloors = getPositiveInteger("Set number of floors:");

		int inCustomer = getPositiveInteger("Set number of customers:");
		
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
				
			} else {
				System.out.print("A positive integer please! ");
				in.next();
			}
			
		}while(temp < 1);

		return temp;
		
	}
	
	
}
