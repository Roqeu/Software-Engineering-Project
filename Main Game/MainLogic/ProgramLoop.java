package MainLogic;

public class ProgramLoop {

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
		View view = new View();
		// Initialises controller
		controller = new Controller(model, view);
		
		// Stores a boolean to end application
		boolean quit = false;
		
		// Loops through application until user chooses to quit
		while(!quit) {
			
			// Stores a boolean used to end application loop
			boolean returnToMainMenu = false;
			
			// Stores the users choice and will only return 1, 2 or 3
			int userChoice = controller.selectUser();
			
			
			// Activates user menu loop based on user choice
			switch(userChoice) {
			
			case 0:
			
				// Writes to file and ends program
				controller.exit();
				// Exits main loop
				quit = true;
			case 1:
				
				// Continues until user wants to return to user select
				while(!returnToMainMenu) {
					
					returnToMainMenu = controller.courseDirectorOptions();
				}
			case 2:
				
				// Continues until user wants to return to user select
				while(!returnToMainMenu) {
					
					returnToMainMenu = controller.adminOptions();
				}
			case 3:
				// Continues until user wants to return to user select
				while(!returnToMainMenu) {
					
					returnToMainMenu = controller.pttDirectorOptions();
				}
			}
		}
		
	}
	
}
