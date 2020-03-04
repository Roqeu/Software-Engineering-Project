

import java.util.ArrayList;
import java.util.Scanner;

public class TestView {
    public static void main(String[] args) {
        View view = new View();
        // // Scanner myScanner = new Scanner(System.in);


        // ArrayList<Course> courses = new ArrayList<Course>();
        // ArrayList<Course> courses2 = new ArrayList<Course>();

        // Course programming = new Course("Programming", 1);
        // Course database = new Course("Databases", 2);

        // courses.add(programming);
        // courses.add(database);

        // view.displayCourses(courses);
        // view.displayCourses(courses2);

        ArrayList<Staff> staffList = new ArrayList<Staff>();

        Staff john = new Staff("John", 1);
        Staff dory = new Staff("Dory", 2);
        Staff andrew = new Staff("Andrew", 3);

        staffList.add(john);
        staffList.add(dory);
        staffList.add(andrew);

        // System.out.println("Select User View:");
        // view.selectUser();

        // System.out.println("Display Courses view:");
        // view.displayCourses(courses);

        // System.out.println("Course director options:");
        // view.courseDirectorOptions();

        // System.out.println("Create course option");
        // view.createCourse();

        // System.out.println("Ask Requirements");
        // view.askRequirement();

        // System.out.println("Administrator options view: ");
        // view.adminOptions();

        // System.out.println("Display staff list view");
        // view.displayStaff(staffList);

        // System.out.println("Display course options view");
        // view.displayCourseOptions(programming);

        // System.out.println("Display untrained staff list");
        // view.displayUntrainedStaff(staffList);

        // System.out.println("Create Staff view");
        // view.createStaff();

        // System.out.println("PTT Director options");
        // view.pttDirectorOptions();


        // System.out.println("Exit option and incorrect input test");
        // view.incorrectInput();
        // view.exit();
        view.displayStaff(staffList);
    }
}