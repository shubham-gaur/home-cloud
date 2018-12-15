<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/style.css">
<title>Insert title here</title>
</head>
<body>

<form action ="Control_Servlet" method=post enctype=MULTIPART/FORM-DATA class="form" style="opacity:1">
<input type = "hidden" name ="action" value = "uploader">
<table align ="center"> 
	<tr>
		<td><h4 align ="center" ><input type=file name=fileName></h4> 
		<button type=submit value ="UPLOAD FILE">UPLOAD</td>
		
	</tr> 
</table>
</form>
</body>
</html>