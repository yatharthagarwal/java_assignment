<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header>
<%@ include file="menu.html" %>
</header>

<% 
if(session.getAttribute("validStatus") != null) {
	if(session.getAttribute("validStatus").equals("valid")) {
		request.setAttribute("valid", 1);
	}
} else {
	request.setAttribute("valid", -1);
}
%>

<c:if test="${valid > 0}">
<h2>Add</h2>
<form action="donor" method="post">
	<label for="">Name</label>
	<input type="text" name="username"/>
	<label for="">Age</label>
	<input type="text" name="age"/>
	<label for="">Gender</label><br>
	<label for="">Male</label><input type="radio" name="gender" value="male"/>
	<label for="">Female</label><input type="radio" name="gender" value="female"/><br>
	<label for="">Blood Group</label>
	<label for="">A+</label><input type="radio" name="group" value="apos"/>
	<label for="">O+</label><input type="radio" name="group" value="opos"/>
	<label for="">B+</label><input type="radio" name="group" value="bpos"/><br>
	<label for="">Mobile Number</label>
	<input type="text" name="mobileNumber"/>
	<label for="">Email</label>
	<input type="email" name="email"/>
	<label for="">Date of birth</label>
	<input type="date" name="dateOfBirth"/>

	<input type="submit" value="Add">
</form>
<footer>
<c:if test="${rowsAdded>0 }" >
	<label for="">People Added</label><c:out value="${rowsAdded }"/>
</c:if>
</footer>

</c:if>
</body>
</html>