<%@ page import="java.util.*, com.backendadmin.servlets.AddTeacherServlet" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
	<table border="2">
		<tr>
			<th>Id</th>
			<th>Teacher Name</th>
			<th>Email</th>
		</tr>
		
		<c:forEach var="teahcer" items="${teacher_list}">
			<tr>
				<td>${teahcer.getTeacher_id()}</td>
				<td>${teahcer.getName()}</td> 
				<td>${teahcer.getEmail()}</td>
				
			</tr>
			
		</c:forEach>
	</table>
</body>
</html>