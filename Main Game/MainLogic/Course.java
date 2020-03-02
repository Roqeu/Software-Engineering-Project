package MainLogic;
import java.util.ArrayList;
import java.util.List;

public class Course {
	private int ID;
	private String name;
	private boolean approved;
	private int requiredStaff;
	private int assignedStaff;
	private List<Integer> staffID;
	
	public Course(int ID, String name, boolean approved, int requiredStaff, int assignedStaff, List<Integer> staffID) {
		this.ID = ID;
		this.name = name;
		this.approved = approved;
		this.requiredStaff = requiredStaff;
		this.assignedStaff = assignedStaff;
		this.staffID = staffID;
	}
	
	public Course(int ID, String name, int requiredStaff) {
		this.ID = ID;
		this.name = name;
		this.requiredStaff = requiredStaff;
		this.assignedStaff = 0;
		this.staffID = new ArrayList<Integer>();
		
	}
	
	public boolean checkFull() {
		if (this.requiredStaff == this.assignedStaff) {
			return true;
		}
		
		return false;	
	}
	
	public void addStaff(Staff staff) {
		this.staffID.add(staff.getID());
		
	}
	
	public int getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Integer> getStaffID() {
		return staffID;
	}
	
	public int getRequiredStaff() {
		return requiredStaff;
	}
	
	public int getAssignedStaff() {
		return assignedStaff;
	}

	
	public void setRequirements(int requirements) {
		this.requiredStaff = requirements;
		
	}
	
	public int getRequirements() {
		return this.requiredStaff;
		
	}
	
	public boolean isApproved() {
		return approved;
		
	}
	
	public void setApproved(boolean approved) {
		this.approved = approved;
	}

}

