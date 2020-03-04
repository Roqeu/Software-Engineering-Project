
import java.util.ArrayList;

/**
 * Class to store list of courses
 * @author Andrew
 *
 * Public methods:
 *  public Course find(int ID)
 *  public void createCourse(String name, int requiredStaff)
 *  public ArrayList<Course> findApprovedCourses()
 *  public ArrayList<Course> findUnapprovedCourses()
 *  public ArrayList<Course> findFullCourses()
 *  public ArrayList<Staff> findCourseStaff(Course course, ListOfStaff staffList)
 *  public void addStaffToCourse(Course course, Staff staff)
 *  public void removeStaffFromCourse(Course course, Staff staff)
 *  public boolean assignCourseRequirements(Course course, int req)
 *  public void giveRequestApproval(Course course, boolean approval)
 *  public void train(Staff staff)
 *  public ArrayList<Course> getCourseList()
 */
public class ListOfCourses {
	
	/**
	 * ArrayList of courses
	 */
	private ArrayList<Course> courseList;
	
	/**
	 * Constructor
	 */
	public ListOfCourses() {
		this.courseList = new ArrayList<Course>();
	}
	
	/**
	 * Method to find course by ID
	 * @param ID course ID
	 * @return course object associated with ID, null if invalid
	 */
	public Course find(int ID) {
		
		for(Course course : courseList) {
			
			if(course.getID() == ID) {
				return course;
			}	
		}
		
		return null;
	}
	
	/**
	 * Method to add new course to courseList
	 * @param name Course name
	 */
	public void createCourse(String name, int requiredStaff) {
		
		/*
		 * Get next ID
		 * 
		 * Find most recent course entry ID and increment by 1
		 *  
		 */
		
		int nextID;
		
		if(this.courseList.size() > 0) {
			Course mostRecent = this.courseList.get(this.courseList.size() - 1);
			nextID = mostRecent.getID() + 1;
		}
		else {
			// start from 1
			nextID = 1;
		}
		
		// Add new course to list
		this.courseList.add(new Course(nextID, name, requiredStaff));
	}
	
	/**
	 * Method to return ArrayList of approved courses
	 * @return ArrayList of approved courses
	 */
	public ArrayList<Course> findApprovedCourses(){
		
		ArrayList<Course> approvedCourses = new ArrayList<Course>();
		
		for(Course course : this.courseList) {
			if(course.isApproved()) {
				approvedCourses.add(course);
			}
		}
		
		return approvedCourses;
	}
	
	/**
	 * Method to return ArrayList of unapproved courses
	 * @return ArrayList of unapproved courses
	 */
	public ArrayList<Course> findUnapprovedCourses(){
		
		ArrayList<Course> unapprovedCourses = new ArrayList<Course>();
		
		for(Course course : this.courseList) {
			if(!course.isApproved()) {
				unapprovedCourses.add(course);
			}
		}
		
		return unapprovedCourses;
	}
	
	/**
	 * Method to return ArrayList of full courses
	 * that are not approved
	 * @return ArrayList of full courses
	 */
	public ArrayList<Course> findFullCourses(){
		
		ArrayList<Course> fullCourses = new ArrayList<Course>();
		
		for(Course course : this.courseList) {
			if(course.checkFull() && (!course.isApproved())) {
				fullCourses.add(course);
			}
		}
		
		return fullCourses;
	}
	
	/**
	 * Method to return ArrayList of staff on a given course
	 * @param course
	 * @param staffList global stafflist
	 * @return
	 */
	public ArrayList<Staff> findCourseStaff(Course course, ListOfStaff staffList){
		
		ArrayList<Staff> courseStaff = new ArrayList<Staff>();
		
		for(int id : course.getStaffID()) {

			courseStaff.add(staffList.find(id));

		}
		
		return courseStaff;
	}
	
	/**
	 * Method to add staff to course
	 * @param course
	 * @param staff
	 */
	public void addStaffToCourse(Course course, Staff staff) {
		
		course.addStaff(staff);
		staff.setAvailable(false);
	}
	
	/**
	 * Method to remove staff member from course
	 * @param course
	 * @param staff
	 */
	public void removeStaffFromCourse(Course course, Staff staff) {
		
		course.removeStaff(staff);
		staff.setAvailable(true);

	}
	
	/**
	 * Method to assign number of staff required by course
	 * @param course
	 * @param req number of staff required
	 */
	public boolean assignCourseRequirements(Course course, int req) {
		
		return course.changeRequirements(req);
		
	}
	
	/**
	 * Set approval 
	 * @param course
	 */
	public void giveRequestApproval(Course course, boolean approval) {
		course.setApproved(approval);
	}
	
	/**
	 * Method to train staff member
	 * @param course 
	 * @param staff
	 */
	public void train(Staff staff) {
		
		staff.setTrained(true);
		staff.setAvailable(true);
		
	}
	
	/**
	 * Getter for courseList
	 * @return courseList
	 */
	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}
	
	
	
	
	
	
}
