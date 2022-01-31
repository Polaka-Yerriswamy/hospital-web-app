<%@page import="com.ty.hospital.dto.Items"%>
<%@page import="com.ty.hospital.dto.Orders"%>
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
<%@include file="PersonNavbar.jsp"%>
<form action="getitems">
	<%
	List<Items> items=(List<Items>)request.getAttribute("itemslist");
%>
<table border="1">
	<tr>
		<th>Name</th>
		<th>Quantity</th>
	    <th>Message</th>
		<th>Price</th>

	
	</tr>
<% 
	
	for(Items item :items ) 
	{
			%>
			
			<tr>
				<td><%=item.getName() %></td>
				<td><%=item.getQuantity() %></td>
				<td><%=item.getMessage() %></td>
				<td><%=item.getPrice() %></td>
				
				
			</tr>
			
<%
		}
%>
	</form>
	
</table>
</body>
</html>