<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, com.example.*" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered User Account</title>
</head>

<% RegisteredUser user = (RegisteredUser) request.getAttribute("REGISTERED_USER"); %>

<body>

	<h2>Hello, ${REGISTERED_USER.userName }</h2>
	<p> ${REGISTERED_USER.email } </p>
	<hr>
	
	<h3>Wished List</h3>
	<ul>
		<% for(Movie movie: user.getWishedMovies()) {%>
		<li> <%= movie.getName() %> </li>
		<% } %>
	</ul>
	<br><hr><br>
	<a href="http://localhost:8091/Oop_demo1/RUserControllerServlet?command=LOAD&UserId=${REGISTERED_USER.id }">Edit Profile</a>
</body>
</html>