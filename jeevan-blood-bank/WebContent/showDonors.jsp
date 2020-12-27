<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table{
border:2px solid blue;
cellspacing:5px;
}
</style>
</head>
<body>
<header>
<c:if test="${valid > 0}" >
	<%@ include file="menu.html" %>
</c:if>
<c:if test="${valid < 0}" >
	<a href="index.jsp">Login Page</a>
</c:if>
</header>
<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Age</th>
			<th>Gender</th>
			<th>Blood Group</th>
			<th>Mobile Number</th>
			<th>Email</th>
			<th>Date of Birth</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${donorList}" var="donor">
			<tr>
				<td><c:out value="${donor.name}"/></td>
				<td><c:out value="${donor.age}"/></td>
				<td><c:out value="${donor.gender}"/></td>
				<td><c:out value="${donor.bloodGroup}"/></td>
				<td><c:out value="${donor.mobileNumber}"/></td>
				<td><c:out value="${donor.email}"/></td>
				<td><c:out value="${donor.dateOfBirth}"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>