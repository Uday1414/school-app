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

	<%
		StudentDto dto = (StudentDto) request.getAttribute("student");
	%>
	<form action="update">
		Id : &nbsp <input type="text" name="id" value="<%=dto.getId()%>"
			readonly="readonly"><br>
		<br> Name : &nbsp<input type="text" name="name"
			value="<%=dto.getName()%>"><br>
		<br> Email : &nbsp<input type="text" name="email"
			value="<%=dto.getEmail()%>"><br>
		<br> Phone : &nbsp<input type="text" name="phone"
			value="<%=dto.getPhone()%>"><br>
		<br> <input type="submit" value="update">
	</form>
	<%
		} else {
			response.sendRedirect("login.jsp");
		}
	%>

</body>
</html>