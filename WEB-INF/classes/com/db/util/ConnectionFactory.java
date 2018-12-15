package com.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	String dbDriver="com.mysql.jdbc.Driver";
	String dbUrl="jdbc:mysql://localhost:3306/cloud";
	String dbUser="root";
	String dbPassword="";

	private static ConnectionFactory connectionFactory=null;     
	
	private ConnectionFactory() {
		try {
			Class.forName(dbDriver);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ConnectionFactory getInstance() {	
		if(connectionFactory==null) {
			connectionFactory=new ConnectionFactory();
		}
		return connectionFactory;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	}

}

