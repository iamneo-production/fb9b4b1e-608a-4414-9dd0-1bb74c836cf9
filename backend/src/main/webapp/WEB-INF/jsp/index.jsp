<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job Portal Page</title>
<%@include file="css.jsp" %>
<style>
 body{
  background-image: url('https://truecommerce.ecutopia.com/wp-content/uploads/2019/02/ecUtopia-Web-Vendor-Portal-Background.jpg');
  background-size:cover;
  } 
  .center {
  padding: 70px 0;
  text-align: center;
}
</style>
</head>
<body>
<%@include file="Navbar.jsp" %>
<c:if test="${empty user}">
<div class="center">
<H1>JOB PORTAL APPLICATION</H1>
<h2>Please continue with the LogIn or SignUp options</h2>
</div>
</c:if>

	<c:if test="${user.email eq 'admin'}">
<div class="center">
<H1>JOB PORTAL APPLICATION</H1>
<h2>Admin can perform the following operations: </h2>
<h3>Add Jobs</h3>
<h3>Remove Jobs</h3>
<h3>Edit Jobs</h3>
<h3>Read Jobs</h3>
<h3>View Applicants for particular a job</h3>
</div>
</c:if>


</body>
</html>