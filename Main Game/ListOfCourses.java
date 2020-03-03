
import java.util.ArrayList;

/**
 * Class to store list of courses
 * @author Andrew
 *
 * Public methods:
 *  public Course find(int ID)
 *  public void createCourse(String name)
 *  public ArrayList<Course> findUnapprovedCourses()
 *  public void addStaffToCourse(Course course, Staff staff)
 *  public void removeStaffFromCourse(Course course, Staff staff)
 *  public void assignCourseRequirements(Course course, int req)
 *  public void giveRequestApproval(Course course, boolean approval)
 *  public void train(Course course, Staff staff)
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
			nextID = 0;
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
	 * Method to add staff to course
	 * @param course
	 * @param staff
	 */
	public void addStaffToCourse(Course course, Staff staff) {
		
		course.addStaff(staff);
		
	}
	
	/**
	 * Method to remove staff member from course
	 * @param course
	 * @param staff
	 */
	public void removeStaffFromCourse(Course course, Staff staff) {
		
		course.removeStaff(staff);

	}
	
	/**
	 * Method to assign number of staff required by course
	 * @param course
	 * @param req number of staff required
	 */
	public void assignCourseRequirements(Course course, int req) {
		
		course.setRequirements(req);
		
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
		
	}
	
	/**
	 * Getter for courseList
	 * @return courseList
	 */
	public ArrayList<Course> getCourseList() {
		return courseList;
	}
	
	
	
	
	
}
