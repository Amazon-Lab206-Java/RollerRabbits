<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> // if there is a form

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>New Product</title>

</head>
<body>
	<div class="container">
		<h1>New Product</h1>
		
		<form:form action="/products" method="POST" modelAttribute="product">
			<p>
				<form:label path="name">Name:</form:label>
				<form:input type="text" path="name" />			
			</p>
			<p>
				<form:label path="description">Description:</form:label>
				<form:input type="text" path="description" />			
			</p>
			<p>
				<form:label path="price">Price:</form:label>
				<form:input type="number" step="0.01" path="price" />			
			</p>			
			<input type="submit" value="Create"/>
		</form:form>
	</div>
</body>
</html>