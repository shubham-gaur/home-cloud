package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register_Servlet extends HttpServlet { 

	private static final long serialVersionUID = 1L;

	public Register_Servlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Exception: "+ex.getMessage()+" Thrown by: "+ex.getClass().getSimpleName());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// http://localhost:8080/JAVA_Servlet/Register_Servlet?txtUserName=cdgi&txtPassword=indore
		String username=request.getParameter("txtUserName");
		String password=request.getParameter("txtPassword");

		System.out.println("txtUserName:"+username+"\t txtPassword:"+password);

		registerLogin(username, password);	
		//request.getRequestDispatcher("Login.html").forward(request, response);
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("Login.html");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	} 

	private void registerLogin(String username, String password) {
		try (Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SERVLET", "root", "");
				PreparedStatement pstat=con.prepareStatement("INSERT INTO Login VALUES(?, ?");
				){
			pstat.setString(1, username);
			pstat.setString(2, password);
			pstat.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Exception: "+ex.getMessage()+" Thrown by: "+ex.getClass().getSimpleName());
		}

	}

}