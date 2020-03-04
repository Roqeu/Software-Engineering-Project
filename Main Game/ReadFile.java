import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * ReadFile class
 * @author 2205885M Michael Miller
 * public ArrayList<Staff> readStaff(String path)
 * public ArrayList<Course> readCourse(String path)
 *
 */
public class ReadFile {
	private Scanner file;
	private ArrayList<Staff> tempStaffList;
	private ArrayList<Staff> courseStaff;
	/**
	 * Method to read staff list from file into an array list of staff
	 * @param path takes String representing the path of the file to be read
	 * @return Array list of staff members listed into the file
	 */

	public ArrayList<Staff> readStaff(String path) {
		try // try/catch use in case of file-not-found error in file path entry
		{
			file = new Scanner(new File(path));
			
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		ArrayList<Staff> tempStaffList = new ArrayList<Staff>(); // create new temp array each time file read
		
		while (file.hasNext()) { // conclude file reading once its contents are empty

			String name = file.next(); // obtain first element of the line from file and store in String name
			//(TEST) System.out.println(name);
			int id = Integer.parseInt(file.next()); // obtain second element via white space separation, convert to int
			//(TEST) System.out.println(id);
			boolean available = Boolean.parseBoolean(file.next()); // obtain third element via whitespace separation, convert to boolean
			//(TEST) System.out.println(available);
			boolean trained = Boolean.parseBoolean(file.next()); // obtain fourth element via whitespace separation, convert to boolean
			//(TEST) System.out.println(trained);
			tempStaffList.add(new Staff(name, id, available, trained)); // feed data into staff constructor, store in tempStaffList															// array
			file.hasNextLine();

		}
		file.close();
		//(TEST) System.out.println(tempStaffList); // to test in staff class made tostring method
		return tempStaffList; // return ArrayList to model

	}

	public ArrayList<Course> readCourse(String path) { // as above... with extra steps....
		
		try // try/catch use in case of filenotfound error in file path entry
		{
			file = new Scanner(new File(path));
			
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		ArrayList<Course> tempCourseList = new ArrayList<Course>();
		
		while (file.hasNextLine()) {
			String[] current = file.nextLine().split(" ");
				int id = Integer.parseInt(current[0]);
				// (TEST)System.out.println(id);
				String name = current[1];
				// (TEST)System.out.println(name);
				boolean approved = Boolean.parseBoolean(current[2]);
				// (TEST)System.out.println(approved);
				int requiredStaff = Integer.parseInt(current[3]);
				// (TEST)System.out.println(requiredStaff);
				int assignedStaff = Integer.parseInt(current[4]);
				// (TEST) System.out.println(assignedStaff);
				
				ArrayList<Integer> staffId = new ArrayList<Integer>();
				// once defined size elements are read, a second while loop runs through staff id associated with each course
      			// these are variable in length as such hasNextInt() condition ensures all will be read and added to courses
				for (int i= 5; i<current.length; i++) {
					staffId.add(Integer.parseInt(current[i]));
				}
				tempCourseList.add(new Course(id, name, approved, requiredStaff, assignedStaff, staffId));
				// (TEST) System.out.println(staffId);
			}
	
		file.close();
		
		return tempCourseList;
		}
		
	}
		
	


