package MainLogic;

/**
 * Class 
 * @author Rebecca
 *
 *public int getID
 *public void setID(int iD)
 *public String getName
 *public void setName(String name)
 *public boolean isAvailable
 *public void setAvailable(boolean available)
 *public boolean isTrained
 *public void setTrained(boolean trained) 
 *public String toString
 */

public class Staff {
	
	private int ID; // staff ID
	private String name; //staff name
	private boolean available; //staff available
	private boolean trained;//staff trained
	
	/**
	 * Constructor for staff 
	 */
	
	public Staff(String name, int ID) {
		this.name = name;
		this.ID = ID;
		this.available = false;
		this.trained = false;
	}
	

	/**
	 * Constructor for staff which passed to staffToFile method in writeToFile class
	 */
	
	public Staff(String name,int ID, boolean available, boolean trained) {
		this.name = name;
		this.ID = ID;
		this.available = available;
		this.trained = trained;
	}
	
	/**
	 * Method to get staff ID
	 * @return staff ID
	 */

	public int getID() {
		return ID;
	}
	
	/**
	 * Method to set ID
	 * @param iD
	 */

	public void setID(int iD) {
		ID = iD;
	}
	
	/**
	 * Method to get staff name
	 * @return staff name
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * Method to set staff name
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Method to set if staff available
	 * @return true if available, false if not
	 */

	public boolean isAvailable() {
		return available;
	}
	
	/**
	 * Method to set staff availability
	 * @param available
	 */

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	/**
	 * Method to check whether staff trained
	 * @return trained true, untrained false
	 */

	public boolean isTrained() {
		return trained;
	}
	
	/**
	 * Method to set whether staff trained
	 * @param trained
	 */

	public void setTrained(boolean trained) {
		this.trained = trained;
	}
	
	/**
	 * Method to format printing of staff objects
	 * @return string formatted staff objects
	 */

	public String toString() {
		String output = "";
		output += "StaffID: " + this.ID + "\t";
		output += "Name: " + this.name + "\t";
		output += "Available: " + this.available + "\t";
		
		return output;
	}

	
	
	
}
