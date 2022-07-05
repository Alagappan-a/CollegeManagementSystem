package Org.Zsgs.CollegeManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplicationForm {
	Scanner input = new Scanner(System.in);
	String getFirstName() {
		System.out.print("Enter Student first Name:");
		String studentName = input.nextLine();
		Pattern pattern = Pattern.compile("[^a-zA-Z]");
		Matcher matcher = pattern.matcher(studentName);
		boolean isStringContainsSpecialCharacter = matcher.find();
		if (isStringContainsSpecialCharacter) {
			System.out.println("Please Enter a valid name ");
			getFirstName();
		}
		return studentName;
	}

	String getLastName() {
		System.out.print("Enter Student last Name:");
		String name = input.nextLine();
		Pattern pattern = Pattern.compile("[^a-zA-Z]");
		Matcher matcher = pattern.matcher(name);
		boolean isStringContainsSpecialCharacter = matcher.find();
		if (isStringContainsSpecialCharacter) {
			System.out.println("Please Enter a valid name ");
			getLastName();
		}
		return name;
	}

	String getParentsName() {
		System.out.print("Enter parent's Name:");
		String parentName = input.nextLine();
		Pattern pattern = Pattern.compile("[^a-zA-Z]");
		Matcher matcher = pattern.matcher(parentName);
		boolean isStringContainsSpecialCharacter = matcher.find();
		if (isStringContainsSpecialCharacter) {
			System.out.println("Please Enter a valid name ");
			getParentsName();
		}
		return parentName;
	}

	String getStudentGender() {
		System.out.print("Enter Student Gender:\n(i.e:'male'(or)'female'(or)'transgender'");
		String studentGender = input.nextLine();
		String[] gender = {"male","female","transgender"};
		if (!(studentGender.equals(gender[0])||studentGender.equals(gender[1])||studentGender.equals(gender[2]) ) ){
			System.out.println("Please Enter a valid Gender ");
			getStudentGender();
		} 
		return studentGender;
	}
	String getNumber() {
		System.out.print("Enter Contact Number:");
		String mobileNumber = input.nextLine();
		Pattern pattern = Pattern.compile("[^0-9]");
		Matcher matcher = pattern.matcher(mobileNumber);
		boolean isStringContains = matcher.find();
		if (isStringContains || mobileNumber.length()!=10) {
			System.out.println("Please Enter a valid number ");
			getNumber();
		}
		return mobileNumber;
	}
	String getMailID() {
		System.out.println("Enter the emailID:\t");
		String emailId = input.nextLine();
		String domain = "@";
		String com = ".com";
		String in = ".in";
		if (emailId.indexOf(domain) == emailId.lastIndexOf(domain) && emailId.indexOf(domain) != 0
				&& emailId.charAt(0) != '.') {
			if (emailId.contains(domain) && (emailId.contains(in) || (emailId.contains(com)))) {
				System.out.println("entered email address is a valid email address");
			} else {
				System.out.println("entered email address is not a valid email address");
				getMailID();
			}
		} else {
			System.out.println("entered email address is not a valid email address");
			getMailID();
		}
		return emailId;
	}




	

	

}
