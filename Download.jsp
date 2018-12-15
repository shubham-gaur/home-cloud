<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="CSS/style.css">

<h1 > Welcome: <%=session.getAttribute("Uname") %></h1>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
<form  align = "center" action="Download_Servlet">
<table align ="center" >
	<tr>
		<td><h4 id="file" align = "center" class="form" style="opacity:0.8"><input type="submit" name="fname" value ="hi.txt"></h4></a></td>
		<td><h4 id="image" align = "center" class="form" style="opacity:0.8"><input type="submit" name="fname" value ="flower.png"></h4></a></td>
		<td><h4 id="image" align = "center" class="form" style="opacity:0.8"><input type="submit" name="fname" value ="olive.jpg"></h4></a></td>
	<tr>
</table>
</form>
<form class="form" style="opacity:0.8"><button type="submit">Log out</button></form> 
</body> 
</body>
</html>