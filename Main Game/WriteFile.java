import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * WriteFile class for Software Engineering project
 * @author 2205885M Michael Miller
 * public void staffToFile(String destination, ArrayList<Staff> tempStaffArray)
 * public void courseToFile(String destination, ArrayList<Course> tempCourseArray)
 *
 */

public class WriteFile {
	/**
	 * Method to write staff list to file
	 * @param destination is the path for the the file specified. i.e where and what the new file will be called
	 * @param tempStaffArray arrayList of staff to be committed to file
	 */
	public void staffToFile(String destination, ArrayList<Staff> tempStaffArray) {
		try {
			FileWriter writer = new FileWriter(destination); 
			for(Staff all: tempStaffArray) {
			  writer.write(all + System.lineSeparator());
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Method to write Course list to file
	 * @param destination is the path for the the file specified. i.e where and what the new file will be called
	 * @param tempCourseArray arrayList of courses to be committed to file
	 */
	public void courseToFile(String destination, ArrayList<Course> tempCourseArray) {
		
		try {
			FileWriter writer = new FileWriter(destination); 
			for(Course all: tempCourseArray) {
			  writer.write(all + System.lineSeparator());
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
