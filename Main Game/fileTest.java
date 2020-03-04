import java.util.ArrayList;

public class fileTest {
	public static void main(String[] args) {
		// to test fileIO (Course) functionality create string below for data input/output
		
		String origin = "C:\\Users\\mille\\eclipse-workspace\\Software-Engineering-Project\\Main Game\\Course.txt";
		String courseDest = "C:\\Users\\mille\\eclipse-workspace\\Software-Engineering-Project\\Main Game\\courseDest.txt";
		String courseDoubleCheck = "C:\\Users\\mille\\eclipse-workspace\\Software-Engineering-Project\\Main Game\\doubleCheck.txt";
		
		WriteFile w = new WriteFile();
		ReadFile r = new ReadFile();
		
		//test functioning of read method using test ArrayList<Course> g
		ArrayList<Course> g = r.readCourse(origin);
		// write g to file "dest"
		w.courseToFile(courseDest, g);
		// read from "courseDest" to and write contents to "courseDoubleCheck"
		w.courseToFile(courseDoubleCheck, r.readCourse(courseDest));
		
		// to test fileIO (Course) functionality create string below for data input/output
		
		String staff = "C:\\Users\\mille\\eclipse-workspace\\Software-Engineering-Project\\Main Game\\Staff.txt";
		String staffDest = "C:\\Users\\mille\\eclipse-workspace\\Software-Engineering-Project\\Main Game\\StaffDest.txt";
		String staffDoubleCheck = "C:\\Users\\mille\\eclipse-workspace\\Software-Engineering-Project\\Main Game\\StaffDoubleCheck.txt";
		
		//test functioning of read method using test ArrayList<Course> s
		ArrayList<Staff> s = r.readStaff(staff);
		// write s to file "staffDest"
		w.staffToFile(staffDest, s);
		// read from "staffDest" to and write contents to "staffDoubleCheck"
		w.staffToFile(staffDoubleCheck, r.readStaff(staffDest));
	}

}
