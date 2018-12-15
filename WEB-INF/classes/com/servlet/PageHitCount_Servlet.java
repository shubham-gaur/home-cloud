package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageHitCount_Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private int hitCount=0;

	public PageHitCount_Servlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		hitCount=5;
	}    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
	      response.setContentType("text/html");
	      // This method executes whenever the servlet is hit 
	      // increment hitCount 
	      hitCount++; 
	      PrintWriter out = response.getWriter();
	      out.println("<!DOCTYPE html>" +
	    	        "<html>\n" +
	    	        "<head><title>Hit Count</title></head>\n" +
	    	        "<body bgcolor='#f0f0f0'><center>\n" +
	    	        "<h1 align='center'>" + "Total Number of Hits:" + "</h1>\n" +
	    	        "<h2 align='center'>" + hitCount + "</h2>\n" +
	    	        "<form method='get' action='PageHitCount_Servlet'>" +
	    	        "<input type='submit' value='Hit Me !!!'></form>" + 
	    	        "</body></center></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void destroy() {
		hitCount=0;
	}
}
