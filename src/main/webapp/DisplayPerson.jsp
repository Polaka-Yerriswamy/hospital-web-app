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
<form action="getpersons">
	<%
	List<Person> persons=(List<Person>)request.getAttribute("personslist");
%>
<table border="1">
	<tr>
		<th>ID</th>
		<th>Name</th>
	    <th>Email</th>
		<th>Phone</th>
		<th>Gender</th>
		<th>Age</th>
		<th>Create Encounter</th>
		<th>View Encounter</th>
	</tr>
<% 
	
	for( Person person : persons) 
	{
			%>
			
			<tr>
				<td><%=person.getId() %></td>
				<td><%=person.getName() %></td>
				<td><%=person.getEmail() %></td>
				<td><%=person.getPhone() %></td>
				<td><%=person.getGender() %></td>
				<td><%=person.getAge() %></td>
				
				<td>
					<a href="CreateEncounter.jsp?personid=<%= person.getId() %>">Create</a>
				</td>
				<td>
					<a href="getencounters?personid=<%= person.getId() %>">View</a>
				</td>
			</tr>
			
<%
		}
%>
	</form>
	
</table>
</body>
</html>