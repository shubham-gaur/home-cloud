<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/style.css">
<title>Welcome...</title>
</head>
<body >
<div class="login-page">
  <div class="form">
    <form class="login-form" action = "Control_Servlet" method ="post">
    <input type = "hidden" name ="action" value = "LoginPage">
      <input type="text" placeholder="email" name="email"/>
      <input type="password" placeholder="password" name="pass"/>
      <button type="submit">login</button>
      <p class="message">Not registered? <a href="Register.jsp">Create an account</a></p>
    </form>
  </div>
</div>
<footer class="form" id="foot" style="opacity:0.95">
          <div class="button">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="submit"></h5>
                <h3 class="grey-text text-lighten-4" class="form">Created by</h3>
                 <h3 class="grey-text text-lighten-4" class="form">Kapish Shewale, Priya Kanojia &   Shubham Gaur.</h3>
              </div>
              <div class="col l4 offset-l2 s12">
                <ul>
                  <li><a class="grey-text text-lighten-3" href="register.jsp">www.Google.co.in</a></li>
                 </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            © 2014 Copyright Text
            <a class="grey-text text-lighten-4 right" href="Register.jsp">Link1</a>
            </div>
          </div>
        </footer>
</body>
</html>