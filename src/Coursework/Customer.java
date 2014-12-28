package Coursework;

/**
 * The Interface Customer.
 *
 * @author lmacha02
 */

public interface Customer {
	
	//variables should be private, declare them in class customer 
	
	/**
	 * Sets the start floor of the customer.
	 *
	 * @param start - starting floor
	 */
	public void setStart(int start);
	
	/**
	 * Gets the start floor of the customer.
	 *
	 * @return the start floor of the customer
	 */
	public int getStart();
	
	/**
	 * Sets the destination floor of the customer.
	 *
	 * @param destination the destination of the customer
	 */
	public void setDestination(int destination);
	
	/**
	 * Gets the destination floor.
	 *
	 * @return the destination floor of the customer
	 */
	public int getDestination();
	
	/**
	 * Gets the Customer id.
	 * Customer Id is incremental and will automatically increased for each new customer created.
	 *
	 * @return the Customer id
	 */
	public int getId();
	
	/**
	 * Sets a variable if the customer is in elevator.
	 *
	 * @param status TRUE if customer is in elevator, FALSE if outside.
	 */
	public void setInElevator(boolean status);
	
	/**
	 * Gets the in elevator flag.
	 *
	 * @return status of the customer, TRUE if in elevator, FALSE if outside.
	 */
	public Boolean getInElevator();
	
	/**
	 * Sets the finished flag for the customer.
	 */
	public void setFinished();
	
	/**
	 * Gets the finished flag status.
	 *
	 * @return the finished
	 */
	public Boolean getFinished();
	
	/**
	 * Gets the direction the customer is going to take.
	 * (1)  for UP
	 * (-1) for DOWN 
	 *
	 * @return the direction
	 */
	public int getDirection();
	
	/**
	 * Creates the Customer object and returns it.
	 *
	 * @return a new customer object.
	 */
	public static Customer create(){
		return CustomerImpl.create();
	};
	
	/**
	 * Sets the customer finished flag as false
	 */
	public void setUnfinished();
}
