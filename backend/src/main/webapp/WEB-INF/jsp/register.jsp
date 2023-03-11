<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
<style>
 body{
  background-image: url('https://www.athletadesk.com/wp-content/uploads/2016/08/join-background.jpg');
  background-size:cover;
  } 
.class1 {
	text-align: center;
	padding: 70px 0;
	color: white;
}
</style>
<%@include file="css.jsp"%>
</head>
<body>
	<%@include file="Navbar.jsp"%>
	<form method="post" action="/register.htm">
		<div class="class1">
			<H2>Register Page</H2>
			   UserName: <input type="text" name="name"><br> 
			Email -Id : <input type="email" name="email" required /><br> 
			Password : <input type="password" name="pwd" required /><br> 
			<input type="submit" value="Register">
		</div>
	</form>
</body>
</html>