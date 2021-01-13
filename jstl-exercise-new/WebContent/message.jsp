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

<c:if test="${value>=0}">
	<h4>Successfully Debited: Your new credit is :</h4>
	<c:out value="${value }"/>
</c:if>
<c:if test="${value<0}">
	<h4>Insufficient Balance: Your limit is :</h4>
	<c:out value="${limit }"/>
	<h4>Try adding more amount</h4>
</c:if>

</body>
</html>