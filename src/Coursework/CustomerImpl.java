package Coursework;

/**
 * The Class CustomerImpl.
 * Implements Customer
 *
 * @author lmacha02
 */

public class CustomerImpl implements Customer {
	
	/** The in elevator. */
	private Boolean inElevator = false;
	
	/** The finished. */
	private Boolean finished = false;
	
	/** The counter. */
	private static int COUNTER = 0;
	
	/** The id. */
	private int ID = ++COUNTER;
	
	/** The start. */
	private int start;
	
	/** The destination. */
	private int destination;
	

	/* (non-Javadoc)
	 * @see Coursework.Customer#setStart(int)
	 */
	public void setStart(int start) {
		if(start == 13){
			System.out.println("Customer "+this.getId()+" on non-existent floor!");
			start=0;
		}
		this.start = start;
	}

	/* (non-Javadoc)
	 * @see Coursework.Customer#getStart()
	 */
	public int getStart() {
		return start;
	}

	/* (non-Javadoc)
	 * @see Coursework.Customer#setDestination(int)
	 */
	public void setDestination(int destination) {
		if(destination == 13){
			System.out.println("Customer "+this.getId()+" destination to non-existent floor!");
			destination=0;
		}
		this.destination = destination;
	}

	/* (non-Javadoc)
	 * @see Coursework.Customer#getDestination()
	 */
	public int getDestination() {
		return destination;
	}

	/* (non-Javadoc)
	 * @see Coursework.Customer#getId()
	 */
	public int getId() {
		return this.ID;
	}

	/* (non-Javadoc)
	 * @see Coursework.Customer#setFinished()
	 */
	public void setFinished() {
		this.finished = true;
	}
	
	/* (non-Javadoc)
	 * @see Coursework.Customer#getFinished()
	 */
	public Boolean getFinished() {
		return this.finished;
	}

	/* (non-Javadoc)
	 * @see Coursework.Customer#setInElevator(boolean)
	 */
	public void setInElevator(boolean status) {
		this.inElevator = status;
	}

	/* (non-Javadoc)
	 * @see Coursework.Customer#getInElevator()
	 */
	public Boolean getInElevator() {
		return this.inElevator;
	}

	/* (non-Javadoc)
	 * @see Coursework.Customer#getDirection()
	 */
	@Override
	public int getDirection() {
		if(this.start<this.destination && !this.getFinished()) return 1;
		if(this.start>this.destination && !this.getFinished()) return -1;
		this.setFinished();
		return 0;
	}
	
	/**
	 * Creates the Customer Object
	 *
	 * @return customer object
	 */
	public static Customer create() {
		return new CustomerImpl();
	}
}