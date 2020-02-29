package MainLogic;

public class TestModel {
	public static void main(String[] args) {
		
		Model model = new Model();
		
		
		/*
		 * Create some staff and print them
		 */
		model.createStaff("Bob", 20);
		model.createStaff("Rachel", 16);
		model.createStaff("Steve", 8);
		
		System.out.println("Staff:");
		for(Staff staff : model.returnStaffList()) {
			System.out.println(staff);
		}
		
		/*
		 * Create some courses and print them
		 */
		model.createCourse("Programming");
		model.createCourse("Databases");
		
		System.out.println("\nCourses:");
		for(Course course : model.returnCourseList()) {
			System.out.println(course);
		}
		
		System.out.println("--- Adding staff ---\n");
		
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
		
		System.out.println(courseToBeAddedTo);
		
		
	}
}
