package MainLogic;

import java.util.ArrayList;

public class View {
    /**
     * Contstructor
     */
    public View ()  {}
    /**
     * Method to display the menu when the program is first run. 
     */
    public void selectUser() {
        System.out.println("Please select user:");
        System.out.println("1. Course Director \n2. Administrator\n3. PTT Director");
        exit();
    }
    /**
     * Method to display list of course, courses are passed as an ArrayList. 
     * Method iterates over arraylist and prints out list of courses with numbered menu options.
     * @param courses
     */
    public void displayCourses(ArrayList<Course> courses) {
        //iterate over course list and print out each class, then a quit item at the end
        if (courses.size() == 0) {
            System.out.println("There are no courses to display!");
        } else {
            int selectNum = 1;
            for (Course course : courses) {
                System.out.println(selectNum+". "+ course.getName());
                selectNum++;
            }
        }
        exit();
    }
    /**
     * Method that displays an error message to user when they enter an unexpected or incorrect input
     */
    public void incorrectInput() {
        System.out.println("Incorrect input, please try again!");
    }
    /**
     * Method to print exit option in the menu
     */
    public void exit() {
        System.out.println("0. Exit\n");
    }
    /**
     * Method to display course specific information once user has selected the course
     * @param course
     */
    public void displayCourse(Course course) {
        System.out.println("Course: " + course.getName());
        System.out.println("Required Staff: " + course.getRequiredStaff() + " " + "Assigned Staff: " + course.getAssignedStaff());
        System.out.println("Approved: " + course.isApproved());
        System.out.println("");
    }

    /**
     * Method to display the menu options for the Course Director
     */
    public void courseDirectorOptions() {
        System.out.println("Welcome Course Director, please select from the below options:");
        System.out.println("1. View Courses\n2. Create Course");
        exit();
    }
    /**
     * Method to display prompt for course and requirement information
     */
    public void createCourse() {
        System.out.println("Please enter the course name, followed by the required staff on a new line:");
    }
    /**
     * Method to display prompt for number of required staff on course
     */
    public void askRequirement() {
        System.out.println("Please enter the number of required staff for the selected course:  (Enter 0 to exit)");
    }

    /**
     * Method to display menu options for Administrator 
     */
    public void adminOptions() {
        System.out.println("Welcome Administrator, please select from the below options:");
        System.out.println("1. View Staff \n2. View Course Requirements \n3. Create Staff \n4. View Untrained Staff");
        exit();
    }
    /**
     * Method to iterate over ArrayList of Staff and print out each member of staff
     * @param staffList
     */
    public void displayStaff(ArrayList<Staff> staffList) {
        for (Staff staff: staffList) {
            System.out.println(staff);
        }
        exit();
    }
    /**
     * Method to display options for the admin after selecting a course
     */
    public void displayAdminCourseOptions() {
        System.out.println("1. Assign Staff \n2. Remove Staff");
        exit();
    }
    /**
     * Method to display prompt for new staff member information
     */
    public void createStaff() {
        System.out.println("Please enter the name of the member of staff below: ");
    }
    /**
     * Method to display prompt to enter staff ID to train
     */
    public void trainStaffOptions() {
        System.out.println("Please select the ID of a member of staff to train:");
        exit();
    }

    /**
     * Method to display the menu options for the PTT Director
     */
    public void pttDirectorOptions() {
        System.out.println("Welcome PTT Director, please select from the below options:");
        System.out.println("1. View Courses for Approval \n2. View Approved Courses");
        exit();
    }
    /**
     * Method to display the course options for the PTT Director, the menu option depends on whether the course object is currently approved or unapproved.
     * @param course
     */
    public void displayPTTDirectorCourseOptions(Course course) {

        if (course.isApproved()) {
            System.out.println("1. Unapprove Course");
        } else {
            System.out.println("1. Approve Course");
        }
        exit();
    }

}