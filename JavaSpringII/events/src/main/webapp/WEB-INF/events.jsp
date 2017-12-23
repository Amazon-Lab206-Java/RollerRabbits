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
    
    <h1>Welcome <c:out value="${currentUser.firstName}"></c:out></h1>
    
    Here are some of the events in your state:
    <table>
    <tr>
    	<th>
    	Name
    	</th>
    	<th>
    	Date
    	</th>
		<th>
		Location
    	</th>
    	<th>
    	Host
    	</th>
    	<th>
    	Action/Status
    	</th>
    </tr>
	<c:forEach items="${inStateEvents}" var="event">
	<tr>
		<td>
			<a href="/events/${event.id}">${event.name}</a>
		</td>
		<td>
			${event.date}
		</td>
		<td>
			${event.city}
		</td>
		<td>
			${event.host.firstName}
		</td>
		<td>
		<c:set var="isGuest" value="false" />
		<c:forEach var="guest" items="${event.guests}">
  		<c:if test="${guest.id eq currentUser.id}">
    		<c:set var="isGuest" value="true" />
  		</c:if>
		</c:forEach>
		<c:choose>
			<c:when test = "${event.host.id == currentUser.id}">
				<a href="/event/${event.id}/edit">edit</a>
				<a href="/event/${event.id}/delete">delete</a>
			</c:when>
			
			<c:when test = "${isGuest}">
				Joining 
				<a href="/event/${event.id}/cancel">cancel</a>
			</c:when>
			
			<c:otherwise>
            	Join
         	</c:otherwise>
		</c:choose>
		</td>
	</tr>
	    
	</c:forEach>
	</table>

    Here are some of the events in other states:
    <table>
    <tr>
    	<th>
    	Name
    	</th>
    	<th>
    	Date
    	</th>
		<th>
		Location
    	</th>
    	<th>
		State
    	</th>
    	<th>
    	Host
    	</th>
    	<th>
    	Action/Status
    	</th>
    </tr>
	<c:forEach items="${outOfStateEvents}" var="event">
	<tr>
		<td>
			<a href="/events/${event.id}">${event.name}</a>
		</td>
		<td>
			${event.date}
		</td>
		<td>
			${event.city}
		</td>
		<td>
			${event.state}
		</td>
		<td>
			${event.host.firstName}
		</td>
		<td>
		<c:set var="isGuest" value="false" />
		<c:forEach var="guest" items="${event.guests}">
  		<c:if test="${guest.id eq currentUser.id}">
    		<c:set var="isGuest" value="true" />
  		</c:if>
		</c:forEach>
		<c:choose>
			<c:when test = "${event.host.id == currentUser.id}">
				<a href="/event/${event.id}/edit">edit</a>
				<a href="/event/${event.id}/delete">delete</a>
			</c:when>
			
			<c:when test = "${isGuest}">
				Joining 
				<a href="/event/${event.id}/cancel">cancel</a>
			</c:when>
			
			<c:otherwise>
            	Join
         	</c:otherwise>
		</c:choose>
		</td>
	</tr>
	    
	</c:forEach>
	</table>
	
Create an event

	<p><form:errors path="event.*"/></p>
	<form:form method="POST" action="/newEvent" modelAttribute="event">// shouldn't modelAttribute be "/newEvent"?
        <p>
            <form:label path="name">Name:</form:label>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="date">Date:</form:label>
            <form:input type="date" path="date" />
        </p>
        <p>
            <form:label path="city">City:</form:label>
            <form:input path="city"/>
        </p>
        <p>
            <form:label path="state">State:</form:label>
            <form:select path = "state">
                <form:options items = "${states}" />
            </form:select>   
        </p>
        <input type="submit" value="Create Event"/>
    </form:form>

</body>
</html>