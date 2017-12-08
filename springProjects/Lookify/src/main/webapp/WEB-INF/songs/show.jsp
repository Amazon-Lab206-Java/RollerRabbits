<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Song Details</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
		<div class="header flex songHeader">
			<a href="/dashboard">Dashboard</a>
		</div>
		
		<div class="song-form">
			<p class="flex song-inputs">
				<span>Title</span>
				<span><c:out value="${song.title}"/></span>
			</p>
			<p class="flex song-inputs">
				<span>Artist</span>
				<span><c:out value="${song.artist}"/></span>
			</p>
			<p class="flex song-inputs">
				<span>Rating</span>
				<span><c:out value="${song.rating}"/></span>
			</p>
			<a href="/songs/delete/${song.id}">Delete</a>
		</div>
	</div>
</body>
</html>