package MainLogic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class WriteFile {
	public void staffToFile(String f, ArrayList<Staff> tempStaffArray) {
		try {
			FileWriter writer = new FileWriter(f); 
			for(Staff all: tempStaffArray) {
			  writer.write(all + System.lineSeparator());
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void courseToFile(String f, ArrayList<Course> tempCourseArray) {
		try {
			FileWriter writer = new FileWriter(f); 
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
