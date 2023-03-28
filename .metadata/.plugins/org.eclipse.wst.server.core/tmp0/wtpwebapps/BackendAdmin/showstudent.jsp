<%@ page import="java.util.*, com.backendadmin.servlets.AddStudentServlet" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Students</title>
</head>
<body>
	<table border="2">
		<tr>
			<th>Students</th>
			<th>Email</th>
		</tr>
		
		<c:forEach var="student" items="${student_list}">
			<tr>

				<td>${student.getName()}</td> 
				<td>${student.getEmail()}</td>
				
			</tr>
			
		</c:forEach>
	</table>
</body>
</html>