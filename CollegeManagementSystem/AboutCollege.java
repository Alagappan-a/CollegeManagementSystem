package Org.Zsgs.CollegeManagementSystem;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AboutCollege {
	HomePage myHP = new HomePage();

	void readAboutCollege() {

		FileReader myReader = null;
		Scanner myScanner = null;
		try {
			myReader = new FileReader("D:\\my college\\About XYZ university.txt");
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
