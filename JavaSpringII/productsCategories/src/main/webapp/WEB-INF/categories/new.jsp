<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> // if there is a form<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>New Category</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
		<h1>New Category</h1>
		
		<form:form action="/categories" method="POST" modelAttribute="category">
			<p>
				<form:label path="name">Name:</form:label>
				<form:input type="text" path="name" />			
			</p>		
			<input type="submit" value="Create"/>
		</form:form>
	</div>
</body>
</html>