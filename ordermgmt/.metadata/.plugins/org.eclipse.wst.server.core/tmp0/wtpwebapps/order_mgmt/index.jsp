<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authentication page</title>
</head>
<body>
	<form action="userAuth" method="get">
	Username: <input type="text" name="username"><br><br>
	Password: <input type="password" name="password"><br><br>
	<a href="signup.jsp">Sign Up</a><br><br>
	<input type="hidden" value=<%=request.getParameter("prodid")%> name="id"></input>
	<input type="submit" value="Submit">
	</form>
</body>
</html>