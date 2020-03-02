package MainLogic;

public class TestModel {
	public static void main(String[] args) {
		
		Model model = new Model();
		
		
		/*
		 * Create some staff and print them
		 */
		model.createStaff("Bob");
		model.createStaff("Rachel");
		model.createStaff("Steve");
		
		System.out.println("Staff:");
		for(Staff staff : model.returnStaffList()) {
			System.out.println(staff);
		}
		
		/*
		 * Create some courses and print them
		 */
		model.createCourse("Programming", 3);
		model.createCourse("Databases", 4);
		
		System.out.println("\nCourses:");
		for(Course course : model.returnCourseList()) {
			System.out.println(course.getName());
		}
		
		System.out.println("\n--- Adding staff ---\n");
		
		/*
		 * Find a staff members to add
		 */
		
		Staff staffToAdd1 = model.findStaff(0);
		Staff staffToAdd2 = model.findStaff(2);
		
		/*
		 * Find a course
		 */
		
		Course courseToBeAddedTo = model.findCourse(0);
		
		/*
		 * Add staff to course
		 */
		model.addStaffToCourse(courseToBeAddedTo, staffToAdd1);
		model.addStaffToCourse(courseToBeAddedTo, staffToAdd2);
		
		/*
		 * Check staff added to course
		 */
		
		System.out.println("Staff in course:");
		for(int ID : courseToBeAddedTo.getStaffID()) {
			System.out.println(ID);
		}
		
		
		
	}
}
