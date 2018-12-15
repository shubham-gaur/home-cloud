package com.dao;
import com.bean.Login;
import java.sql.SQLException;

public interface Login_DAO {

	public boolean isValid(Login login) throws SQLException;
}