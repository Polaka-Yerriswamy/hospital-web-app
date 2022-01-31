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
 String id=request.getParameter("encounterid"); 
%>
<%@ include file="PersonNavbar.jsp"%>
<form action="createorder" method="post">

Encounter Id:<input type="text" value="<%=id%>" name="encounterid" readonly="readonly"><br>
Message:<input type="text" name="orderMessage"><br>
CreateDateTime:
  <input type="datetime-local" name="orderDate"><br>

<input type="submit" value="submit">

</form>
</body>
</html>