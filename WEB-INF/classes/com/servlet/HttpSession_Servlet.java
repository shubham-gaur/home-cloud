package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpSession_Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {

		// true to get new session...
		HttpSession session = request.getSession(true);	
		session.setMaxInactiveInterval(1000*60*60);
		session.setAttribute("userName", "seed");
		session.setAttribute("password", "nashik");

		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter(); 
		out.println("<HTML>"); 
		out.println("<HEAD>"); 
		out.println("<TITLE>HttpSession Test</TITLE>"); 
		out.println("</HEAD>"); 
		out.println("<BODY>"); 
		out.println("Please click the button to see the Http Session attributes."); 
		out.println("<BR>"); 
		out.println("<FORM METHOD=POST>"); 
		out.println("<INPUT TYPE=SUBMIT VALUE=Submit>"); 
		out.println("</FORM>"); 
		out.println("</BODY>"); 
		out.println("</HTML>"); 
	} 

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {

		// gets the existing session...
		HttpSession session = request.getSession();	
		
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter(); 
		out.println("<HTML>"); 
		out.println("<HEAD>"); 
		out.println("<TITLE>Http Session Test</TITLE>"); 
		out.println("</HEAD>"); 
		out.println("<BODY>");
		out.println("<BR><H2>Session Details...</H2>");
		out.println("Session ID:"+session.getId()+"<BR>");
		out.println("Creation Time:"+new Date(session.getCreationTime())+"<BR>");
		out.println("Last Access Time:"+new Date(session.getLastAccessedTime())+"<BR>");
		//session.invalidate()
		
		out.println("<BR><H2>And, here are all the HttpSession Attributes.</H2>");
		
		Enumeration enums = session.getAttributeNames();
		while (enums.hasMoreElements()) {
			String attributeName = (String) enums.nextElement(); 
			out.print("<B>" + attributeName + "</B>: "); 
			out.print(session.getAttribute(attributeName) + "<BR>"); 
		} 

		out.println(session.getAttribute("userName"));
		out.println(session.getAttribute("password"));
		
		session.invalidate();		// invalidate the session...
		out.println("</BODY>"); 
		out.println("</HTML>"); 
	} 

}
