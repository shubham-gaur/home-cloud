package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionHitCount_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SessionHitCount_Servlet() {
		super();
	}

	public void doGet(HttpServletRequest request, 
			HttpServletResponse response)
					throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Integer count = new Integer(0);
		String head;
		if (session.isNew()) {
			head = "This is the New Session";
		} else {
			head = "This is the old Session";
			Integer oldcount =(Integer)session.getValue("count"); 
			if (oldcount != null) {
				count = new Integer(oldcount.intValue() + 1);
			}
		}
		session.putValue("count", count);
		out.println("<HTML><BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H2 ALIGN=\"CENTER\">" + head + "</H2>\n" + 
				"<TABLE BORDER=1 ALIGN=CENTER>\n"
				+"<TR BGCOLOR=\"#FFAD00\">\n" 
				+" <TH>Information Type<TH>Session Count\n" 
				+"<TR>\n" +" <TD>Total Session Accesses\n" +
				"<TD>" + count + "</TD></TR>\n" +
				"</TABLE>\n" 
				+"</BODY></HTML>" );
	}
}
