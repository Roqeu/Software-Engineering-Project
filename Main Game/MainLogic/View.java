package MainLogic;

import java.util.ArrayList;



public class View {
    /**
     * Contstructor
     */
    public View ()  {}
    //Generic re-usable display methods
    public void selectUser() {
        System.out.println("Please select user:");
        System.out.println("1. Course Director \n2. Administrator\n3. PTT Director");
        exit();
    }
    public void displayCourses(ArrayList<Course> courses) {
        //iterate over course list and print out each class, then a quit item at the end
        int selectNum = 1;
        for (Course course : courses) {
            System.out.println(selectNum+". "+ course.getName());
            selectNum++;
        }
        exit();
    }

    //Course director methods
    public void courseDirectorOptions() {
        System.out.println("Welcome Course Director, please select from the below options:");
        System.out.println("1. View Courses\n2. Create Course");
        exit();
    }

    public void createCourse() {
        System.out.println("Please enter the course name, followed by the required staff on a new line");
    }

    public void askRequirement() {
        System.out.println("Please enter the number of required staff for selected course: ");
    }

    //Admin methods
    public void adminOptions() {
        System.out.println("Welcome Administrator, please select from the below options:");
        System.out.println("1. View Staff \n2. View Course Requirements \n3. Create Staff \n4. View Untrained Staff");
        exit();
    }
    public void displayStaff(ArrayList<Staff> staffList) {
        for (Staff staff: staffList) {
            System.out.println(staff);
        }
        exit();
    }
    public void displayCourse(Course course) {
        System.out.println("Course: " + course.getName());
        System.out.println("Required Staff: " + course.getRequirements());
        System.out.println("Assigned Staff: " + course.getAssignedStaff());
        System.out.println("");
        System.out.println("1. Assign Staff \n2. Remove Staff");
        exit();
    }
    public void displayUntrainedStaff(ArrayList<Staff> staffList) {
        for (Staff staff : staffList) {
            System.out.println(staff);
        }
        exit();
    }
    public void createStaff() {
        System.out.println("Please enter the name of the member of staff below: ");
    }

    // public void displayCourseRequirments(ArrayList<Course> requirements) {
    //     int selectNum = 1;
    //     for(Course course : requirements) {
    //         System.out.println(selectNum + ". " + course.getName() + ", Required Staff: " + course.getRequirements() + ", Assigned Staff: " +course.getAssignedStaff());
    //         selectNum++;
    //     }
    //     exit();
    // }

    //PTT Director methods
    public void pttDirectorOptions() {
        System.out.println("Welcome PTT Director, please select from the below options:");
        System.out.println("1. View Courses for Approval \n2. View Approved Courses");
        exit();

    }







    //These methods are lines that are repeated multiple times, so are set up as a single method call instead.
    public void incorrectInput() {
        System.out.println("Incorrect input, please try again!");
    }

    public void exit() {
        System.out.println("0. Exit\n");
    }
}