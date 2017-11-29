<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Random Word Generator</title>
</head>
<body>
	<p> You have generated a word <c:out value="${count}"/> times. </p>
	<c:out value="${randomWord}"/>
	<form action="/RandomWord/Home" method="post">
		<input type="submit" value ="generate">
	</form>
	
	<p>The last time you generated a word was:</p>
	<c:out value="${time}"/>
</body>
</html>