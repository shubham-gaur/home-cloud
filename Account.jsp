<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/style.css">

<h1 > Welcome: <%=session.getAttribute("Uname") %></h1>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
<form action = "Control_Servlet" align = "center" >
<input type = "hidden" name ="action" value = "uploadFile">

<table align ="center" >
	<tr>
		<td><h4 align = "center" class="form" style="opacity:0.8" ><button  type ="submit" value ="Upload new File">Upload new File</h4></td>
		<td><a  href="Download.jsp"><h4 align = "center" class="form" style="opacity:0.8"><button id="submit" type ="button" value ="Download File">Download File</h4></a></td>
	<tr>
</table>
</form>
<form class="form" style="opacity:0.8"><button type="submit">Log out</button></form> 
</body>
</html>