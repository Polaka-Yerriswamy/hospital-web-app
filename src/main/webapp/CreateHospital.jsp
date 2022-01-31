<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="AdminNavbar.jsp" %>
<form action="createhospital">

Name:<input type="text" name="hospitalName"><br><br>
Website:<input type="text" name="hospitalWebsite"><br><br>
GST:<input type="number" name="hospitalGst"><br><br>

<input type="submit" value="submit">
</form>
</body>
</html>