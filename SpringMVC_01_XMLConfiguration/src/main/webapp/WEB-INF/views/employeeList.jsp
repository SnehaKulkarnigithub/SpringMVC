<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All user</title>
</head>
<body>
	<h3>List of employee</h3>
	<a href="newuser">Add more user</a>
	
	<c:if test="${!empty employees}">
		<table align="center" border="1">
		<tr>
			<th>EmployeeName</th>
			<th>EmployeeID</th>
		</tr>
		<c:forEach items="${employees}" var="emp">
			<tr>
				<td><c:out value="${emp.id}"/></td>
				<td><c:out value="${emp.name}"/></td>
			</tr>
		</c:forEach>
		</table>
	
	</c:if>
	
	
</body>
</html>