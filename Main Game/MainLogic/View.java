package MainLogic;

import java.util.ArrayList;



public class View {
    /**
     * Contstructor
     */
    public View ()  {

    }

    public void selectUser() {
        System.out.println("Please select user:");
        System.out.println("1. Course Director \n2. Administrator\n3. PTT Director\n0. Exit");
    }

    public void courseDirectorOptions() {
        System.out.println("Welcome Course Director, please select from the below options:");
        System.out.println("1. View Courses\n2. Create Course \n0. Exit");
    }

    public void adminOptions() {
        System.out.println("Welcome Administrator, please select from the below options:");
        System.out.println("1. View Staff \n2. View Course Requirements \n3. Create Staff \n4. View Untrained Staff \n0. Exit");
    }

    public void pttDirectorOptions() {
        System.out.println("Welcome PTT Director, please select from the below options:");
        System.out.println("1. View Courses for Approval \n2. View Approved Courses \n0. Exit");
    }

    public void listCourses(ArrayList<Course> courses) {
        //iterate over course list and print out each class, then a quit item at the end
        int selectNum = 1;
        for (Course course : courses) {
            System.out.println(selectNum+". "+ course.getName());
            selectNum++;
        }
        System.out.println("0. Exit");
    }

    
}