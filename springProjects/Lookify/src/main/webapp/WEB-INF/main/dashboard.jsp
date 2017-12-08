<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lookify!</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
		<div id="dashboard-header" class="table-display flex header">
			<div class="flex" id="links">
				<a href="/songs/new">Add New</a>
				<a href="/search/topTen">Top Songs</a>
				
				</div>
			<form action="/search" method="POST">
				<input id="searchText" type="text" placeholder="Artist Name" name="artist" />
				<input class="button" type="submit" value="Search Artists"/>
			</form>
		</div>
		
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="song" items="${songs}">
					<tr>
						<td>
							<a href="/songs/${song.id}"><c:out value="${song.title}"/></a>
						</td>
						<td><c:out value="${song.rating}"/></td>
						<td> 
							<a href="/songs/delete/${song.id}">Delete</a>				
						</td>
					</tr>	
				</c:forEach>							
			</tbody>	
		</table>
	</div>
</body>
</html>