package MainLogic;
import java.util.ArrayList;

/**
 * Model class for teaching requirements program
 * @author Andrew
 * 
 * Public Methods:
 * 	public void createStaff(String name, int hours)
 * 	public ArrayList<Staff> AvailableStaff()
 * 	public ArrayList<Staff> UntrainedStaff()
 * 	public ArrayList<Staff> StaffWithTraining()
 * 	public void  createCourse(String name)
 * 	public void addStaffToCourse(Course course, Staff staff)
 * 	public void train(Course course, Staff staff)
 * 	public void giveRequestApproval(Course course, boolean approval)
 *
 */
public class Model {
	
	/**
	 *  ArrayList for courses
	 */
	private ListOfCourses courseList;
	
	/**
	 * ArrayList for staff
	 */
	private ListOfStaff staffList;
	


	/**
	 * Constructor
	 */
	public Model() {
		courseList = new ListOfCourses();
		staffList = new ListOfStaff();
		
		/*
		 *  need to add population from FileIO
		 */

	}
	
	/*
	 * ==================================================
	 * Methods for creating staff and using staffList
	 * ==================================================
	 */
	
	
	/**
	 * Method to get ArrayList of all staff
	 * @return staffList from within this.staffList object
	 */
	public ArrayList<Staff> returnStaffList(){
		return this.staffList.getStaffList();
	}
	
	/**
	 * Method to find staff for given ID
	 * @param ID staff ID
	 * @return staff member
	 */
	public Staff findStaff(int ID) {
		return this.staffList.find(ID);
	}
	
	/**
	 * Method to add new staff member to staffList
	 * @param name staff member name
	 * @param hours number of hours available
	 */
	public void createStaff(String name, int hours) {
		
		this.staffList.createStaff(name, hours);
		
	}
	
	/**
	 * Method to return all staff available to be assigned
	 * @return all staff with remaining hours
	 */
	public ArrayList<Staff> AvailableStaff(){
		
		return staffList.findAvailableStaff();
	}
	
	/**
	 * Method to return list of staff who are not trained
	 * @return list of trained staff
	 */
	public ArrayList<Staff> UntrainedStaff(){
				
		return staffList.findUntrainedStaff();
	}
	
	/**
	 * Method to return list of staff who are trained
	 * @return list of trained staff
	 */
	public ArrayList<Staff> StaffWithTraining(){
		
		return staffList.findTrainedStaff();
	}
	
	/*
	 * ====================================================
	 * Methods for creating courses and using courseList
	 * ====================================================
	 */
	
	/**
	 * Method to get ArrayList of all courses
	 * @return courseList from within this.courseList object
	 */
	public ArrayList<Course> returnCourseList() {
		return this.courseList.getCourseList();
	}
	
	/**
	 * Create new course
	 * @param name course name
	 */
	public void  createCourse(String name) {
		
		courseList.createCourse(name);
		
	}
	
	/**
	 * Method to find course for given ID
	 * @param ID course ID
	 * @return
	 */
	public Course findCourse(int ID) {
		return this.courseList.find(ID);
	}
	
	/**
	 * Method to add staff to course
	 * @param course
	 * @param staff
	 */
	public void addStaffToCourse(Course course, Staff staff) {
		
		courseList.addStaffToCourse(course, staff);
		
	}

	/**
	 * Method to add training for 
	 * given course to given staff
	 * @param course
	 * @param staff
	 */
	public void train(Course course, Staff staff) {
		courseList.train(course, staff);
	}
	
	/**
	 * Set approval 
	 * @param course
	 */
	public void giveRequestApproval(Course course, boolean approval) {
		course.setApproved(approval);
	}



	
	
	
}
