package com.love2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setup a connection variable
		String user = "springstudent";
		String pass = "springstudent";
		//DB URL
		String dbURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		//get the connection URL
		
		try {
			
			PrintWriter out = response.getWriter();
			out.println("Connecting to database : " +dbURL);
			Class.forName(driver);
			Connection con = DriverManager.getConnection(dbURL, user, pass);
			out.println("Successfully connected");
			con.close();
			
		}catch(Exception exc) {
			exc.printStackTrace();
			
		}
		
	}

}
