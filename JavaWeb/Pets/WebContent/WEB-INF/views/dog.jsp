<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Dog</title>
</head>
<body>
	You created a <c:out value="${dog.getName()}"/>
	
    <p>
        <c:out value="${dog.showAffection()}"/>
    </p>
</body>
</html>