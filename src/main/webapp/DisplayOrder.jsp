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
<form action="getorders">
	<%
	List<Orders> orders=(List<Orders>)request.getAttribute("orderslist");
%>
<table border="1">
	<tr>
		<th>ID</th>
		<th>Admitted Date Time</th>
	    <th>Message</th>
		<th>Created By</th>
		<th>Create Item</th>
		<th>View Item</th>
	
	</tr>
<% 
	
	for(Orders order :orders ) 
	{
			%>
			
			<tr>
				<td><%=order.getId() %></td>
				<td><%=order.getCreatedDateTime() %></td>
				<td><%=order.getMessage() %></td>
				<td><%=order.getCreatorName() %></td>
				<td>
					<a href="CreateItem.jsp?orderid=<%= order.getId() %>">Create</a>
				</td>
				<td>
					<a href="getitems">View</a>
				</td>
				
			</tr>
			
<%
		}
%>
	</form>
	
</table>
</body>
</html>