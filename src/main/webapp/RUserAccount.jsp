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

	<h2>Hello, <%= user.getUserName() %></h2>

</body>
</html>