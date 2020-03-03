

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
	private Scanner file;
	private ArrayList<Staff> tempStaffList;
	private ArrayList<Staff> courseStaff;
	
	public void openFile(String f) {

		try {
			file = new Scanner(new File(f));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Staff> readStaff() {
		ArrayList<Staff> tempStaffList = new ArrayList<Staff>(); //create new temp array each time file read
		while (file.hasNext()) { // conclude file reading once its contents are empty

			int id = Integer.parseInt(file.next()); //convert substrings into the appropriate datatypes
			String name = file.next();
			boolean available = Boolean.parseBoolean(file.next());
			boolean trained = Boolean.parseBoolean(file.next());
			tempStaffList.add(new Staff(name, id, available, trained)); //feed data into staff constructor into temp array
			file.hasNextLine();

		}
		System.out.println(tempStaffList); // to test in staff class made tostring method
		return tempStaffList; //return temp array to model

	}
	public ArrayList<Course> readCourse(){ // as above... with extra steps....
		ArrayList<Course> tempCourseList = new ArrayList<Course>();	
		while(file.hasNext()) {
			
			String name = file.next();
			System.out.println(name);
			int id = Integer.parseInt(file.next());
			System.out.println(id);
			int staffed = Integer.parseInt(file.next());
			System.out.println(staffed);
			int staffreq = Integer.parseInt(file.next());
			System.out.println(staffreq);
			boolean fulfilled = Boolean.parseBoolean(file.next());
			System.out.println(fulfilled);
			boolean approved = Boolean.parseBoolean(file.next());
			System.out.println(approved);
			ArrayList<Integer> staffId = new ArrayList<Integer>();
			
			while( file.hasNextInt()) {
				staffId.add(file.nextInt());
			}
			System.out.println(staffId);
			file.hasNextLine();
			
	
				//courseStaff.add(getStaff(getID() = Integer.parseInt(file.next())));	
			//tempCourseList.add(new Course(name, id, staffed, staffreq, fulfilled, approved, staffId));
					
			}
		return tempCourseList;
		} 
	public void closeFile() {
		file.close();
	}


}
