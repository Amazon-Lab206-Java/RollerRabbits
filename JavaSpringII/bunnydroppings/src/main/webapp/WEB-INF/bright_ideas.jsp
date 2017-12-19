<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
<p> The Wall of Fabulous Ideas </p>
	
	<c:forEach items="${user.ideas}" var="idea">

		<p> ${message.user.firstName}  says: ${message.comment} </p>
		
	    
	</c:forEach>
	
		<p><form:errors path="message.*"/></p>
	<form:form method="POST" action="/newMessage/${event.id}" modelAttribute="message">
        <p>
            <form:label path="comment">Add Like:</form:label> <br>
            <form:textarea path="comment" rows="4"/> // find out a way for tallys to be counted. order in ascending.
        </p>
        <input type="submit" value="Submit"/>
    </form:form>