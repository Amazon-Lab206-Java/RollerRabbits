<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add Song</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
		<div class="header flex songHeader">
			<a href="/dashboard">Dashboard</a>
		</div>
		
		<p class='error'><form:errors path="song.*"/></p>
		
		<form:form class="song-form" action="/songs" method="POST" modelAttribute="song">
			<p class="flex song-inputs">
				<form:label path="title" for="title">Title</form:label>
				<form:input class="border" path="title" type="text" name="title"/>
			</p>
			<p class="flex song-inputs">
				<form:label path="artist" for="artist">Artist</form:label>
				<form:input class="border" path="artist" type="text" name="artist"/>
			</p>
			<p class="flex song-inputs">
				<form:label path="rating" for="rating">Rating (1-10)</form:label>
				<form:input class="border" path="rating" min="1" max="10" type="number" name="rating"/>
			</p>
			<p class="flex song-submit">
				<input class="button" type="submit" value="Add Song" />
			</p>	
		</form:form>
	</div>
</body>
</html>