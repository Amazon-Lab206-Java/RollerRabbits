<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>ButtonClicker</title>
</head>
<body>
	<form action="/ButtonClicker/Home" method="post">
	<input type="submit" value ="click me">
	</form>
	<p>You have clicked this button <c:out value="${count}"/> times</p>
</body>
</html>