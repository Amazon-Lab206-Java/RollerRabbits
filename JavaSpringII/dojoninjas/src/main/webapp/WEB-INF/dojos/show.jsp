 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    
		<h1><c:out value="${dojo.name}"/>Location Ninjas</h1>
		<table>
			<thead>
				<th>First</th>
				<th>Last</th>
				<th>Age</th>
			</thead>
			
			<tbody>
			<c:forEach var="ninja" items="${dojo.ninjas}">
			<tr>
			<td><c:out value="${ninja.firstName}"/></td>
			<td><c:out value="${ninja.lastName}"/></td>
			<td><c:out value="${ninja.age}"/></td>
			</tr>
			</c:forEach>
			</tbody>
				
		</table>
	
</body>
</html>