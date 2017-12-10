<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Profile Page</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
		<h1><c:out value="${person.firstName}" /> <c:out value="${person.lastName}" /></h1>
		
		<table>
			<tr>
				<td>License Number:</td>
				<td><c:out value="${person.license.number}" /></td>
			</tr>
			<tr>
				<td>State: </td>
				<td><c:out value="${person.license.state}" /></td>
			</tr>
			<tr>
				<td>Expiration Date</td>
				<td>
					<fmt:formatDate type="date" value="${person.license.expirationDate}" pattern="MM/dd/yyyy" />
				</td>
			</tr>
		</table>
	</div>
</body>
</html>