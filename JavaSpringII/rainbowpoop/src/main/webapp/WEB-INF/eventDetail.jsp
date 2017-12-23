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

    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    
    <p> Soccer Game </p> 
    
   	<p> Host: ${event.host.firstName} </p>
   	<p> Date: ${event.date} </p>
   	<p> Location: ${event.city}, ${event.state} </p>
   	<p> People who are attending this event: <c:out value = "${event.guests.size()}"/> </p>
    
    <table>
    <tr>
    	<th>
    	Name
    	</th>
    	<th>
    	Location
    	</th>
    </tr>
	<c:forEach items="${event.guests}" var="guest">
	<tr>
		<td>
			${guest.firstName} ${guest.lastName}
		</td>
		<td>
			${guest.city}
		</td>
	</tr>
	    
	</c:forEach>
	</table>
	
	<p> Message Wall </p>
	
	<c:forEach items="${event.messages}" var="message">

		<p> ${message.user.firstName} ${message.user.lastName} says: ${message.comment} </p>
		
		<p> ----------------------------- </p>
	    
	</c:forEach>
	
		<p><form:errors path="message.*"/></p>
	<form:form method="POST" action="/newMessage/${event.id}" modelAttribute="message">
        <p>
            <form:label path="comment">Add Comment:</form:label> <br>
            <form:textarea path="comment" rows="4"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>

</body>
</html>