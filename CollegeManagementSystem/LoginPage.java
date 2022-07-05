package Org.Zsgs.CollegeManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class LoginPage {
    Scanner input = new Scanner(System.in);
    void getLoginDetails(){
        try {
            String url = "jdbc:mysql://localhost:3306/myCollege";
            String username = "root";
            String pass = "Prema@12345";
            Connection con = DriverManager.getConnection(url, username, pass);
            String query = "insert into Polytechnic_Student_Details(Student_First_Name,Student_Last_Name,Parent_Name,Student_Gender,Contact_Number,Mail_ID,Student_age,Department_ID ,School_Name,10th_Mark) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement smt = con.prepareStatement(query);}
        catch (Exception ex) {
            System.out.println("Not Connected");
            ex.printStackTrace();
        }
        System.out.println("Enter Your User Name :");
        String userName = input.nextLine();
        System.out.println("Enter Your Account password:");
        String password = input.nextLine();

        if(userName.equalsIgnoreCase("admin")&&password.equals("Password")){
            System.out.println("----------------------------------------------------------------------");
            System.out.println("\t\t\t\tWelcome Admin ");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("1.view student details");
            System.out.println("2.Edit student details");
            System.out.println("3.Upload student mark");
            System.out.println("Enter Your Option :");
            int adminOption = input.nextInt();
        }

//        else if(userName.equalsIgnoreCase()&&password.equals())
    }
}
