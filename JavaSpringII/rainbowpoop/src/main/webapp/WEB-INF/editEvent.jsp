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
    
	<p><form:errors path="event.*"/></p>
	<form:form method="POST" action="/newEvent" modelAttribute="event">
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
        <input type="submit" value=Edit"/>
    </form:form>

</body>
</html>