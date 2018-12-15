package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.Login;
import com.db.util.ConnectionFactory;

public class Login_DAOImpl implements Login_DAO {

	public boolean isValid(Login login) throws SQLException {
			boolean isValid=false;
			Connection con = ConnectionFactory.getInstance().getConnection();
			String uname=login.getUsername();
			String upass=login.getPassword();
			Statement stat=con.createStatement();
			ResultSet rs = stat.executeQuery("select * from user_details");
			if(rs.next()) {
				String dnam=rs.getString("e_mail");
				String dpass=rs.getString("password");
				
				System.out.println("name:" + uname + "|" + dnam);
				System.out.println("pass:" + upass + "|" + dpass);
				if(dnam.equals(uname) && dpass.equals(upass))
				{
					System.out.println("setting isvalid true");
					isValid =true; 
				}
			}
			rs.close();
			stat.close();
			con.close();
			return isValid;
	}

	    
}
