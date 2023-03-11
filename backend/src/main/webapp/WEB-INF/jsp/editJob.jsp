<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Job</title>
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
<%@include file="Navbar.jsp"%>
<c:if test="${user eq null}">
<c:redirect url="/login.htm"></c:redirect>
</c:if>
	
	<form method="post" action="/editJob.htm/${job.jobid}">
		<h2>EDIT JOB</h2>
		<br>
		
		<%-- <label>Job ID:</label> 
		<input type="text" name="jobid_e" value="${job.jobid}" readonly><br> <br>  --%>
		
		<label>Role Name:</label> 
		<input type="text" name="roleName_e" value="${job.roleName}" required><br> <br> 
		
		<label>Company Name:</label> 
		<input type="text" name="company_e" value="${job.company}" required><br> <br> 
		
		<label>Description:</label>
		<input type="text" style="height: 120px; width: 200px;" name="description_e" value="${job.description}" required><br><br> 

		<label>Location:</label> 
		<input type="text" name="location_e" value="${job.location}" required><br><br> 

		<label>Skills:</label> 
		<input type="text" style="width: 300px;" name="skills_e" value="${job.skills}" required><br> <br> 
		
		<label>Pay:</label> 
		<input type="number" name="pay_e" value="${job.pay}" required><br><br> 
		<label><input type="submit" value="Update Job" ></label>
	</form>
</body>
</html>