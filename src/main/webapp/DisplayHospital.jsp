<%@page import="com.ty.hospital.dto.Hospital"%>
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
<form action="gethospitals">
	<%
	List<Hospital> hospitals=(List<Hospital>)request.getAttribute("hospitalslist");
%>
<table border="1">
	<tr>
		<th>ID</th>
		<th>Name</th>
	    <th>Website</th>
		<th>Gst</th>
		<th>Create Branch</th>
		<th>View Branch</th>
	</tr>
<% 
	
	for(Hospital hospital:hospitals ) 
	{
			%>
			
			<tr>
				<td><%=hospital.getId() %></td>
				<td><%=hospital.getName() %></td>
				<td><%=hospital.getWebsite() %></td>
				<td><%=hospital.getGst() %></td>
				<td>
					<a href="CreateBranch.jsp?hospitalid=<%= hospital.getId() %>">Create</a>
				</td>
				<td>
					<a href="getbranchs">View</a>
				</td>
			</tr>
			<%
		}
%>
			
	</form>
	
</table>
</body>
</html>