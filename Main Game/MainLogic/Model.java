package MainLogic;
import java.util.ArrayList;

public class Model {
	
	/**
	 *  ArrayList for courses
	 */
	private ArrayList<Course> courseList;
	
	/**
	 * ArrayList for staff
	 */
	private ArrayList<Staff> staffList;
	
	/**
	 * next ID to be given to newly created staff member
	 */
	private int nextStaffID;
	
	/**
	 * next ID to be given to newly create course
	 */
	private int nextCourseID;
	
	public Model() {
		courseList = new ArrayList<Course>();
		staffList = new ArrayList<Staff>();
		
		/*
		 *  need to add population from FileIO
		 */
		
		/*
		 * Set next staff ID
		 */
		
		// set ID to most recent addition + 1
		if(!staffList.isEmpty()) {
			int currentID = staffList.get(staffList.size() - 1).getID();
			nextStaffID = currentID + 1;
		}
		// if empty, set to 0
		else {
			nextStaffID = 0;
		}
		
		/*
		 * Set next course ID
		 */
		
		// set ID to most recent addition + 1
		if(!courseList.isEmpty()) {
			int currentID = courseList.get(courseList.size() - 1).getID();
			nextCourseID = currentID + 1;
		}
		// if empty, set to 0
		else {
			nextCourseID = 0;
		}
	}
	
	
	/*
	 * ==================================================
	 * Methods for creating staff and using staffList
	 * ==================================================
	 */
	
	
	/**
	 * Method to add new staff member to staffList
	 * @param name staff member name
	 * @param hours number of hours available
	 */
	public void createStaff(String name, int hours) {
		this.staffList.add(new Staff(name, nextStaffID, hours));
		nextStaffID++;
	}
	
	/**
	 * Method to return all staff with remaining hours
	 * @return all staff with remaining hours
	 */
	public ArrayList<Staff> AvailableStaff(){
		ArrayList<Staff> availableStaff = new ArrayList<Staff>();
		
		for(Staff s : staffList) {
			if(s.hoursRemaining() > 0) {
				availableStaff.add(s);
			}
		}
		
		return availableStaff;
	}
	
	/**
	 * Method to return list of staff who are not trained for a given course
	 * @param course
	 * @return list of staff not trained for given course
	 */
	public ArrayList<Staff> UntrainedStaff(Course course){
		ArrayList<Staff> untrainedStaff = new ArrayList<Staff>();
		
		for(Staff s : staffList) {
			
			/*
			 * if staff member doesn't have training 
			 * for given course add to untrained staff
			 */
			if(!s.getTraining().contains(course.getID())) {
				untrainedStaff.add(s);
			}
		}
		
		return untrainedStaff;
	}
	
	/**
	 * Method to return list of staff who are trained for a given course
	 * @param course
	 * @return list of staff trained for given course
	 */
	public ArrayList<Staff> StaffWithTraining(Course course){
		ArrayList<Staff> trainedStaff = new ArrayList<Staff>();
		
		for(Staff s : staffList) {
			/*
			 * if staff member has training 
			 * for given course add to trained staff
			 */
			if(s.getTraining().contains(course.getID())) {
				trainedStaff.add(s);
			}
		}
		
		return trainedStaff;
	}
	
	/*
	 * ====================================================
	 * Methods for creating courses and using courseList
	 * ====================================================
	 */
	
	
	/**
	 * Create new course
	 * @param name course name
	 */
	public void  createCourse(String name) {
		 courseList.add(new Course(name, nextCourseID));
		 nextCourseID++;
	}
	
	/**
	 * Method to add staff to course
	 * 
	 * Need to add checks for hours etc ?????????????????????
	 * @param course
	 * @param staff
	 */
	public void addStaffToCourse(Course course, Staff staff) {
		course.addStaff(staff);
	}
	
	/**
	 * Method to add training for 
	 * given course to given staff
	 * @param course
	 * @param staff
	 */
	public void train(Course course, Staff staff) {
		staff.addTraining(course.getID());
	}
	
	/**
	 * Set approval 
	 * @param course
	 */
	public void setRequestApproval(Course course, boolean approval) {
		course.setApproved(approval);
	}


	public ArrayList<Course> getCourseList() {
		return courseList;
	}


	public ArrayList<Staff> getStaffList() {
		return staffList;
	}
	
	
	
}
