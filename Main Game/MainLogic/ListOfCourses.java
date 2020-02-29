package MainLogic;

import java.util.ArrayList;

/**
 * Class to store list of courses
 * @author Andrew
 *
 * Public methods:
 *  public Course find(int ID)
 *  public void createCourse(String name)
 *  public void addStaffToCourse(Course course, Staff staff)
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
	public void createCourse(String name) {
		
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
		this.courseList.add(new Course(name, nextID));
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
	 * Method to train staff member
	 * @param course 
	 * @param staff
	 */
	public void train(Course course, Staff staff) {
		
		/*
		 * !!!!!!
		 * Add call to course to add training
		 * !!!!!!
		 */
		
	}
	/**
	 * Getter for courseList
	 * @return courseList
	 */
	public ArrayList<Course> getCourseList() {
		return courseList;
	}
	
	
	
	
	
}
