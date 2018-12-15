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
<% System.out.println("This workddddd"); %>
<jsp:useBean id="login" class="com.bean.Login" scope = "session"></jsp:useBean>
<jsp:setProperty property="username" name="login" param="email"/>
<jsp:setProperty property="password" name="login" param="pass"/>
<%
	String email =request.getParameter("email");
	String pass =request.getParameter("pass");
	System.out.println(email);
	System.out.println(pass);
	Login_DAO loginDAO=new Login_DAOImpl();
	RequestDispatcher dispatcher = null;
	try {
		if(loginDAO.isValid(login)) 
		{
			System.out.println("Sucessful!");
			session.setAttribute("flag", 1);
			session.setAttribute("Uname",login.getUsername());
%>
	
	<jsp:forward page="Control_Servlet">
		<jsp:param value="CheckTrue" name="action"/>			
	</jsp:forward>
<%
		}
		else 
			{
			System.out.println("UnSucessful!");	

				/* */
%>
	<jsp:forward page="Control_Servlet">
		<jsp:param value="CheckFalse" name="action"/>			
	</jsp:forward>
<% 			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	%>
</body>
</html>