<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.service.StudentService"%>
<%@page import="com.ty.dto.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if (session.getAttribute("email") != null) {
	%>
	<%@include file="navbar.jsp"%>
	<%
		List<StudentDto> students = (ArrayList) request.getAttribute("studentslist");
	%>

	<h1>Students Table</h1>

	<table border="5px solid red" cellpadding=20px cellspacing=0px>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>PHONE</th>
			<th>EDIT</th>
			<th>DELETE</th>
		</tr>
		<%
			for (StudentDto student : students) {
		%>

		<tr>
			<td><%=student.getId()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getEmail()%></td>
			<td><%=student.getPhone()%></td>
			<td><a href="edit?id=<%=student.getId()%>">Edit</a></td>
			<td><a href="delete?id=<%=student.getId()%>">Delete</a></td>
		</tr>

		<%
			}
		%>

	</table>
	<%
		} else {
			response.sendRedirect("login.jsp");
		}
	%>

</body>
</html>