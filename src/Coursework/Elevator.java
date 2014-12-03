/**
 * 
 */
package Coursework;


/**
 * @author christianheiler
 *
 */
public interface Elevator {
	int currentFloor = 0;
	int NUM_OF_FLOORS = 0;
	
	public void setFloors(int floors);
	public int getFloors();
	
	
	/* move elevator
	 * @param direction use 1 to move one level up, use -1 to move one level down.
	 */
	public void move(int direction);
	
	public int getCurrentFloor();
	
	public Array registerList();
	
	
}
