 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dojo Survey Index</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<form class="box" action="/result" method="POST">
	<p>
		<label for="name">YourName:</label>
		<input class="float" type="text" name="name"/>
		</p>
	<p>
		<label for="location">Dojo Location</label>
		
		<select class="float" name="location">
			<option value="Burbank">Burbank</option>
			<option value="San Jose">San Jose</option>
			<option value="Seattle">Seattle</option>
		</select>
		</p>
		<p>
		<label for="language">Language</label>
			<select class="float" name="language">
				<option value="Java">Java</option>
				<option value="Python">Python</option>
				<option value="Ruby">Ruby</option>
				<option value="JavaScript">JavaScript</option>
			</select>
		</p>
		<p>
			<label id="comment-label" for="comment">Comment(optional)</label>
			<textarea name="comment" id="comment-label"> </textarea>
			</p>
			<input class="float" type="submit" value="submit your face!"/>
		
	</form>
</body>
</html>