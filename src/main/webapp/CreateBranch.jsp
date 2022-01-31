<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
 String id=request.getParameter("hospitalid"); 
%>
<%@ include file="AdminNavbar.jsp"%>
<form action="createbranch" method="post">

Hospital Id:<input type="text" id="hid" value="<%=id%>" name="hospitalid" readonly="readonly"><br>
Name:<input type="text" name="branchName"><br>
Email:<input type="text" name="branchEmail"><br>
Phone:<input type="number" name="branchPhone"><br>

<input type="submit" value="submit">
</form>

</body>
</html>