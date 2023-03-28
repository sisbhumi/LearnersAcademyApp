<%@ page import="java.util.*, com.backendadmin.servlets.AddSubjectServlet" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Subjects</title>
</head>
<body>
		<table border="2">
		<tr>
			<th>Id</th>
			<th>Students</th>
			<th>Class</th>
		</tr>
		
		<c:forEach var="subject" items="${subject_list}">
			<tr>
				<td>${subject.getId()}</td>
				<td>${subject.getName()}</td>
				<td>${subject.getClassroom()}</td> 
				
			</tr>
			
		</c:forEach>
	</table>
</body>
</html>