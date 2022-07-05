package Org.Zsgs.CollegeManagementSystem;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CourseDetails {
	HomePage myHP = new HomePage();

	void printColleges() {
		System.out.println("----------------------------------------------------------------------");
		System.out.println("\t\tList of colleges and schools in XYZ University");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("1.XYZ college of Engineering.\n2.XYZ schools of Management.");
		System.out.println("3.XYZ Arts and Science college.\n4.XYZ Polytechnic college.");
		selectCollege();

	}

	void selectCollege() {
		Scanner input = new Scanner(System.in);
		int collegeChoice = 0;
		System.out.println("Enter your choice to know about available courses:");
		try {
			collegeChoice = input.nextInt();
		} catch (Exception E) {
			System.out.println("Enter a valid Input...");
			System.out.println("----------------------------------------------------------------------");
			selectCollege();
		}
		if (collegeChoice < 5 && collegeChoice > 0) {
			switch (collegeChoice) {
			case (1): {
				PrintEngineeringCourses();
				break;
			}
			case (2): {

				printSchoolsOfManagementCourses();
				break;
			}
			case (3): {
				printArtsCollegeCourses();
				break;
			}
			case (4): {
				printPolytechnicCourses();
				break;
			}
			}
		} else {
			System.out.println("Enter a valid Input");
			System.out.println("----------------------------------------------------------------------");
			selectCollege();
			return;
		}
	}

	void PrintEngineeringCourses() {
		FileReader myReader = null;
		Scanner myScanner = null;
		try {
			myReader = new FileReader("D:\\my college\\Engineering courses.txt");
			myScanner = new Scanner(myReader);

			while (myScanner.hasNextLine()) {
				System.out.println(myScanner.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Error in reading file");
			e.printStackTrace();
		} finally {
			try {
				myReader.close();
			} catch (IOException e) {
				System.out.println("Error in closing file reader");
				e.printStackTrace();
			}
			myScanner.close();
		}
		System.out.println("----------------------------------------------------------------------");
		myHP.choiceAtPage();

	}

	void printSchoolsOfManagementCourses() {
		FileReader myReader = null;
		Scanner myScanner = null;
		try {
			myReader = new FileReader("D:\\my college\\School of management.txt");
			myScanner = new Scanner(myReader);

			while (myScanner.hasNextLine()) {
				System.out.println(myScanner.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Error in reading file");
			e.printStackTrace();
		} finally {
			try {
				myReader.close();
			} catch (IOException e) {
				System.out.println("Error in closing file reader");
				e.printStackTrace();
			}
			myScanner.close();
		}
		System.out.println("----------------------------------------------------------------------");
		myHP.choiceAtPage();
	}

	void printArtsCollegeCourses() {
		FileReader myReader = null;
		Scanner myScanner = null;
		try {
			myReader = new FileReader("D:\\my college\\ArtsAndScience courses.txt");
			myScanner = new Scanner(myReader);

			while (myScanner.hasNextLine()) {
				System.out.println(myScanner.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Error in reading file");
			e.printStackTrace();
		} finally {
			try {
				myReader.close();
			} catch (IOException e) {
				System.out.println("Error in closing file reader");
				e.printStackTrace();
			}
			myScanner.close();
		}
		System.out.println("----------------------------------------------------------------------");
		myHP.choiceAtPage();
	}

	void printPolytechnicCourses() {
		FileReader myReader = null;
		Scanner myScanner = null;
		try {
			myReader = new FileReader("D:\\my college\\polytechnic courses.txt");
			myScanner = new Scanner(myReader);

			while (myScanner.hasNextLine()) {
				System.out.println(myScanner.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Error in reading file");
			e.printStackTrace();
		} finally {
			try {
				myReader.close();
			} catch (IOException e) {
				System.out.println("Error in closing file reader");
				e.printStackTrace();
			}
			myScanner.close();
		}
		System.out.println("----------------------------------------------------------------------");
		myHP.choiceAtPage();
	}

}
