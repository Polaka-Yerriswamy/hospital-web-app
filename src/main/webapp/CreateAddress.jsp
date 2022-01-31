<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="createaddress" method="post">

<% 
 String id=request.getParameter("branchid"); 
%>
<%@ include file="AdminNavbar.jsp"%>

Branch Id:<input type="text" value="<%=id%>" name="branchid" readonly="readonly"><br>
Address:<input type="text" name="Address"><br>
State:<input type="text" name="State"><br>
Pin:<input type="number" name="Pin"><br>

<input type="submit" value="submit">
</form>
</body>
</html>