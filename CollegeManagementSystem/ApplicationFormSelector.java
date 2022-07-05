package Org.Zsgs.CollegeManagementSystem;

import java.util.Scanner;

public class ApplicationFormSelector {
	void collegeApplication() {
		Scanner input = new Scanner(System.in);
		System.out.println("----------------------------------------------------------------------");
		System.out.println("\t\tList of colleges and schools in XYZ University");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("1.XYZ college of Engineering.\n2.XYZ schools of Management.");
		System.out.println("3.XYZ Arts and Science college.\n4.XYZ Polytechnic college.");
		int collegeChoice = 0;
		System.out.println("Enter your choice to apply :");
		try {
			collegeChoice = input.nextInt();
		} catch (Exception E) {
			System.out.println("Enter a valid Input...");
			System.out.println("----------------------------------------------------------------------");
			collegeApplication();
		}
		if (collegeChoice < 5 && collegeChoice > 0) {
			switch (collegeChoice) {
			case (1): {
				new EnggApplication().getEnggstudentDetails();
				break;
			}
			case (2): {
				new ManagementSchoolsApplicationForm().getManagementstudentDetails();
				
				break;
			}
			case (3): {
				new ArtsApplicationForm().getArtsstudentDetails();
				break;
			}
			case (4): {
				new PolytechnicApplicationForm().getPolytechnicstudentDetails();
				break;
			}
			}
		} else {
			System.out.println("Enter a valid Input");
			System.out.println("----------------------------------------------------------------------");
			collegeApplication();
			return;
		}
	}
}
