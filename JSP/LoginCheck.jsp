<%@ 
	page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@ 
	page import ="com.dao.Login_DAO,com.dao.Login_DAOImpl,com.bean.Login" 
%>

<%@ 
	page import ="java.util.ArrayList,java.sql.SQLException" 
%>

<%@ 
	page session="true" 
%>

</head>
<body>
<jsp:useBean id="login" class="com.bean.Login" scope = "session"></jsp:useBean>
<jsp:setProperty property="username" name="login" param="txtUserName"/>
<jsp:setProperty property="password" name="login" param="txtPassword"/>
<%
	Login_DAO loginDAO=new Login_DAOImpl();
	RequestDispatcher dispatcher = null;
	try {
		if(loginDAO.isValid(login)) 
		{
%>
<input type = "hidden" name="action" value ="CheckTrue">
<jsp:forward page="Control_Servlet"></jsp:forward>

<%
		}
		else 
			{
%>
	<input type = "hidden" name="action" value ="CheckFalse">
	<jsp:forward page="Control_Servlet"></jsp:forward>
<% 			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	%>
</body>
</html>