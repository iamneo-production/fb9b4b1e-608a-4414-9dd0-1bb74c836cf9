<!DOCTYPE html>
     <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<%@include file="css.jsp" %>
<style> body{
  background-image: url('https://images.pexels.com/photos/140945/pexels-photo-140945.jpeg');
  background-size:cover;
  } 
  </style>
</head>
<body>
<c:if test="${user eq null}">
<c:redirect url="/login.htm"></c:redirect>
</c:if>
<%@include file="Navbar.jsp"%>

Welcome ${user.name} !!!


</body>
</html>