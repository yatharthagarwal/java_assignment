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

<a href="donor">View Donors</a>


<form action="user" method="post">
	<label for="">Username</label>
	<input type="text" name="username" >
	<label for="">Password</label>
	<input type="password" name="password" >
	<label for="">Role</label>
	<input type="text" name="role" >
	<input type="submit" value="SUBMIT">
</form>


</body>
</html>