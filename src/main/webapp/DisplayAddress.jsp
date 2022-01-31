<%@page import="com.ty.hospital.dto.Address"%>
<%@page import="com.ty.hospital.dto.Branch"%>
<%@page import="com.ty.hospital.dto.Encounter"%>
<%@page import="com.ty.hospital.dto.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="AdminNavbar.jsp"%>
<form action="getaddress">
	<%
	List<Address> address=(List<Address>)request.getAttribute("addresslist");
%>
<table border="1">
	<tr>
		<th>ID</th>
		<th>Address</th>
	    <th>State</th>
		<th>Pin</th>
		
	</tr>
<% 
	
	for(Address address2 :address ) 
	{
			%>
			
			<tr>
				<td><%=address2.getId() %></td>
				<td><%=address2.getAdress() %></td>
				<td><%=address2.getState() %></td>
				<td><%=address2.getPin() %></td>
			
			</tr>
			
<%
		}
%>
	</form>
	
</table>
</body>
</html>