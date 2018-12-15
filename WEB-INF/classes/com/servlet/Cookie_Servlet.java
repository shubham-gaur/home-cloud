package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookie_Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**Process the HTTP Get request*/ 
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {  

		Cookie c1 = new Cookie("userName", "seed"); 
		Cookie c2 = new Cookie("password", "nashik");
		c1.setMaxAge(1000*60*60);	// set age as 1 hour
		c2.setMaxAge(1000*60*60);	// set age as 1 hour
		response.addCookie(c1); 
		response.addCookie(c2); 

		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter(); 
		out.println("<HTML>"); 
		out.println("<HEAD>"); 
		out.println("<TITLE>Cookie Test</TITLE>"); 
		out.println("</HEAD>"); 
		out.println("<BODY>"); 
		out.println("Please click the button to see the cookies sent to you."); 
		out.println("<BR>"); 
		out.println("<FORM METHOD=POST>");		
		out.println("<INPUT TYPE=HIDDEN NAME=SEED VALUE=Nashik>"); 
		out.println("<INPUT TYPE=SUBMIT VALUE=Submit>"); 
		out.println("</FORM>"); 
		out.println("</BODY>"); 
		out.println("</HTML>"); 
	} 

	/**Process the HTTP Post request*/ 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException,IOException {

		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter(); 
		out.println("<HTML>"); 
		out.println("<HEAD>"); 
		out.println("<TITLE>Cookie Test</TITLE>"); 
		out.println("</HEAD>"); 
		out.println("<BODY>"); 
		out.println("<INPUT TYPE='HIDDEN' NAME='SEED' VALUE='Nashik'>");	
		out.println("<H2>Here are all the headers.</H2>"); 

		Enumeration enums = request.getHeaderNames(); 
		while (enums.hasMoreElements()) {
			String headerName = (String) enums.nextElement(); 
			out.print("<B>" + headerName + "</B>: "); 
			out.print(request.getHeader(headerName) + "<BR>"); 
		} 

		out.println("<BR><BR><H2>And, here are all the cookies.</H2>"); 
		Cookie[] cookies = request.getCookies();

		// enhanced for loop, introduced in Java 5...
		for(Cookie cookie: cookies) {
			out.println("<B>Cookie Name:</B> " + cookie.getName() + "<BR>"); 
			out.println("<B>Cookie Value:</B> " + cookie.getValue() + "<BR>"); 
		}

		/*	
		for (int i=0; i<cookies.length; i++) {
			Cookie cookie = cookies[i]; 
			out.println("<B>Cookie Name:</B> " + cookie.getName() + "<BR>"); 
			out.println("<B>Cookie Value:</B> " + cookie.getValue() + "<BR>"); 
		} 
		 */		
		out.println("Hidden Field:"+request.getParameter("SEED"));
		out.println("</BODY>"); 
		out.println("</HTML>"); 
	} 

}
