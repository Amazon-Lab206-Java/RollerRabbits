<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dojo Survey Result</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="box result-box">
		<h3>Submitted Info</h3>
		<p>
			<span>Name:</span>
			<span class="float"><c:out value=${name}"/></span>
			</p>
			<p>
			<span>Dojo Location:</span>
			<span class="float"><c:out value="${location}"/></span>
		</p>
		<p>
			<span>Favorite Language:</span>
			<span class="float"><c:out value="${language}"/></span>
		</p>		
		<p>
			<span>Comment:</span>
			<span class="float"><c:out value="${comment}"/></span>
		</p>
	</div>
</body>
</html>