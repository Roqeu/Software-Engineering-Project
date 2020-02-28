package MainLogic;
import java.util.ArrayList;

public class Course {
	
	/*
	 * Course attributes
	 */
	
	// unique ID
	private int ID;
	
	// Course name
	private String name;
	
	// List of staff working on this course
	private ArrayList<Staff> staff;
	
	// WHether course has been approved by PTT director
	private boolean approved;
	
	public Course(String name, int ID) {
		this.ID = ID;
		this.name = name;
		this.staff = new ArrayList<Staff>();
		this.approved = false;
	}
	
	/**
	 * Method to add staff to staff list working on this course
	 * @param staff staff member to be added
	 */
	public void addStaff(Staff staff) {
		this.staff.add(staff);
	}

	
	public String toString() {
		String output = "";
		output += "Course: " + this.name + "\n";
		output += "Approved: " + this.approved + "\n";
		output += "Staff:\n";
		for(Staff staff : staff) {
			output +=  staff + "\n";
		}
		
		return output;
	}
	
	/*
	 * Getters and setters
	 */
	
	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Staff> getStaff() {
		return staff;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
}
