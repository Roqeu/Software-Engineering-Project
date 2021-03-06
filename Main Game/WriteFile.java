import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * WriteFile class for Software Engineering project
 * 
 * @author 2205885M Michael Miller public void staffToFile(String destination,
 *         ArrayList<Staff> tempStaffArray) public void courseToFile(String
 *         destination, ArrayList<Course> tempCourseArray)
 *
 */

public class WriteFile {
	/**
	 * Method to write staff list to file
	 * 
	 * @param destination    is the path for the the file specified. i.e where and
	 *                       what the new file will be called
	 * @param tempStaffArray arrayList of staff to be committed to file
	 */
	public void staffToFile(String destination, ArrayList<Staff> tempStaffArray) {
		try {
			FileWriter writer = new FileWriter(destination);
			for (Staff member : tempStaffArray) {
				writer.write((" " + member.getName() + " " + member.getID() + " " + member.isAvailable() + " "
						+ member.isTrained()) + System.lineSeparator());
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method to write Course list to file
	 * 
	 * @param destination     is the path for the the file specified. i.e where and
	 *                        what the new file will be called
	 * @param tempCourseArray arrayList of courses to be committed to file
	 */
	public void courseToFile(String destination, ArrayList<Course> tempCourseArray) {
		String builder = " ";
		String Staff = " ";

		try {
			FileWriter writer = new FileWriter(destination);
			for (Course course : tempCourseArray) {
				builder = " ";
				 builder = + course.getID() + " " + course.getName() + " " + course.isApproved()
						+ " " + course.getRequiredStaff() + " " + course.getAssignedStaff() + builder;
				        
				        
				for (int id : course.getStaffID()) {
					builder += id + " ";
				}
				writer.write(builder + System.lineSeparator());

			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
