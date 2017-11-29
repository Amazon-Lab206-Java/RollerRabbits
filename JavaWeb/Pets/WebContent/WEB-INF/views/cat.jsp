<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Dog</title>
</head>
<body>
	You created a <c:out value="${cat.getName()}"/>
    <p>
        <c:out value="${cat.showAffection()}"/>
    </p>
</body>
</html>