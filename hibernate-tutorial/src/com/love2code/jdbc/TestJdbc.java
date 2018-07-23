package com.love2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String JdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
			
			System.out.println("Connecting to Database" + JdbcUrl);
			Connection con = DriverManager.getConnection(JdbcUrl, user, password);
			System.out.println("Connection Successfull !!");
			con.close();
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}

	}

}
