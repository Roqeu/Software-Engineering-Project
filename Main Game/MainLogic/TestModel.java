package MainLogic;

public class TestModel {
	public static void main(String[] args) {
		
		Model model = new Model();
		
		model.createStaff("Bob", 20);
		model.createStaff("Rachel", 16);
		model.createStaff("Steve", 8);
		
		model.createCourse("Programming");
		model.createCourse("Databases");
		
		model.addStaffToCourse(model.getCourseList().get(0), 
								model.getStaffList().get(0));
		model.addStaffToCourse(model.getCourseList().get(0), 
								model.getStaffList().get(1));
		model.addStaffToCourse(model.getCourseList().get(1), 
								model.getStaffList().get(2));
		
		System.out.println("Staff:");
		for(Staff staff : model.getStaffList()) {
			System.out.println(staff);
		}
		
		System.out.println("\nCourses:");
		for(Course course : model.getCourseList()) {
			System.out.println(course);
		}
		/*
		 * Issues with ID's:
		 * 	
		 * If we use ID's and arraylists, every time and ID is given, 
		 * we need to loop through the entire staff list to find who it is
		 * Also, because a list of staff ID's is provided per course, the course 
		 * can't see the staff object it can't relate ID to the staff name, it 
		 * can only return the ID to be compared elsewhere
		 * 
		 * If a hashmap is used to store staff against ID values, 
		 * we need to store a persistent ID variable to keep assigning unique ID's
		 * Hashmap also means none of the entires would be ordered
		 * 
		 * If we don't use ID's (just use object references instead) we will end up 
		 * storing redundant data
		 * 
		 * Another option would be to move away from serializable objects. File-writer 
		 * could got into the course and staff objects and just take out the neccessary 
		 * information to reconstruct them (i.e. for course we'd could store name, approval 
		 * status and a list of staff ID's). The file-reader could then reconstruct the staff 
		 * and courses list and return both to model.This is more complicated, but gives the 
		 * added advantage that it could be converted to database more easily
		 */
		
		
		
	}
}
