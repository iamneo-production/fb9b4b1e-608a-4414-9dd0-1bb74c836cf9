<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="css.jsp" %>
</head>
<body>
<c:if test="${user eq null}">
<c:redirect url="/login.htm"></c:redirect>
</c:if>
<%@include file="Navbar.jsp" %>

Application withdrawn successfully. 
<br><br><br><br><br><br><br><br><br><br>
<a class="nav-link" href="/appliedJob.htm">Go back to Applied Jobs page<span class="sr-only">(current)</span></a>

</body>
</html>