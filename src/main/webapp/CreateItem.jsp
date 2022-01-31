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
 String orderid=request.getParameter("orderid"); 
%>
<%@ include file="PersonNavbar.jsp"%>
<form action="createitem" method="post">

Order Id:<input type="text" value="<%=orderid%>" name="orderid" readonly="readonly"><br><br>
Name:<input type="text" name="itemName"><br><br>
Quantity:<input type="number" name="itemQuantity"><br><br>
price:<input type="number" name="itemPrice"><br><br>
Message:<input type="text" name="itemMessage"><br><br>

<input type="submit" value="submit">
</form>
</body>
</html>