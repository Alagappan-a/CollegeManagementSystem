package Org.Zsgs.CollegeManagementSystem;

import java.util.Scanner;

public class HomePage {
	Scanner input = new Scanner(System.in);

	void PrintWelcome() {
		System.out.println("----------------------------------------------------------------------");
		System.out.println("\t\t\tWelcome to XYZ University");
		System.out.println("----------------------------------------------------------------------");
		showOption();
	}
	void showOption() {
		System.out.println("----------------------------------------------------------------------");
		System.out.println("1.About the university.\n2.Course Details.\n3.Admission form.\n4.To Login");
		System.out.println("----------------------------------------------------------------------");
		selectChoice();
	}
	void selectChoice() {
		int indexChoice = 0;
		System.out.println("Enter your choice");
		try {
			indexChoice = input.nextInt();
		} catch (Exception E) {
			System.out.println("Enter a valid Input...");
			System.out.println("----------------------------------------------------------------------");
			selectChoice();
			return;
		}
		if (indexChoice < 5 && indexChoice > 0) {
			switch (indexChoice) {
			case (1): {
				AboutCollege aboutObject = new AboutCollege();
				aboutObject.readAboutCollege();
				break;
			}
			case (2): {
				CourseDetails courseObject = new CourseDetails();
				courseObject.printColleges();
				break;
			}
			case (3): {
				new ApplicationFormSelector().collegeApplication();
				break;
			}
			case (4): {
				System.out.println("1");
				break;
			}
			}
		} else {
			System.out.println("Enter a valid Input");
			System.out.println("----------------------------------------------------------------------");
			selectChoice();
			return;
		}
	}

	void choiceAtPage() {
		Scanner input = new Scanner(System.in);
		char choiceAtAbout = 0;
		System.out.println("Enter :'h' for home page (or)Enter :'1' For admission(or) Enter : 'n' to exit ");
		try {
			choiceAtAbout = input.next().charAt(0);
		} catch (Exception e) {
			System.out.println("Enter the valid input");
			choiceAtPage();
		}
		if (choiceAtAbout == 'h') {
			showOption();
		} else if (choiceAtAbout == 'n') {
			System.out.println("----------------------------------------------------------------------");
			System.out.println("\t\t\tThanks for Visiting");
			System.out.println("----------------------------------------------------------------------");

		} else if (choiceAtAbout == '1') {
			new ApplicationFormSelector().collegeApplication();;
		} else {
			System.out.println("Enter a valid Input");
			System.out.println("----------------------------------------------------------------------");
			choiceAtPage();
		}
	}

	public static void main(String[] args) {
		HomePage myHP = new HomePage();
		myHP.PrintWelcome();
	}

}
