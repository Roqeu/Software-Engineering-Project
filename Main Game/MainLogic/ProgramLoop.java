package MainLogic;

public class ProgramLoop {

	// Stores view
	private static View view;
	// Stores controller
	private static Controller controller;
	
	/**
	 * Main program loop
	 * @param args0
	 */
	public static void main(String[] args0) {
		
		// Initialises new model
		Model model = new Model();
		// Initialises view		
		view = new View(model);
		// Initialises controller
		controller = new Controller(model, view);
		
		// Stores a boolean to end application
		boolean quit = false;
		
		// Loops through application until user chooses to quit
		while(!quit) {
			
			// Stores a boolean used to end application loop
			boolean returnToMainMenu = true;
			
			// Stores the users choice and will only return 1, 2 or 3
			int userChoice = controller.selectUser();
			
			// Will show course director all courses 
			// and allow teaching requirements to be set
			// until user returns to privilege selection or quits the application
			while(!returnToMainMenu) {
				
				// If course director is selected follow Course Director workflow
				if(userChoice == 1) {
					
					// Display courses and ask for user input
						
						
					// Listen for an respond to input
					controller.courseDirectorOptions();
					
					// Else if administrator is selected follow Administrator workflow
				} else if (userChoice == 2) {
					
					// Listen for an respond to input
					controller.adminOptions();
	
					
					// Else follow PTT Director workflow
				} else {
	
					// Display filled teaching requests and ask for user input
						
						
					// Listen for an respond to input
					controller.pttDirectorOptions();
				}
			
				// Checks if user wants to make more changes, 
				// quit or return to the main menu and stores it
				int choice = controller.makeAnotherChoice();
				
				// If user selects to return to main exit PTT Director loop
				if(choice == 2) {
					
					// Exits PTT Director loop
					returnToMainMenu = false;
					
					// Else if user wants to quit exit main loop
				} else if(choice == 3) {
					
					// Exits PTT Director loop
					returnToMainMenu = false;
					
					// Exits main loop
					quit = true;
					
				}
				
			}
			
		}
		
	}
	
}
