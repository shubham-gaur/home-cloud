package com.servlet;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

public class DataSource_Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			//Context initialContext  = (Context)new InitialContext().lookup("java:/comp/env");
			//DataSource ds1 = (DataSource)initialContext.lookup("jdbc/CDGI_DS");
			DataSource ds = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/SERVLET_DS");
			Connection con = ds.getConnection();
			System.out.println("DataSource_Servlet->Connection:"+con);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
