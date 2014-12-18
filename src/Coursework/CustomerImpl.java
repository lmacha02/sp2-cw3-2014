package Coursework;

/**
 * @author lmacha02
 *
 */

public class CustomerImpl implements Customer {
	
	private Boolean inElevator = false;
	private Boolean finished = false;
	private static int ID;
	private int start;
	private int destination;
	
	public CustomerImpl() {
		ID = ID++;
	}
	
	public void setStart(int start) {
		this.start = start;
	}

	public int getStart() {
		return start;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public int getDestination() {
		return destination;
	}

	public int getId() {
		return ID;
	}

	public void setFinished() {
		finished = true;
	}

	@Override
	public void setInElevator() {
		inElevator = true;
	}

	@Override
	public Boolean getInElevator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getFinished() {
		// TODO Auto-generated method stub
		return null;
	}

}
