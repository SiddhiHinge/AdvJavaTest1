<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h3>Login Page</h3>
<form action="login" method = "post">
<input type="hidden" name="requestAction" value="login">
<table>
<tr>
<td>Username : </td>
<td><input type = "text" name = "username"></td>
</tr>
<tr>
<td>Password : </td>
<td><input type = "text" name = "password"></td>
</tr>
</table>
<input type="submit" value = "Login"> 
<%
			if (request.getAttribute("loginStatus") != null) {
				if (request.getAttribute("loginStatus").equals(false)) {
		%>
		<p><%="Invalid Credentials !" %></p>
		<%
				}
				else {%>
		<p><%="Logged out successfully !" %></p>
		<% 		}
				}
		%>
</form>
</body>
</html>