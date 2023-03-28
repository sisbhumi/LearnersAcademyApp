<%@ page import="java.util.*, com.backendadmin.servlets.AddClassServlet"  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
		<tr>
			<th>Id</th>
			<th>Classes</th>
		</tr>
		
		<c:forEach var ="class_name" items="${class_list}">
			<tr>
				<td>${class_name.getId()}</td>
				<td>${class_name.getName()}</td> 
				
			</tr>
			
		</c:forEach>
	</table>
</body>
</html>