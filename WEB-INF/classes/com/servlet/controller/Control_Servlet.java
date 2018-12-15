package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Control_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Control_Servlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String base = "/";
	    String url = base + "Login.jsp"; 
	    String action = request.getParameter("action"); 
	    if(action==null)
	    {
	    	url=base+"uploaderMechanism.jsp";
	    }
	    if (action!=null) {
			if (action.equals("LoginPage")) 
				url =base +"LoginCheck.jsp";
			else if(action.equals("CheckTrue"))
				url =base +"Account.jsp";
			else if(action.equals("CheckFalse"))
			{
				response.setHeader("Refresh", "5; URL=" +base+"Login.jsp");
				PrintWriter p = response.getWriter();
				p.print("<h1> The Login is incorrect! U will be redirected to login page... </h1>");
			}
			else if(action.equals("uploadFile"))
					{
						url=base+"FileUpload.jsp";
					}
			else if(action.equals("uploader"))
				{
				url=base+"uploaderMechanism.jsp";
				}
	    }

	    try {
	    	Thread.sleep(5000);
	    } catch (InterruptedException e) {
	    	e.printStackTrace();
	    }
	    
	    
	    System.out.println("Action:"+action+"\tUrl:"+url);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url); 
		
		requestDispatcher.forward(request, response); 

	} 

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		doGet(req, resp);
	}
}