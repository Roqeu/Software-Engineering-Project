/**
 * Controller class for teaching requirements program
 * @author Aaron Callaghan
 *
 *	public methods:
 *		public static void main(String[] args0)
 */

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
			
			// Responds to user input
			switch(userChoice) {
			// Activates user menu loop based on user choice			
			case 0:
			
				// Writes to file and ends program
				controller.exit();
				// Exits main loop
				quit = true;
				break;
			case 1:
				
				// Continues until user wants to return to user select
				while(!returnToMainMenu) {
					
					returnToMainMenu = controller.courseDirectorOptions();
				}
				break;
			case 2:
				
				// Continues until user wants to return to user select
				while(!returnToMainMenu) {
					
					returnToMainMenu = controller.adminOptions();
				}
				break;
			case 3:
				// Continues until user wants to return to user select
				while(!returnToMainMenu) {
					
					returnToMainMenu = controller.pttDirectorOptions();
				}
				break;
			}
		}
		
	}
	
}
