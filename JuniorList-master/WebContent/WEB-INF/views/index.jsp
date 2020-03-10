<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h2>JuniorList</h2>

<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Firstname</th>
		<th>Lastname</th>
		<th>Email</th>
		<th>Department</th>
		<th>Batch</th>
		<th>Convert to Senior</th>
	</tr>
	<c:forEach var="emp" items="${list}">
		<tr>
			<td>${emp.firstName}</td>
			<td>${emp.lastName}</td>
			<td>${emp.email}</td>
			<td>${emp.department}</td>
			<td>${emp.batch}</td>
			<td>${emp.dateOfBirth}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>

