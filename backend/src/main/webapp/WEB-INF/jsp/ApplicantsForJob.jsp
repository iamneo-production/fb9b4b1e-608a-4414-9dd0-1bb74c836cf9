<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Applied Jobs</title>
<%@include file="css.jsp"%>
</head>
<body>
<c:if test="${user eq null}">
<c:redirect url="/login.htm"></c:redirect>
</c:if>
	<%@include file="Navbar.jsp"%>
	<form method="post" action="/viewJob.htm">
	<c:if test="${not empty appliedUsers}">
	<H2>Applicants for Job Id <c:out value="${job.jobid}"/></H2>
	<table class="table-condensed" border="1">

<tr>
<td id="td1"> UserID </td>
<td id="td1"> UserName </td>
<td id="td1"> Job ID </td>
<!-- <td id="td1"> Delete Application</td> -->

</tr>

<c:forEach items="${appliedUsers}" var="user">

<tr>
<td>${user.id}</td>
<td>${user.name}</td>
<td>${job.jobid}</td>
<%-- <td><a class="nav-link" href="/removeApplicant.htm/${job.jobid}/${user.id}" >Delete</a></td> --%>
</tr>
</c:forEach>
</table>
</c:if>
<c:if test="${empty appliedUsers}">
<h2>No Applicants for this Job <c:out value="${job.jobid}"/></h2>
</c:if>

<a class="nav-link" href="/viewJob.htm" >Go Back to View Jobs</a>
</form>
</body>
</html>