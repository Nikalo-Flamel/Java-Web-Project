<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

<%
	//setting the default
	String userType = "user";
	
	Cookie[] cookies = request.getCookies();
		
	if(cookies != null) {
		for (Cookie cookie: cookies) {
			if ("user".equals(cookie.getName())) {
				userType = cookie.getValue();
				break;
			}
		}	
	}
	System.out.println(userType);
%>

</head>
<body>

	<h1>Home</h1>
	
	<% if (userType.equals("RegisteredUser")) {%>
		<a href="/Oop_demo1/RUserControllerServlet?command=ACCOUNT&UserId=<%= request.getParameter("UserId")%>">Account</a>
		<a href="/Oop_demo1/LoginControllerServlet">Logout </a>
	<% } %>

	<% if (userType == "") { %>
		<a href="/Oop_demo1/login.jsp">Login</a>
	<% } %>
	


</body>
</html>