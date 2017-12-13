<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Product Page</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
		<h1><c:out value="${product.name}" /></h1>
		
		<div class="info">
			<div>
				<h2>Categories</h2>
				<ul>
					<c:forEach var="cat" items="${product.categories}">
						<li><c:out value="${cat.name}" /></li>
					</c:forEach>
				</ul>
			</div>
			
			<form:form class="form" action="/products/addCat" method="POST" modelAttribute="catProd">
				<form:hidden path="product" value="${product.id}"></form:hidden>
				<p>
					<form:label path="category">Add Category</form:label>
					<form:select path="category">
						<c:forEach items="${categories}" var="category">
							<form:option value="${category}" label="${category.name}" />
						</c:forEach>
					</form:select>
				</p>
				<input type="submit" value="Create"/>
			</form:form>
		</div>
	</div>
</body>
</html>