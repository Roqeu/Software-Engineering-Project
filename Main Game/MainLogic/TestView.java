package MainLogic;

import java.util.ArrayList;
import java.util.Scanner;

public class TestView {
    public static void main(String[] args) {
        View view = new View();
        Scanner myScanner = new Scanner(System.in);


        ArrayList<Course> courses = new ArrayList<Course>();

        Course programming = new Course("Programming", 1, 5, 2);
        Course database = new Course("Databases", 2, 4, 3);

        courses.add(programming);
        courses.add(database);

        ArrayList<Staff> staffList = new ArrayList<Staff>();

        Staff john = new Staff("John", 1, 20);
        Staff dory = new Staff("Dory", 2, 13);
        Staff andrew = new Staff("Andrew", 3, 15);

        staffList.add(john);
        staffList.add(dory);
        staffList.add(andrew);

        view.createCourse();
        // view.selectUser();
        // view.courseDirectorOptions();
        // view.adminOptions();
        // view.pttDirectorOptions();
        // view.listCourses(courses);
        // view.displayStaffList(staffList);
        // view.displayTeachingRequirments(courses);


    }
}