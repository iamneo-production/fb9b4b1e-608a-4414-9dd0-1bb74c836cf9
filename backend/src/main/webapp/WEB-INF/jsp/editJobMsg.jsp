<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post Edit Job</title>
<%@include file="css.jsp" %>
</head>
<body>
<c:if test="${user eq null}">
<c:redirect url="/login.htm"></c:redirect>
</c:if>
<%@include file="Navbar.jsp" %>

<br><br><br><br>
<h3>${job.jobid}  at ${job.company} for role - ${job.roleName} is updated successfully.</h3> 
<br><br><br><br><br><br><br><br><br><br>
<a class="nav-link" href="/viewJob.htm">Go back to View Job page<span class="sr-only">(current)</span></a>

</body>
</html>