package com.servlet.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class FileUpLoad_Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		StringBuffer htmlContent=new StringBuffer();
		htmlContent.append("<html><head><title>Servlet Examples...</title></head><body><p>Upload a File...</p>");

		htmlContent.append("<form method=post enctype=MULTIPART/FORM-DATA>");
		htmlContent.append("<input type=file name=fileName><br><input type=submit></form></body></html>");

		out.println(htmlContent.toString());
		out.flush();
		out.close();
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		System.out.println("in doGet()...");

		MultipartRequest m=new MultipartRequest(request,"d://Sandip");  
		response.getWriter().println("successfully uploaded"); 
		
		/*response.setContentType("text/plain");
		PrintWriter out = response.getWriter();

		String fileName = request.getParameter("fileName");
		System.out.println("File to UpLoad:"+fileName);
		FileInputStream is = new FileInputStream(fileName);
		int ch;
		while ((ch = is.read()) >= 0)
			out.print((char) ch);
		is.close();*/

	}

}
