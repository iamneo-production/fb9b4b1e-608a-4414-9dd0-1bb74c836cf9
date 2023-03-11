<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
	<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="css.jsp"%>
<style>
div {
	margin-bottom: 10px;
}

label {
	display: inline-block;
	width: 140px;
	text-align: right;
}
</style>
</head>
<body>
<c:if test="${user eq null}">
<c:redirect url="/login.htm"></c:redirect>
</c:if>
	<%@include file="Navbar.jsp"%>
	<form method="post" action="/postJob.htm">
		<h2>POST NEW JOB</h2>
		<br>
		<label>Role Name:</label> 
		<input type="text" name="roleName" required><br> <br> 
		
		<label>Company Name:</label> 
		<input type="text" name="company" required><br> <br> 
		
		<label>Description:</label>
		<input type="text" style="height: 120px; width: 200px;" name="description" required><br><br> 

		<label>Location:</label> 
		<input type="text" name="location" required><br><br> 

		<label>Skills:</label> 
		<input type="text" style="width: 300px;" name="skills" required><br> <br> 
		
		<label>Pay:</label> 
		<input type="number" name="pay"><br><br> 
		<label><input type="submit" value="Post Job" required></label>
	</form>
</body>
</html>