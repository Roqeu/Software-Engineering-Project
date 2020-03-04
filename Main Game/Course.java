package MainLogic;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for course creation/methods
 * @author Rebecca
 * 
 * Public methods;
 * public boolean checkFull
 *public void addStaff (Staff staff)
 *public void removeStaff (Staff staff)
 *public boolean changeRequirements (int newReq)
 *public int getID
 *public String getName
 *private List<Integer> getStaffID
 *private int getRequiredStaff
 *private int getAssignedStaff
 *public void setRequirements(int requirements)
 *public boolean isApproved
 *public void setApproved(boolean approved)
 */

public class Course {
	private int ID; //course ID
	private String name; //course name
	private boolean approved;//course approved
	private int requiredStaff; //staff required for course 
	private int assignedStaff;//staff assigned to course
	private List<Integer> staffID;//List of staff ID's
	
	/**
	 * Constructor for courses which passed to courseToFile method in writeToFile class
	 */
	
	public Course(int ID, String name, boolean approved, int requiredStaff, int assignedStaff, List<Integer> staffID) {
		this.ID = ID; //course ID
		this.name = name; //course name
		this.approved = approved; //course approved
		this.requiredStaff = requiredStaff; //staff required for course
		this.assignedStaff = assignedStaff; //staff assigned to course
		this.staffID = staffID; //staff ID
	}
	
	/**
	 * Constructor
	 */
	
	public Course(int ID, String name, int requiredStaff) { 
		this.ID = ID; //course ID
		this.name = name; //course name
		this.requiredStaff = requiredStaff; //staff required for course
		this.assignedStaff = 0; // staff assigned to course
		this.staffID = new ArrayList<Integer>(); //ArrayList of staffIDs created when Course object created
		
	}
	
	/**
	 * Method to find check if course full
	 * @return true if course full, false if not
	 */
	
	public boolean checkFull() {
		if (this.requiredStaff == this.assignedStaff) {
			return true;
		}
		
		return false;	
	}
	
	/**
	 * Method to add staff to course
	 * @param staff
	 */
	
	public void addStaff(Staff staff) {
		this.staffID.add(staff.getID());
		
	}
	
	/**
	 * Method to remove staff from course
	 * @param staff
	 *If staff 
	 */
	
	public void removeStaff(Staff staff) {
		
		for (int i=0;i<staffID.size();i++) {

			if (staffID.get(i) == staff.getID()) {
				
				this.staffID.remove(i);
			}
		}
		
	}
	
	/**
	 * Method to change required staff if new requirements added to course
	 * @param newReq
	 * @return false if assigned staff greater than new requirements, else set required staff to new requirements and return true
	 */
	
	public boolean changeRequirements(int newReq) {
			
			if (this.assignedStaff > newReq ) {
				
				return false;
			}else {
				
				this.requiredStaff = newReq;
				
				return true;
			}	
	}
	/**
	 * Method to get course ID
	 * @return course ID
	 */
	
	public int getID() {
		return ID;
	}
	
	/**
	 * Method to get course name
	 * @return course name
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Method to get list of staff ID's
	 * @return list of staff ID's
	 */
	
	public List<Integer> getStaffID() {
		return staffID;
	}
	
	/**
	 * Method to get required staff
	 * @return required staff
	 */
	
	public int getRequiredStaff() {
		return requiredStaff;
	}
	
	/**
	 * Method to get assigned staff
	 * @return assigned staff
	 */
	
	public int getAssignedStaff() {
		return assignedStaff;
	}
	
	/**
	 * Method to set requirements
	 * @param requirements
	 * @return requirements
	 */

	
	public void setRequirements(int requirements) {
		this.requiredStaff = requirements;
		
	}
	
	/**
	 * Method to get requirements
	 * @return required staff
	 */
	
	public int getRequirements() {
		return this.requiredStaff;
		
	}
	
	/**
	 * Method to approve course
	 * @return approved (true/false)
	 */
	public boolean isApproved() {
		return approved;
		
	}
	

	/**
	 * Method to set approved status
	 * @param approved
	 */
	
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
		
		
	}
	



