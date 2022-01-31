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
 String personid=request.getParameter("personid"); 
%>
<%@ include file="PersonNavbar.jsp"%>
<form action="createencounter" method="post">

Person Id:<input type="text" value="<%=personid%>" name="personid" readonly="readonly"><br>
Admitted Date Time: <input type="datetime-local" name="encounterDate"><br>
Reason :<textarea rows="10" cols="20" name="encounterReason"></textarea>


<input type="submit" value="submit">

</form>
</body>
</html>