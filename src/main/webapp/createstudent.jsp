<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%if (session.getAttribute("email") != null) {%>
	<%@include file="navbar.jsp"%>
	<h1>WELCOME TO SCHOOL APP</h1>
	
	<form action="save" >
	Name : &nbsp <input type="text" name="name" ><br><br>
	Email : &nbsp <input type="text" name="email" ><br><br>
	Phone : &nbsp <input type="text" name="phone" ><br><br>
	 &nbsp  &nbsp<input type="submit" value="save" ><br><br>
	</form>
	<%} else {
		response.sendRedirect("login.jsp") ; }%>
</body>
</html>