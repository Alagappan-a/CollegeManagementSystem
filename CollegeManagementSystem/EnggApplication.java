package Org.Zsgs.CollegeManagementSystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnggApplication extends ApplicationForm implements ApplicationFormMethods {

	ArrayList<String> enggDeptList = new ArrayList<>();
	void addCourses() {
		enggDeptList.add("1.MECHANICAL ENGINEERING");
		enggDeptList.add("2.ELECTRONICS AND COMMUNICATION ENGINEERING");
		enggDeptList.add("3.ELECTRICAL AND ELECTRONICS ENGINEERING");
		enggDeptList.add("4.COMPUTER SCIENCE AND ENGINEERING");
		enggDeptList.add("5.ARTIFICIAL INTELLIGENCE AND DATA SCIENCE");
		enggDeptList.add("6.CIVIL ENGINEERING");
		enggDeptList.add("7.BIOTECHNOLOGY");
	}

	void registerInDB(String firstName,String lastName,String parentName,String gender,String mobileNumber,String emailID,int age,int dept,String schoolName,int mark,int cutOffMark){
		Connection con=null;
		PreparedStatement smt=null;
		try {
			String url = "jdbc:mysql://localhost:3306/myCollege";
			String username = "root";
			String pass = "Prema@12345";
			con = DriverManager.getConnection(url, username, pass);
			String query = "insert into Engg_Student_Details(Student_First_Name,Student_Last_Name,Parent_Name,Student_Gender,Contact_Number,Mail_ID,Student_age,Department_ID ,School_Name,12th_Mark,cut_Off_Mark) values(?,?,?,?,?,?,?,?,?,?,?)";
			smt = con.prepareStatement(query);
			smt.setString(1,firstName);
			smt.setString(2,lastName);
			smt.setString(3,parentName);
			smt.setString(4,gender);
			smt.setString(5,mobileNumber);
			smt.setString(6,emailID);
			smt.setInt(7,age);
			smt.setInt(8,dept);
			smt.setString(9,schoolName);
			smt.setInt(10,mark);
			smt.setInt(11,cutOffMark);
			smt.executeUpdate();
			System.out.println("Register Successfully");
		} catch (Exception ex) {
			System.out.println("Not Connected");
			ex.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error in closing ");
			}
			try {
				smt.close();
			} catch (SQLException e) {
				System.out.println("Error in closing ");
			}
		}
	}
	public int getStudentAge() {
		int age = 0;
		System.out.println("student age must be greater than 17 and less than 27");
		System.out.print("Enter Student age:");
		try {
			age = input.nextInt();
		} catch (Exception e) {
			System.out.println("Enter the valid Input");
			getStudentAge();
		}
		if (age <= 17 || age >= 27) {
			System.out.println("Enter the valid Input");
			getStudentAge();
		}
		return age;
	}

	public int getDepartment() {
		int deptID=0;

		System.out.println("Courses available in engineering are:");
		for (String dept:enggDeptList
			 ) {
			System.out.println(dept);
		}
		System.out.println("Enter your Selected department ID:\t");
		try {
			deptID = input.nextInt();

		}
		catch (InputMismatchException exception){
			System.out.println("please enter valid input ID");
		}
		if (deptID<1||deptID>7) {
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
		System.out.print("Enter your mark:");
		try {
			mark = input.nextInt();
		} catch (Exception e) {
			System.out.println("Enter the valid Input");
			getStudentMark();
		}
		if (mark < 210 || mark > 600) {
			System.out.println("Enter the valid Input");
			getStudentMark();
		}
		return mark;
	}

	public int getStudentCutOff() {
		int cutOffMark = 0;
		System.out.print("Enter your Cut off mark:");
		try {
			cutOffMark = input.nextInt();
		} catch (Exception e) {
			System.out.println("Enter the valid Input");
			getStudentCutOff();
		}
		if (cutOffMark < 70 || cutOffMark > 200) {
			System.out.println("Enter the valid Input");
			getStudentCutOff();
		}
		return cutOffMark;
	}

	public void getEnggstudentDetails() {
		System.out.println("----------------------------------------------------------------------");
		System.out.println("\t\t\t\tEngineering Application Form");
		System.out.println("----------------------------------------------------------------------");
		addCourses();
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
		int cutOffMark = getStudentCutOff();
		if(dept==1&&cutOffMark<160){
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		}
		else if(dept==2&&cutOffMark<150){
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		}
		else if(dept==3&&cutOffMark<130){
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		}
		else if(dept==4&&cutOffMark<160){
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		}
		else if(dept==5&&cutOffMark<160){
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		}
		else if(dept==6&&cutOffMark<140){
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		}
		else if(dept==7&&cutOffMark<150){
			System.out.println("Sorry! You didn't have sufficient aggregate to pursue this course.\nBetter Luck next time......");
		}

		else{
			System.out.println("congratulations..!\n you are selected for "+enggDeptList.get(dept-1) );
			registerInDB(firstName,lastName,parentName,gender,mobileNumber,emailID,age,dept,schoolName,mark,cutOffMark);
		}

	}
}
