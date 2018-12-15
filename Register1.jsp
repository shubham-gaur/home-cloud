<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.SQLException,com.bean.Register,java.util.*,java.sql.*, com.db.util.ConnectionFactory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%-- <jsp:useBean id="register" class="com.bean.Register"/>
<jsp:setProperty property="email" name="register" param="email"/>
<jsp:setProperty property="password" name="register" param="password"/> --%>

<body>
<%
	String email=request.getParameter("email");
	String password=request.getParameter("password");
	String fname=request.getParameter("fname");
	String lname=request.getParameter("lname");
	boolean isValid=true;
	Connection con=ConnectionFactory.getInstance().getConnection();
	String sql="SELECT * FROM user_details WHERE email=? AND password=?";
	PreparedStatement pstat=con.prepareStatement(sql);
	pstat.setString(1, email);
	pstat.setString(2, password);
	ResultSet rs=pstat.executeQuery();
	if(rs.next())
	{
		isValid =false;
	}
	
	
	if(isValid)
	{
	 	try (Connection conn=ConnectionFactory.getInstance().getConnection();
				PreparedStatement pstatt=con.prepareStatement("INSERT INTO user_details VALUES(?,?,?, ?)");)
				{
			pstatt.setString(1, email);
			pstatt.setString(2, password);
			pstatt.setString(3, fname);
			pstatt.setString(4, lname);
			pstatt.executeUpdate();
			System.out.println("Values entered in database");
			pstatt.close();
			conn.close();
			%>
			<jsp:forward page="Login.jsp"></jsp:forward>
			
			<%
			
		} catch (SQLException ex) {
			System.out.println("Exception: "+ex.getMessage()+" Thrown by: "+ex.getClass().getSimpleName());
		}
		
	}
	else
	{
	 %>
		
	<jsp:forward page="Register.jsp"></jsp:forward>	
		
		
	<% 
	}
	
	rs.close();
	pstat.close();
	con.close();

%>
</body>
</html>