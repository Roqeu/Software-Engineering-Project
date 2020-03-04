
import java.util.ArrayList;

/**
 * Model class for teaching requirements program
 * @author Andrew
 * 
 * Public Methods:
 * 	public ArrayList<Staff> returnStaffList()
 * 	public Staff findStaff(int ID)
 * 	public void createStaff(String name, int hours)
 * 	public ArrayList<Staff> AvailableStaff()
 * 	public ArrayList<Staff> UnavailableStaff()
 * 	public ArrayList<Staff> UntrainedStaff()
 * 	public ArrayList<Staff> StaffWithTraining()
 * 	public ArrayList<Course> returnCourseList()
 * 	public void  createCourse(String name, int requiredHours) 
 * 	public Course findCourse(int ID)
 * 	public ArrayList<Course> findApprovedCourses()
 * 	public ArrayList<Course> findUnapprovedCourses()
 * 	public ArrayList<Course> findFullCourses()
 * 	public void addStaffToCourse(Course course, Staff staff)
 * 	public void removeStaffFromCourse(Course course, Staff staff)
 * 	public boolean assignCourseRequirements(Course course, int req)
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
	public void createStaff(String name) {
		
		this.staffList.createStaff(name);
		
	}
	
	/**
	 * Method to return all staff available to be assigned
	 * @return all available staff
	 */
	public ArrayList<Staff> AvailableStaff(){
		
		return staffList.findAvailableStaff();
	}
	
	/**
	 * Method to return all staff unavailable to be assigned
	 * @return all unavailable staff
	 */
	public ArrayList<Staff> UnavailableStaff(){
		
		return staffList.findUnavailableStaff();
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
	public void  createCourse(String name, int requiredHours) {
		
		courseList.createCourse(name, requiredHours);
		
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
	 * Method to return ArrayList of approved courses
	 * @return ArrayList of approved courses
	 */
	public ArrayList<Course> findApprovedCourses(){
		return this.courseList.findApprovedCourses();
	}
	
	/**
	 * Method to return ArrayList of unapproved courses
	 * @return ArrayList of unapproved courses
	 */
	public ArrayList<Course> findUnapprovedCourses(){
		return this.courseList.findUnapprovedCourses();
	}
	
	/**
	 * Method to return ArrayList of full courses
	 * @return ArrayList of full courses
	 */
	public ArrayList<Course> findFullCourses(){
		return this.courseList.findFullCourses();
	}
	
	/**
	 * Method to return ArrayList of staff on a given course
	 * @param course
	 * @return
	 */
	public ArrayList<Staff> findCourseStaff(Course course){
		
		return this.courseList.findCourseStaff(course, this.staffList);
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
	 * Method to remove staff member from course
	 * @param course
	 * @param staff
	 */
	public void removeStaffFromCourse(Course course, Staff staff) {
		
		courseList.removeStaffFromCourse(course, staff);
	}
	
	
	/**
	 * Method to assign number of staff required by course
	 * @param course
	 * @param req number of staff required
	 */
	public boolean assignCourseRequirements(Course course, int req) {

		return this.courseList.assignCourseRequirements(course, req);
		
	}
	
	
	/**
	 * Method to add training for 
	 * given course to given staff
	 * @param course
	 * @param staff
	 */
	public void train(Staff staff) {
		courseList.train(staff);
	}
	
	/**
	 * Set approval 
	 * @param course
	 */
	public void giveRequestApproval(Course course, boolean approval) {
		this.courseList.giveRequestApproval(course, approval);
	}

	
}
