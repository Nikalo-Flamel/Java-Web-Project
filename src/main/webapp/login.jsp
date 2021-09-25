<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<h1>Login</h1>
	<hr><br>
	
	<form action="/Oop_demo1/LoginControllerServlet" method="post">
			
			<table>
				<tr>
					<td><label>User Name : </label> </td>
					<td><input type="text" name="userName"> </td>
				</tr>
				<tr>
					<td><label>Password: </label> </td>
					<td><input type="text" name="password"> </td>
				</tr>
				<tr>
					<td><label></label> </td>
					<td><input type="submit" value="Save"> </td>
				</tr>
			</table>
		</form>
	
</body>
</html>