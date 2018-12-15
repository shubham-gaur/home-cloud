package com.servlet;

import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Config_Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	String dbDriver, dbUrl, dbUser, dbPassword;
	
    public Config_Servlet() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	
    	System.out.println("Config_Servlet->init...");
    	dbDriver=config.getInitParameter("db_driver");
    	dbUrl=config.getInitParameter("db_url");
    	dbUser=config.getInitParameter("db_user");
    	dbPassword=config.getInitParameter("db_password");
    	
    	System.out.println("DbDriver:"+dbDriver+"\tDbUrl:"+dbUrl+"\tDbUser:"+dbUser+"\tPassword:"+dbPassword);
    	
    	// prints all the init parameters of a servlet config...
    	Enumeration<String> enums = config.getInitParameterNames();
    	while(enums.hasMoreElements()){
    		String name=enums.nextElement();
    		System.out.println(name + ":" + config.getInitParameter(name));
    	}
    	
    }
    
}
