<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error LogIn</title>
<%@include file="css.jsp" %>
<style>
.class1{
text-align: center;
padding: 70px 0;
}
</style>
</head>
<body>
<%-- <%@include file="Navbar.jsp" %> --%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">JobPortal</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    </ul>
     <a href="/login.htm" class="btn btn light">LogIn</a>
     <a href="/signup.htm" class="btn btn light">SignUp</a>

  </div>
</nav>
<form method="post" action="/login.htm">

<div class="class1">
<H2>Error while logging in, retry with proper credentials</H2>

	     <a href="/login.htm" class="btn btn light">Return to LogIn</a>
	</div>
	</form>
</body>
</html>