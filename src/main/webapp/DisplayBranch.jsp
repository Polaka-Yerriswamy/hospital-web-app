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
<form action="getbranchs">
	<%
	List<Branch> branchs=(List<Branch>)request.getAttribute("branchslist");
%>
<table border="1">
	<tr>
		<th>ID</th>
		<th>Name</th>
	    <th>Phone</th>
		<th>Email</th>
		<th>Create Address</th>
		<th>View  Address</th>
	</tr>
<% 
	
	for(Branch branch :branchs ) 
	{
			%>
			
			<tr>
				<td><%=branch.getId() %></td>
				<td><%=branch.getName() %></td>
				<td><%=branch.getEmail() %></td>
				<td><%=branch.getPhone() %></td>
				
				<td>
					<a href="CreateAddress.jsp?branchid=<%= branch.getId() %>">Create</a>
				</td>
				<td>
					<a href="getaddress">View</a>
				</td>
			</tr>
			
<%
		}
%>
	</form>
	
</table>
</body>
</html>