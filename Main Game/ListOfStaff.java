
import java.util.ArrayList;

/**
 * Class to store list of staff
 * @author Andrew
 * 
 * Public methods:
 * 	public Staff find(int ID) 
 * 	public void createStaff(String name, int hours)
 * 	public ArrayList<Staff> findAvailableStaff()
 * 	public ArrayList<Staff> findUnavailableStaff()
 * 	public ArrayList<Staff> findUntrainedStaff()
 * 	public ArrayList<Staff> findTrainedStaff()
 * 	public ArrayList<Staff> getStaffList()
 *
 */
public class ListOfStaff {
	
	/**
	 * ArrayList for staff
	 */
	private ArrayList<Staff> staffList;
	
	
	/**
	 * Constructor
	 */
	public ListOfStaff(){
		this.staffList = new ArrayList<Staff>();
	}
	
	/**
	 * Method to find staff by ID
	 * @param ID staff ID
	 * @return staff object associated with ID, null if invalid IDS
	 */
	public Staff find(int ID) {
		
		for(Staff staff : staffList) {
			
			if(staff.getID() == ID) {
				return staff;
			}
		}
		
		return null;
	}
	
	/**
	 * Method to create new staff member
	 * @param name
	 * @param hours
	 */
	public void createStaff(String name) {
		
		/*
		 * Get next ID
		 * 
		 * Find most recent staff entry and increment by 1
		 */
		
		int nextID;
		
		if(this.staffList.size() > 0) {
			Staff mostRecent = this.staffList.get(this.staffList.size() - 1);
			nextID = mostRecent.getID() + 1;
		}
		else {
			nextID = 0;
		}
		
		
		// Add new staff member to list
		this.staffList.add(new Staff(name, nextID));
		
	}
	
	/**
	 * Method to find available staff
	 * @return ArrayList of available staff
	 */
	public ArrayList<Staff> findAvailableStaff() {
		
		ArrayList<Staff> availableStaff = new ArrayList<Staff>();
		
		for(Staff staff : staffList) {
			
			if(staff.isAvailable()) {
				availableStaff.add(staff);
			}
			
		}
		return availableStaff;
	}
	
	/**
	 * Method to find unavailable staff
	 * @return ArrayList of unavailable staff
	 */
	public ArrayList<Staff> findUnavailableStaff() {
		
		ArrayList<Staff> unavailableStaff = new ArrayList<Staff>();
		
		for(Staff staff : staffList) {
			
			if(!staff.isAvailable()) {
				unavailableStaff.add(staff);
			}
			
		}
		return unavailableStaff;
	}
	
	/**
	 * Method to find untrained staff
	 * @return ArrayList of untrained staff
	 */
	public ArrayList<Staff> findUntrainedStaff() {
		
		ArrayList<Staff> untrainedStaff = new ArrayList<Staff>();
		
		for(Staff staff : staffList) {
			
			if(!staff.isTrained()) {
				untrainedStaff.add(staff);
			}
		}
		return untrainedStaff;
	}
	
	/**
	 * Method to find trained staff
	 * @return ArrayList of trained staff
	 */
	public ArrayList<Staff> findTrainedStaff() {
		
		ArrayList<Staff> trainedStaff = new ArrayList<Staff>();
		
		for(Staff staff : staffList) {
			
			if(staff.isTrained()) {
				trainedStaff.add(staff);
			}
		}
		return trainedStaff;
	}
	
	/**
	 * Getter for staffList
	 * @return staffList
	 */
	public ArrayList<Staff> getStaffList() {
		return staffList;
	}
	
	

}
