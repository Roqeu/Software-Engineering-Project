import java.util.ArrayList;
import java.util.Scanner;

/**
 * Controller class for teaching requirements program
 * @author Aaron Callaghan
 *
 * Public methods:
 * 	public void Controller(Model m, View v) <br>
 * 	public int selectUser() <br>
 * 	public boolean courseDirectorOptions() <br>
 * 	public boolean adminOptions() <br> 
 * 	public boolean pttDirectorOptions() <br>
 * 	public void exit()
 * 
 */
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
		 
		// Displays user selection screen
		view.selectUser();
		// Stores user input
		int selected = userInput.nextInt();
				
		// If user does not select a valid input
		// ask for a valid input and store input
		while(selected < 0 || selected > 4) {
			
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
		
		// Displays course director options
		view.courseDirectorOptions();
		
		// Stores user input
		int selected = userInput.nextInt();
		
		// Will keep asking for input until valid input received
		while(selected < 0 || selected > 2) {
			
			// Displays wrong input message
			view.incorrectInput();
			// Displays course director options
			view.courseDirectorOptions();
			
			// Stores user input
			selected = userInput.nextInt();
		}
		
		// Responds to user input
		switch(selected) {
		
		// If user has selected to return to user selection return false
		case 0:
			
			return true;
		// If 1 enter unapproved course menu (allows change of requirement)
		case 1:
			
			unapprovedCourses();
			break;
		// If 2 create courses
		case 2:
			
			createCourse();
			break;
		}
		
		// Return to Course Director menu
		return false;
	}
	
	/**
	 * Shows administrator the available options and responds to input
	 * Will show staff members 
	 * Will show teaching requirements which can be selected to be filled
	 * Will allow creation of new staff 
	 * Will allow training to be assigned
	 */
	public boolean adminOptions() {
		
		// Shows administrator options
		view.adminOptions();
		
		// Stores user selection
		int selected = userInput.nextInt();
		
		while(selected < 0 || selected > 4) {
			
			// Displays wrong input message
			view.incorrectInput();
			// Displays choices
			view.adminOptions();
			
			selected = userInput.nextInt();
		}
		
		
		// Responds to user input
		switch(selected) {
		// If 0 selected return to user selection
		case 0:
			
			return true;
		// If 1 selected display staff
		case 1:
			
			staffViewMenu();
			break;
		// If 2 enter course assignment menu
		case 2:
			
			fillRequirements(model.findUnapprovedCourses());
			break;
		// If 3 enter add staff menu
		case 3:
			
			createNewStaffMember();
			break;
		// If 4 show untrained staff
		case 4:
			
			train();
			break;
		}
		
		return false;
	}
	
	/**
	 * Shows PTT Director the available options and responds to input
	 * Will allow to the director to approve teaching requests
	 */
	public boolean pttDirectorOptions() {
		
		// Displays ptt director options
		view.pttDirectorOptions();
		
		// Stores user input
		int selected = userInput.nextInt();
		
		// Loops until user input is valid
		while(selected < 0 || selected > 2) {
			
			// Displays wrong input message
			view.incorrectInput();
			// Displays course director options
			view.pttDirectorOptions();
			// Stores user input
			selected = userInput.nextInt();
		}
		
		// Responds to user input
		switch(selected) {
		// If user chooses to exit, return false
		case 0:
			
			return true;
		// If 1 enter approve course menu
		case  1:
			
			approveCourse();
			break;
		// If 2 enter unapprove course menu 
		case 2:
			
			unapproveCourse();	
			break;
		}
		
		return false;
	}
	
	/**
	 * Shows courses without requirements and allows user to add requirements
	 */
	private static void unapprovedCourses() {
		
		// Stores courses without requirements
		ArrayList<Course> courses = model.findUnapprovedCourses();
		// Displays courses
		view.displayCourses(courses);
		// Stores user input
		int selected = userInput.nextInt();
		
		// Loops until valid input is selected
		while(selected < 0 || selected > courses.size()) {
					
			// Displays wrong input message
			view.incorrectInput();
			// Displays courses
			view.displayCourses(courses);
			// Stores user input
			selected = userInput.nextInt();
		}
		
		// If user chooses to exit, return false
		if(selected == 0 ) {
			
			return;
		}
		
		// Allows user to assign course requirements
		assignRequirements(courses.get(selected -1));
	}
	/**
	 * Allows course director to assign requirements to a given course
	 */
	private static void assignRequirements(Course course) {
		
		// Displays assign requirements message
		view.askRequirement();
		
		// Stores user input
		int selected = userInput.nextInt();
		
		// If user chooses to exit, return false
		if(selected == 0) {
			
			return;
		}
		
		// Assigns requirement
		if(!model.assignCourseRequirements(course, selected)) {
			
			// Tells user assignment failed due to course being full
			view.courseFull();
		}
	}
	
	/**
	 * Allows Course Director to create new courses
	 */
	private static void createCourse() {
		
		// Asks user to input a course name
		view.createCourse();
		// Stores user input
		String name = userInput.next();
		
		// Ask user to input course requirements
		view.askRequirement();
		// Stores user input
		int requirement = userInput.nextInt();
		
		model.createCourse(name, requirement);
	}
	
	/**
	 * Sets up staff view
	 */
	private static void staffViewMenu() {
		
		// Displays staff view and allows exit
		view.displayStaff(model.returnStaffList());
		// Stores user input
		int selected = userInput.nextInt();
		
		// Loops until valid input is selected
		while(selected != 0) {
					
			// Displays wrong input message
			view.incorrectInput();
			// Stores user input
			selected = userInput.nextInt();
		}
	}
	
	/**
	 * Allows administrator to create new staff members
	 */
	private static void createNewStaffMember() {
		
		view.createStaff();
		
		// Stores staff member name
		String name = userInput.next();
		
		// Calls model to create staff member
		model.createStaff(name);
	}
	
	/**
	 * Allows admin to view course requirements and add or remove staff
	 * @param ArrayList<Course>
	 */
	private static void fillRequirements(ArrayList<Course> requirements) {
		
		// Displays list of courses
		view.displayCourses(requirements);
		
		// Stores user selection
		int selected = userInput.nextInt();
		
		// Loops until valid input is selected
		while(selected < 0 || selected > requirements.size()) {
					
			// Displays wrong input message
			view.incorrectInput();
			// Displays courses
			view.displayCourses(requirements);
			// Stores user input
			selected = userInput.nextInt();
		}
				
		// If user wants to return to admin options, return
		if(selected == 0) {
			
			return;
		}
		
		// Stores course selection
		Course course = requirements.get(selected - 1);
		
		courseOptions(course);
	}
	
	/**
	 * Allows admin to assign staff to training
	 */
	private static void train() {
		
		// Stores untrained staff
		ArrayList<Staff> untrainedStaff = model.UntrainedStaff();
		
		// Displays untrained staff
		view.displayStaff(untrainedStaff);
		// Asks user to select a staff member to train
		view.trainStaffOptions(); // only display if staff members != 0
		
		// Stores user input
		int selected = userInput.nextInt();
		
		// Loop until user selects valid input
		while(selected < 0 || selected > untrainedStaff.size()) {
			
			// Displays wrong input message
			view.incorrectInput();
			// Displays untrained staff
			view.displayStaff(untrainedStaff);
			// Asks user to select a staff member to train
			view.trainStaffOptions();
			// Stores user input
			selected = userInput.nextInt();			
		}
		
		// If user selects to exit return false
		if(selected == 0) {
			
			return;
		}
		
		model.train(untrainedStaff.get(selected - 1));
	}
	
	/**
	 * Displays the course requirements and add/remove staff options
	 * @param Course
	 */
	private static void courseOptions(Course course) {
		
		// Displays course options
		view.displayCourse(course);
		// display course options
		view.displayAdminCourseOptions();
		// Stores user input
		int selected = userInput.nextInt();
		
		// Loop until user selects valid input
		while(selected < 0 || selected > 2) {
			
			// Displays wrong input message
			view.incorrectInput();
			// Displays courses
			view.displayCourse(course);
			// Stores user input
			selected = userInput.nextInt();			
		}
		
		// Responds to user input
		switch (selected) {
		// If user chooses to exit, return false
		case 0:
			return;
		// If 1 enter assign staff menu
		case 1:
			// Checks if course is full
			if(course.checkFull()) {
				 // If course is full don't allow admin to add staff
				view.courseFull();
			} else {
				// Assigns staff to course
				assignStaff(course);
			}
			break;
		// If 2 enter remove staff menu
		case 2:
			removeStaff(course);
			break;
		}
	}
	
	/**
	 * Allows administrator to assign staff to a course
	 */
	private static void assignStaff(Course course) {
		
		// Stores available staff
		ArrayList<Staff> availableStaff = model.AvailableStaff();
		
		// Shows available staff to assign
		view.displayStaff(availableStaff);
		
		// Stores user input
		int selected = userInput.nextInt();
		
		// Loops until valid input is selected
		while(selected < 0 || selected > availableStaff.size()) {
				
			// Displays wrong input message
			view.incorrectInput();
			// Displays courses
			view.displayStaff(availableStaff);
			// Stores user input
			selected = userInput.nextInt();
		}
		
		// If user selects to exit return false
		if(selected == 0) {
			
			return;
		}
		
		// Adds selected staff member to course
		model.addStaffToCourse(course, availableStaff.get(selected - 1));
	}

	
	/**
	 * Allows administrator to remove staff member from course
	 */
	private static void removeStaff(Course course) {
		
		// Stores staff assigned to course
		ArrayList<Staff> assignedStaff = model.findCourseStaff(course);
		
		// Displays staff
		view.displayStaff(assignedStaff);
		
		// Stores user input
		int selected = userInput.nextInt();
		
		// Loops until user enters valid input
		while(selected < 0 || selected > assignedStaff.size()) {
			
			// Displays wrong input message
			view.incorrectInput();
			// Displays courses
			view.displayStaff(assignedStaff);
			// Stores user input
			selected = userInput.nextInt();
		}
		
		// If user selects to exit return false
		if(selected == 0) {
			
			return;
		}
		
		// Remove selected staff from selected course
		model.removeStaffFromCourse(course, assignedStaff.get(selected - 1));
	}
	
	/**
	 * Allows the PTT Director to approve courses
	 */
	private static void approveCourse() {
		
		// Gets approved courses
		ArrayList<Course> filledCourses = model.findFullCourses();
		
		// Shows approved courses and asks for user input
		view.displayCourses(filledCourses);
		
		// Stores user input
		int selected = userInput.nextInt();
		
		// Loops until user enters valid input
		while(selected < 0 || selected > filledCourses.size()) {
					
			// Displays wrong input message
			view.incorrectInput();
			// Asks user to approve a course requirement
			view.displayCourses(filledCourses);						
			// Stores user input
			selected = userInput.nextInt();
		}
				
		// If user selects to exit return false
		if(selected == 0) {
					
			return;
		}
			
		// Requirement approved
		model.giveRequestApproval(filledCourses.get(selected - 1), true);
	}
	
	/**
	 * Allows PTT Director to view approved courses and unapprove if needed
	 */
	private static void unapproveCourse() {
		
		// Gets approved courses
		ArrayList<Course> unapprovedCourses = model.findApprovedCourses();
		
		// Shows approved courses and asks for user input
		view.displayCourses(unapprovedCourses);
		
		// Stores user input
		int selected = userInput.nextInt();
		
		// Loops until user enters valid input
		while(selected < 0 || selected > 1) {
					
			// Displays wrong input message
			view.incorrectInput();
			// Asks user to approve a course requirement
			view.displayCourses(unapprovedCourses);						
			// Stores user input
			selected = userInput.nextInt();
		}
				
		// If user selects to exit return false
		if(selected == 0) {
					
			return;
		}
				
		// Unapproves Course
		model.giveRequestApproval(unapprovedCourses.get(selected - 1), false);
	}
	
	/**
	 * Closes scanner and writed to file
	 */
	public void exit() {
		
		// Writes state to file
		model.writeToFile();
	}
}
