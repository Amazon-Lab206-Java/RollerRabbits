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
    
	<div class="container">
		<h1>New Dojo</h1>
		
		<form:form action="/dojos" method="POST" modelAttribute="dojo">  
	
			<p>
				<form:label path="name">Name:</form:label>
				<form:errors path="name"/>
				<form:input type="text" path="name" />
			</p>
			<input type="submit" value="Create"/>
		</form:form>
		</div>
</body>
</html>