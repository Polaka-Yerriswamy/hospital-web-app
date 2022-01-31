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
<form action="getencounters">
	<%
	List<Encounter> encounters=(List<Encounter>)request.getAttribute("encounterslist");
%>
<table border="1">
	<tr>
		<th>ID</th>
		<th>Admitted Date Time</th>
	    <th>Reason</th>
		<th>Created By</th>
		<th>Create Order</th>
		<th>View Order</th>
	</tr>
<% 
	
	for(Encounter encounter :encounters ) 
	{
			%>
			
			<tr>
				<td><%=encounter.getId() %></td>
				<td><%=encounter.getCreatedDateTime() %></td>
				<td><%=encounter.getReason() %></td>
				<td><%=encounter.getCreatorName() %></td>
				
				<td>
					<a href="CreateOrder.jsp?encounterid=<%= encounter.getId() %>"">Create</a>
				</td>
				<td>
					<a href="getorders">View</a>
				</td>
			</tr>
			
<%
		}
%>
	</form>
	
</table>
</body>
</html>