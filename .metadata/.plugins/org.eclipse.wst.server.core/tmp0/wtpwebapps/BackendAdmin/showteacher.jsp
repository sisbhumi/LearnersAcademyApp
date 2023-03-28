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
			<th>Teacher</th>
		</tr>
		
		<c:forEach var="teacher" items="${teacher_list}">
			<tr>

				<td>${teacher.getName()}</td> 
				
			</tr>
			
		</c:forEach>
	</table>
</body>
</html>