
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="#">JobPortal</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="/">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<c:if test="${user.email eq 'admin'}">
				<li class="nav-item active"><a class="nav-link"
					href="/postJob.htm">Post Job <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item active"><a class="nav-link"
					href="/viewJob.htm">View Job <span class="sr-only">(current)</span></a>
				</li>
			</c:if>
			<c:if test="${(user.email ne 'admin') &&(not empty user)}">
				<li class="nav-item active"><a class="nav-link"
					href="/viewAllJobs.htm"> All Jobs <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item active"><a class="nav-link"
					href="/appliedJob.htm"> Applied Jobs <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item active"><a class="nav-link"
					href="viewUnappliedJobs.htm"> UnApplied Jobs <span class="sr-only">(current)</span></a>
				</li>

			</c:if>


		</ul>
		<c:if test="${(user.email ne 'admin') &&(not empty user)}">
			<a href="/" class="btn btn light"><c:out value="${user.name}" /></a>
		</c:if>
		<c:if test="${user.email eq 'admin'}">
			<a href="/" class="btn btn light"><c:out value="Admin" /></a>
		</c:if>
		<c:if test="${not empty user}">

			<a href="/logout.htm" class="btn btn light">Logout</a>
		</c:if>
		<c:if test="${empty user}">
			<a href="/login.htm" class="btn btn light">LogIn</a>
			<a href="/signup.htm" class="btn btn light">SignUp</a>
		</c:if>
	</div>
</nav>