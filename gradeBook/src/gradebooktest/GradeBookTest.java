/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradebooktest;

import Beans.GradeBook;
import java.util.Scanner;

/**
 *
 * @author Miguel
 */
public class GradeBookTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create Scanner to obtain input from command window
        Scanner input = new Scanner(System.in);

        GradeBook myGradeBook = new GradeBook("CS101 Introduction to Java Programming", "Miguel Alvarado");

        myGradeBook.displayMessage();

        System.out.println("Please enter the course name: ");
        String nameOfCourse = input.nextLine();
        System.out.println();

        myGradeBook.setCourseName(nameOfCourse);
        myGradeBook.displayMessage();
    }

}
