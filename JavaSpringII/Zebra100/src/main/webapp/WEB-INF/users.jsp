<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
</head>
<body>
    
    <c:out value="${currentUser.name}"></c:out>
    <a href="/professional_profile">My Profile</a>
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    
    <h1>Users you may want to connect with:</h1>
    
    <table>
    	<tr>
    		<th>
    			Name
    		</th>
    		<th>
    			Action
    		</th>
    	</tr>
    	<c:forEach items="${invitableUsers}" var="user">
    		<tr>
    			<td>
    				<a href="/users/${user.id}">${user.name}</a>
    			</td>
    			<td>
    				<a href="/users/invite/${user.id}">Connect</a>
    			</td>
    		</tr>
    	</c:forEach>
    </table>
    
    
</body>
</html>