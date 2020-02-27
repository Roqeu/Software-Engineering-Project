package MainLogic;
import java.util.ArrayList;

public class Staff {
	
	/*
	 * Staff member attributes
	 */
	
	// Staff member name
	private String name;
	
	// unique ID
	private int ID;
	
	// total hours staff member can work
	private int availableHours;
	
	// hours currently assigned to staff member
	private int hoursBooked;
	
	
	// list of training course IDs staff member has attended
	private ArrayList<Integer> training;
	
	public Staff(String name, int ID, int hours) {
		this.name = name;
		this.ID = ID;
		this.availableHours = hours;
		this.hoursBooked = 0;
		this.training = new ArrayList<Integer>();
	}
	
	/**
	 * Method to calculate remaining hours staff member 
	 * can be assigned
	 * @return remaining hours
	 */
	public int hoursRemaining() {
		return (availableHours - hoursBooked);
	}
	
	/**
	 * Method to add a training course to this staff member
	 * @param ID training course ID
	 */
	public void addTraining(int ID) {
		training.add(ID);
	}
	
	public String toString() {
		String output = "";
		output += "StaffID: " + this.ID + "\t";
		output += "Name: " + this.name + "\t";
		output += "Available hours: " + this.availableHours + "\t";
		output += "Hours booked: " + this.hoursBooked;
		
		return output;
	}
	
	/*
	 * Getters
	 */
	
	public ArrayList<Integer> getTraining() {
		return training;
	}

	public int getID() {
		return ID;
	}
	
	
	
	
}
