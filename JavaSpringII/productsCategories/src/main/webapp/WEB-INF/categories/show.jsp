<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Category Page</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
		<h1><c:out value="${category.name}" /></h1>
		
		<div class="info">
			<div>
				<h2>Categories</h2>
				<ul>
					<c:forEach var="prod" items="${category.products}">
						<li><c:out value="${prod.name}" /></li>
					</c:forEach>
				</ul>
			</div>
			
			<form:form class="form" action="/products/addCat" method="POST" modelAttribute="catProd">
				<form:hidden path="category" value="${category.id}"></form:hidden>
				<p>
					<form:label path="product">Add Product</form:label>
					<form:select path="product">
						<c:forEach items="${products}" var="product">
							<form:option value="${product}" label="${product.name}" />
						</c:forEach>
					</form:select>
				</p>
				<input type="submit" value="Create"/>
			</form:form>
		</div>
	</div>
</body>
</html>