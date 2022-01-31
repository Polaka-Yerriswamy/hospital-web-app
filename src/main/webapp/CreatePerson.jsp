<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="PersonNavbar.jsp" %>
<form action="person">

Name :<input type="text" name="personName"><br><br>
Email:<input type="text" name="personEmail"><br><br>
Gender:<input type="radio" id="male" name="personGender" value="Male">
  <label for="html">Male</label>
  <input type="radio" id="female" name="personGender" value="Female">
  <label for="css">Female</label><br><br>
Age:<input type="number" name="personAge"><br><br>
Phone:<input type="number" name="personPhone"><br><br>

<input type="submit" value="submit">
</form>
</body>
</html>