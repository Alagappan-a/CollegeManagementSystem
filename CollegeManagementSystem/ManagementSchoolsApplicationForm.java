package Org.Zsgs.CollegeManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagementSchoolsApplicationForm extends ApplicationForm {

	ArrayList<String> managementDeptList = new ArrayList<>();

	void addCourse() {
		managementDeptList.add("1.Finance");
		managementDeptList.add("2.Marketing");
		managementDeptList.add("3.Operations");
		managementDeptList.add("4.Human Resources");
		managementDeptList.add("5.Strategy");
		managementDeptList.add("6.Business Analytics");
		managementDeptList.add("7.Digital Marketing");
	}

	public int getStudentAge() {
		int age = 0;
		System.out.println("student age must be greater than 20 and less than 29");
		System.out.print("Enter Student age:");
		try {
			age = input.nextInt();
		} catch (Exception e) {
			System.out.println("Enter the valid Input");
			getStudentAge();
		}
		if (age <= 20 || age >= 29) {
			System.out.println("Enter the valid Input");
			getStudentAge();
		}
		return age;
	}

	public int getDepartment() {
		int deptID = 0;

		System.out.println("Courses available in management schools are:");
		for (String dept : managementDeptList
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
		System.out.println("Enter your college name :");
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

	public float getStudentGPA() {
		float cgpa = 0;
		System.out.print("Enter your overall GPA (i.e.5.0< X >9.9) :");
		try {
			cgpa = input.nextFloat();
		} catch (Exception e) {
			System.out.println("Enter the valid Input");
			getStudentGPA();
		}
		if (cgpa < 6.5 || cgpa > 10.0) {
			System.out.println("Enter the valid Input");
			getStudentGPA();
		}
		return cgpa;
	}

	public String getStudentCourse() {
		System.out.println("Enter your UG course name :");
		String courseName = input.nextLine();
		Pattern pattern = Pattern.compile("[^a-zA-Z.' ']");
		Matcher matcher = pattern.matcher(courseName);
		boolean isStringContainsSpecialCharacter = matcher.find();
		if (isStringContainsSpecialCharacter) {
			System.out.println("Please Enter a valid name ");
			getInstituteName();
		}
		return courseName;
	}

	public void getManagementstudentDetails() {
		System.out.println("----------------------------------------------------------------------");
		System.out.println("\t\t\tManagement Schools Application Form");
		System.out.println("----------------------------------------------------------------------");
		addCourse();
		String firstName = getFirstName();
		String lastName = getLastName();
		String parentName = getParentsName();
		String gender = getStudentGender();
		String mobileNumber = getNumber();
		String emailID = getMailID();
		String collegeName = getInstituteName();
		String courseName = getStudentCourse();
		int dept = getDepartment();
		int age = getStudentAge();
		float cgpa = getStudentGPA();
		if (dept == 1 && cgpa < 7.0) {
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		} else if (dept == 2 && cgpa < 7.0) {
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		} else if (dept == 3 && cgpa < 7.5) {
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		} else if (dept == 4 && cgpa < 7.5) {
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		} else if (dept == 5 && cgpa < 8.0) {
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		} else if (dept == 6 && cgpa < 6.5) {
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		} else if (dept == 7 && cgpa < 6.5) {
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		} else {
			System.out.println("congratulations..!\n you are selected for " + managementDeptList.get(dept - 1));
			try {
				String url = "jdbc:mysql://localhost:3306/myCollege";
				String username = "root";
				String pass = "Prema@12345";
				Connection con = DriverManager.getConnection(url, username, pass);
				String query = "insert into managementSchools_Student_Details(Student_First_Name,Student_Last_Name,Parent_Name,Student_Gender,Contact_Number,Mail_ID,Student_age,Department_ID ,College_Name,OverAll_GPA,UG_Course_Name) values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement smt = con.prepareStatement(query);

				smt.setString(1, firstName);
				smt.setString(2, lastName);
				smt.setString(3, parentName);
				smt.setString(4, gender);
				smt.setString(5, mobileNumber);
				smt.setString(6, emailID);
				smt.setInt(7, age);
				smt.setInt(8, dept);
				smt.setString(9, collegeName);
				smt.setFloat(10, cgpa);
				smt.setString(11, courseName);
				smt.executeUpdate();
				System.out.println("Register Successfully");
			} catch (Exception ex) {
				System.out.println("Not Connected");
				ex.printStackTrace();
			}

		}
	}
}