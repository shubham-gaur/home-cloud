package com.servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

public class Context_Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	String dbDriver, dbUrl, dbUser, dbPassword;
	
	public Context_Servlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		ServletContext context = getServletContext();
		
		System.out.println("Context_Servlet->init...");
    	dbDriver=context.getInitParameter("db_driver");
    	dbUrl=context.getInitParameter("db_url");
    	dbUser=context.getInitParameter("db_user");
    	dbPassword=context.getInitParameter("db_password");
    	
    	System.out.println("DbDriver:"+dbDriver+"\tDbUrl:"+dbUrl+"\tDbUser:"+dbUser+"\tPassword:"+dbPassword);
    	
    	// print all the init parameters of a servlet context...
    	System.out.println("\nContext_Servlet->printing InitParameterNames...");
    	Enumeration<String> enums = config.getInitParameterNames();
    	while(enums.hasMoreElements()){
    		String name=enums.nextElement();
    		System.out.println(name + ":" + context.getInitParameter(name));
    	}
    	
		System.out.println("\nContext_Servlet->printing AttributeNames...");
		Enumeration<String> enums2=context.getAttributeNames();
		while(enums2.hasMoreElements()){
			String name=enums2.nextElement();
			System.out.println(name + ":" + context.getAttribute(name));
		}
	
		System.out.println("Context_Servlet->Datesource is laoded...");

		try {
			//Context initialContext  = (Context)new InitialContext().lookup("java:/comp/env");
			//DataSource ds1 = (DataSource)initialContext.lookup("jdbc/CDGI_DS");
			DataSource ds = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/CDGI_DS");
			Connection con = ds.getConnection();
			System.out.println("Connection:"+con);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
