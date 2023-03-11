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
	<c:if test="${not empty appliedJobList}">
	<H2>Applied Jobs</H2>
	<table class="table-condensed" border="1">

<tr>
<td id="td1"> Job ID </td>
<td id="td1"> Role </td>
<td id="td1"> Description </td>
<td id="td1"> Company </td>
<td id="td1"> Skills </td>
<td id="td1"> Location </td>
<td id="td1"> Pay/hour </td>
<td id="td1"> Withdraw Application</td>

</tr>

<c:forEach items="${appliedJobList}" var="job">

<tr>
<td>${job.jobid}</td>
<td>${job.roleName}</td>
<td> ${job.description}</td>
<td> ${job.company}</td>
<td> ${job.pay}</td>
<td> ${job.skills}</td>
<td> ${job.pay}</td>
<td><a class="nav-link" href="/deleteAppliedJob.htm/${job.jobid}" >Withdraw</a></td>
</tr>
</c:forEach>
</table>
</c:if>
<c:if test="${empty appliedJobList}">
<h2>No Jobs are applied</h2>
</c:if>
</form>
</body>
</html>