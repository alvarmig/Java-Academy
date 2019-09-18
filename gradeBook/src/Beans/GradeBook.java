/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Miguel
 */
public class GradeBook {

    private String courseName;
    private String instructorName;

    // constructor initializes courseName with String argument
    public GradeBook(String name, String author) // constructor name is class name
    {
        courseName = name; // initializes courseName
        instructorName = author;
    } // end constructor

    public void setCourseName(String name) {
        courseName = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void displayMessage() {
        System.out.printf("Welcome to the Grade Book for \n%s!\n", getCourseName());
    }
}
