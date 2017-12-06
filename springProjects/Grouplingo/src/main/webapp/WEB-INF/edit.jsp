<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Languages</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
		<div class="left-auto">
			<a href="/languages/delete/${id}">Delete</a>
			<a href="/">Dashboard</a>
		</div>
		
		<p class='error'><form:errors path="language.*"/></p>
		
		<div class="form-container">
			<form:form action="/languages/update/${id}" method="POST" modelAttribute="language">
				<p>
					<form:label path="name" for="name">Name</form:label>
					<form:input path="name" class="input-size float" type="text" name="name"/>
				</p>
				<p>
					<form:label path="creator" for="creator">Creator</form:label>
					<form:input path="creator" class="input-size float" type="text" name="creator"/>
				</p>
				<p>
					<form:label path="version" for="version">Version</form:label>
					<form:input path="version" class="input-size float" type="text" name="version"/>
				</p>
				<input class="float" type="submit" value="Update" />						
			</form:form>
		</div>
	</div>
</body>
</html>