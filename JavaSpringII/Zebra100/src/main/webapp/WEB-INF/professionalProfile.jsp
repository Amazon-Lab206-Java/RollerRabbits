<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>

	<a href="/users">All Users</a>
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    
    <h1>Hi <c:out value="${currentUser.name}"></c:out>!</h1>
    
    <p> Here is your profile description: </p>
    <p> ${currentUser.description} </p>
    
    <p> Your Professional Network: </p>
    <c:forEach items="${network}" var="user">
    	<a href="/users/${user.id}">${user.name}<br></a>
    </c:forEach>
    
    <p> Invitations: </p>
    <p> The following people asked you to be in their network: </p>
    
    <table>
    	<tr>
    		<th>
    			Name
    		</th>
    		<th>
    			Action
    		</th>
    	</tr>
    	<c:forEach items="${currentUser.invitesToMe}" var="userInvite">
    		<tr>
    			<td>
    				<a href="/users/${userInvite.id}">${userInvite.name}</a>
    			</td>
    			<td>
    				<a href="/users/accept/${userInvite.id}">Accept Invite</a>
    				<a href="/users/ignore/${userInvite.id}">Ignore</a>
    			</td>
    		</tr>
    	</c:forEach>
    </table>
    
    

</body>
</html>