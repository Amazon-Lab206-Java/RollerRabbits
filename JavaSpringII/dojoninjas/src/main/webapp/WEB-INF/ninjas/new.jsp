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
		<h1>New Ninja</h1>
		
	<form:form action="/ninjas" method="POST" modelAttribute="ninja">
			<p>
				<form:label path="dojo">Dojo:</form:label>
				<form:select path="dojo">
					<c:forEach items="${dojos}" var="dojo">
						<form:option value="${dojo}" label="${dojo.name}" />
					</c:forEach>
				</form:select>
			</p>
			<p>
				<form:label path="firstName">First Name:</form:label>
				<form:input type="text" path="firstName" />			
			</p>
			<p>
				<form:label path="lastName">Last Name:</form:label>
				<form:input type="text" path="lastName" />			
			</p>
			<p>
				<form:label path="age">Age:</form:label>
				<form:input type="number" min="1" path="age" value="1" />			
			</p>			

			<input type="submit" value="Create"/>
		</form:form>
		
		</div>
</body>
</html>