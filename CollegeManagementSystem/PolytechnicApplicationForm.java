package Org.Zsgs.CollegeManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolytechnicApplicationForm extends ApplicationForm implements ApplicationFormMethods{

	ArrayList<String> polytechnicDeptList = new ArrayList<>();
	void addCourse() {
		polytechnicDeptList.add("1.DIPLOMA IN MECHANICAL ENGINEERING");
		polytechnicDeptList.add("2.DIPLOMA IN ELECTRONICS AND COMMUNICATION ENGINEERING");
		polytechnicDeptList.add("3.DIPLOMA IN ELECTRICAL AND ELECTRONICS ENGINEERING");
		polytechnicDeptList.add("4.DIPLOMA IN COMPUTER SCIENCE AND ENGINEERING");
		polytechnicDeptList.add("5.DIPLOMA IN AUTOMOBILE INDUSTRY");
		polytechnicDeptList.add("6.DIPLOMA IN CIVIL ENGINEERING");
	}
	public int getStudentAge() {
		int age = 0;
		System.out.println("student age must be greater than 15 and less than 25");
		System.out.print("Enter Student age:");
		try {
			age = input.nextInt();
		} catch (Exception e) {
			System.out.println("Enter the valid Input");
			getStudentAge();
		}
		if (age <= 15 || age >= 25) {
			System.out.println("Enter the valid Input");
			getStudentAge();
		}
		return age;
	}
	public int getDepartment() {
		int deptID = 0;
		System.out.println("Courses available in management schools are:");
		for (String dept : polytechnicDeptList
		) {
			System.out.println(dept);
		}
		System.out.println("Enter your Selected department ID:\t");
		try {
			deptID = input.nextInt();

		} catch (InputMismatchException exception) {
			System.out.println("please enter valid input ID");
		}
		if (deptID < 1 || deptID > 7) {
			System.out.println("Please Enter a valid department Name ");
			getDepartment();
		}
		return deptID;
	}
	public String getInstituteName() {
		System.out.println("Enter your School name :");
		String instituteName = input.nextLine();
		Pattern pattern = Pattern.compile("[^a-zA-Z.' ']");
		Matcher matcher = pattern.matcher(instituteName);
		boolean isStringContainsSpecialCharacter = matcher.find();
		if (isStringContainsSpecialCharacter) {
			System.out.println("Please Enter a valid name ");
			getInstituteName();
		}
		return instituteName;
	}
	public int getStudentMark() {
		int mark = 0;
		System.out.print("Enter your 10th mark:");
		try {
			mark = input.nextInt();
		} catch (Exception e) {
			System.out.println("Enter the valid Input");
			getStudentMark();
		}
		if (mark < 175 || mark > 500) {
			System.out.println("Enter the valid Input");
			getStudentMark();
		}
		return mark;
	}
	public int getStudentCutOff() {
		return 0;
	}
	public void getPolytechnicstudentDetails() {
		System.out.println("----------------------------------------------------------------------");
		System.out.println("\t\t\t\tPolytechnic Application Form");
		System.out.println("----------------------------------------------------------------------");
		addCourse();
		String firstName = getFirstName();
		String lastName = getLastName();
		String parentName = getParentsName();
		String gender = getStudentGender();
		String mobileNumber = getNumber();
		String emailID = getMailID();
		String schoolName = getInstituteName();
		int dept = getDepartment();
		int age = getStudentAge();
		int mark = getStudentMark();
		if (dept == 1 && mark < 450) {
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		} else if (dept == 2 && mark < 420) {
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		} else if (dept == 3 && mark < 420) {
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		} else if (dept == 4 && mark < 400) {
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		} else if (dept == 5 && mark < 350) {
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		} else if (dept == 6 && mark < 350) {
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		}  else {
			System.out.println("congratulations..!\n you are selected for " + polytechnicDeptList.get(dept - 1));
			try {
				String url = "jdbc:mysql://localhost:3306/myCollege";
				String username = "root";
				String pass = "Prema@12345";
				Connection con = DriverManager.getConnection(url, username, pass);
				String query = "insert into Polytechnic_Student_Details(Student_First_Name,Student_Last_Name,Parent_Name,Student_Gender,Contact_Number,Mail_ID,Student_age,Department_ID ,School_Name,10th_Mark) values(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement smt = con.prepareStatement(query);
				smt.setString(1, firstName);
				smt.setString(2, lastName);
				smt.setString(3, parentName);
				smt.setString(4, gender);
				smt.setString(5, mobileNumber);
				smt.setString(6, emailID);
				smt.setInt(7, age);
				smt.setInt(8, dept);
				smt.setString(9, schoolName);
				smt.setInt(10, mark);
				smt.executeUpdate();
				System.out.println("Register Successfully");
			} catch (Exception ex) {
				System.out.println("Not Connected");
				ex.printStackTrace();
			}
		}
	}
}
