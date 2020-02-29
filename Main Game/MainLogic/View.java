package MainLogic;

import java.util.ArrayList;

public class View {

    public View ()  {

    }

    public void selectUser() {
        System.out.println("Please select user:");
        System.out.println("1. Course Director \n2. Administrator\n3. PTT Director\n0. Quit");
    }

    public void courseDirectorOption() {
        System.out.println("Welcome Course Director, please select from the below options:");
        System.out.println("1. View Courses\n2. Create Course");
    }

    public void adminOptions() {
        System.out.println("Welcome Administrator, please select from the below options:");
        System.out.println("1. View Staff \n2. View Course Requirements \n3. Create Staff \n4. View Untrained Staff");
    }

    public void pttDirectorOptions() {
        System.out.println("Welcome PTT Director, please select from the below options:");
        System.out.println("1. View Courses for Approval \n2. View Approved Courses");
    }

    public void viewCourses(ArrayList<Course> courses) {
        
    }

}