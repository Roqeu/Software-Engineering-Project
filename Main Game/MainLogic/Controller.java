package MainLogic;

public class Controller {

	// Stores model
	private Model model;
	// Stores view
	private View view;
	
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
		
	}
	
	/**
	 * Shows course director the available options and responds to input
	 * Will display courses that the director can assign requirements to
	 */
	public void courseDirectorOptions() {
		
	}
	
	/**
	 * Shows administrator the available options and responds to input
	 * Will show staff members 
	 * Will show teaching requirements which can be selected to be filled
	 * Will allow creation of new staff 
	 * Will allow training to be assigned
	 */
	public void adminOptions() {
		
		
	}
	
	/**
	 * Shows PTT Director the available options and responds to input
	 * Will allow to the director to approve teaching requests
	 */
	public void pttDirectorOptions() {
		
		
	}
	
	/**
	 * Allows course director to assign hours to a given course
	 */
	private void assignHours() {
		
	}
	
	/**
	 * Allows administrator to assign staff to a course
	 */
	private void assignStaff() {
		
		
	}
	
	/**
	 * Allows administrator to create new staff members
	 */
	private void createNewStaffMember() {
		
	}
	
	/**
	 * Allows administrator to remove staff member from course
	 * @param StaffID
	 */
	private void removeStaff(int StaffID) {
		
		
	}
	
	/**
	 * Allows any user to return to the main choices menu
	 * @return int 1 - make more changes, 2 - quit, 3 - return to main menu
	 */
	public int makeAnotherChoice() {
		
		
	}
}
