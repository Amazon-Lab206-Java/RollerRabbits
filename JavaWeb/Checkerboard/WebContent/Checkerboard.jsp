<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Checkerboard.css" rel="stylesheet" type="text/css">
<title>A Web Page</title>
</head>
<body>
<%
String width;
String height;
if (request.getParameter("width") == null) {
	width = "1";
} else {
	width = request.getParameter("width");
}
if (request.getParameter("height") == null) {
	height = "1";
} else {
	height = request.getParameter("height");
}
%>
<h1> Checkerboard: <%= width %>w X <%= height %>h </h1>
<% for (int h = 0; h < Integer.valueOf(height); h++) {
	boolean purple;
	if (h%2 == 0) {
		purple = true;
	} else {
		purple = false;
	}
	for (int w = 0; w < Integer.valueOf(width); w++) { %>
		<div class="purple<%=purple %>">
		</div>
		<% purple = !purple;
	} %>
	<br>
	<% 
} %>
</body>
</html>