package MainLogic;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.scenario.effect.Blend.Mode;

public class Controller {

	// Stores model
	private static Model model;
	// Stores view
	private static View view;
	// Initialises Scanner to listen for input
	private static Scanner userInput = new Scanner(System.in);
	
	/**
	 * Constructor
	 */
	public Controller(Model m, View v) {
		
		// Initialises view and model
		model = m;
		view = v;
	}
	
	/**
	 * Prompts user to select what level of access they want
	 * @return int 
	 */
	public int selectUser() {
		
		// Stores user input
		int selected = userInput.nextInt();
				
		// If user does not select a valid input
		// ask for a valid input and store input
		while(selected > 0 && selected < 4) {
			
			// Warns user of invalid input
			view.incorrectInput();
			
			// Stores new input
			selected = userInput.nextInt();
		}
				
		return selected;
	}
	
	/**
	 * Shows course director the available options and responds to input
	 * Will display courses that the director can assign requirements to
	 */
	public boolean courseDirectorOptions() {
		
		// Stores user input
		int selected = userInput.nextInt();
		
		// Stores list of courses
		ArrayList<Course> courseList = model.getCourseList();
		
		// Displays course director options
		view.displayCourses(courseList);
		
		// Will keep asking for input until valid input received
		while(selected >= 0 && selected <= courseList.size()) {
			
			// Displays wrong input message
			view.incorrectInput();
			// Displays choices
			view.displayCourses(courseList);
			
			// Stores user input
			selected = userInput.nextInt();
		}
		
		// If user has not selected return to main menu assign requirements
		if(selected != 0) {
			
			assignRequirements();
			
			// If user has selected to return to main menu, return to main menu
		} else if(selected == 0) {
			
			return false;
		}
		
		return true;
	}
	
	/**
	 * Shows administrator the available options and responds to input
	 * Will show staff members 
	 * Will show teaching requirements which can be selected to be filled
	 * Will allow creation of new staff 
	 * Will allow training to be assigned
	 */
	public boolean adminOptions() {
		
		// Boolean representing exit to user selection 
		// if false will repeat adminOptions()
		boolean exit = false;
		
		// Shows administrator options
		view.adminOptions();
		
		// Stores user selection
		int selected = userInput.nextInt();
		
		while(userInput < 0 && userInput > 4) {
			
			// Displays wrong input message
			view.incorrectInput();
			// Displays choices
			view.adminOptions();
			
			selected = userInput.nextInt();
		}
		
		switch(selected) {
		
			// If 0 selected return to user selection
			case 0:
				exit = true;
			// If 1 selected display staff
			case 1:
				view.displayStaff(model.getStaffList());
			// If 2 selected enter course assignment menu
			case 2:
				exit = fillRequirements(model.findRequirements());
			// If 3 selected enter add staff menu
			case 3:
				exit = createNewStaffMember();
			// If 4 selected show untrained staff
			case 4:
				view.displayUntrainedStaff(model.findUntrainedStaff());
		}
		
		return exit;
	}
	
	/**
	 * Shows PTT Director the available options and responds to input
	 * Will allow to the director to approve teaching requests
	 */
	public boolean pttDirectorOptions() {
		
		
	}
	
	/**
	 * Allows course director to assign requirements to a given course
	 * @return boolean
	 */
	private static boolean assignRequirements() {
		
	}
	
	/**
	 * Allows administrator to create new staff members
	 * @return boolean
	 */
	private static boolean createNewStaffMember() {
		
		view.createStaff();
		
		// Stores staff member name
		String name = userInput.nextLine();
		
		// Calls model to create staff member
		model.createNewStaff(name);
	}
	
	/**
	 * Allows admin to view course requirements and add or remove staff
	 * @param ArrayList<Course>
	 * @return boolean
	 */
	private static boolean fillRequirements(ArrayList<Course> requirements) {
		
		// Displays list of courses
		view.displayCourses(requirements);
		
		// Stores user selection
		int selected = userInput.nextInt();
		
		// If user wants to return to admin options, return
		if(selected == 0) {
			
			return false;
		}
		
		// Loops until valid input is selected
		while(selected > 0 && selected < requirements.size()) {
			
			// Displays wrong input message
			view.incorrectInput();
			// Displays courses
			view.displayCourses(requirements);
			// Stores user input
			selected = userInput.nextInt();
		}
	}
	
	/**
	 * Allows administrator to assign staff to a course
	 * @return boolean
	 */
	private static boolean assignStaff(Course course) {
		
		// Stores available staff
		ArrayList<Staff> availableStaff = model.findAvailableStaff();
		
		// Shows available staff to assign
		view.displayStaff(availableStaff);
		
		// Stores user input
		int selected = userInput.nextInt();
		
		// If user selects to exit return false
		if(selected == 0) {
			
			return false;
		}
		
		// Loops until valid input is selected
		while(selected > 0 && selected < availableStaff.size()) {
				
			// Displays wrong input message
			view.incorrectInput();
			// Displays courses
			view.displayStaff(availableStaff);
			// Stores user input
			selected = userInput.nextInt();
		}
		
		// Adds selected staff member to course
		model.addStaffToCourse(course, availableStaff.get(selected - 1));
		
		return true;
	}

	
	/**
	 * Allows administrator to remove staff member from course
	 * @return boolean
	 */
	private static boolean removeStaff(Course course) {
		
		
	}
	
	/**
	 * Allows any user to return to the main choices menu
	 * @return int 1 - make more changes, 2 - quit, 3 - return to main menu
	 */
	public int makeAnotherChoice() {
		
		
	}
}
