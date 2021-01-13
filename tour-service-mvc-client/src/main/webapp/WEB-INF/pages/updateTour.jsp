<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="update" method="post">
<div>
	<label for="">TourId</label>
	 <form:input path="tourId"/>
</div>
<div>
	<label for="">TourName</label>
	 <form:input path="tourName"/>
</div>
<div>
	<label for="">Duration</label>
	 <form:input path="duration"/>
</div>
<div>
	<label for="">Cost</label>
	 <form:input path="cost"/>
</div>
<div>
	<input type="submit" value="Update">
</div>
</form:form>
</body>
</html>