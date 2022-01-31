<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	String name=(String)session.getAttribute("name");
	String role=(String)session.getAttribute("role");
	if(name==null || role==null) {
		response.sendRedirect("Login.jsp");
	}
	if(role !=null && !role.equals("admin")) {
		response.sendRedirect("Login.jsp");
	}
%>
<h1> welcome to staff home page</h1>
</body>
</html>