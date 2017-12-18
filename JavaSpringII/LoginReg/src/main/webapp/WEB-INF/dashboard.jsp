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

    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    
    <h1>Welcome <c:out value="${currentUser.firstName}"></c:out></h1>
    
    <table>
    <tr>
    	<td>
    		First Name:
    	</td>
    	<td>
    		${currentUser.firstName}
    	</td>
    </tr>
        <tr>
    	<td>
    		Last Name:
    	</td>
    	<td>
    		${currentUser.lastName}
    	</td>
    </tr>
        <tr>
    	<td>
    		Email:
    	</td>
    	<td>
    		${currentUser.email}
    	</td>
    </tr>
        <tr>
    	<td>
    		Sign up date:
    	</td>
    	<td>
    		${currentUser.createdAt}
    	</td>
    </tr>
        <tr>
    	<td>
    		Last Sign in:
    	</td>
    	<td>
    		${currentUser.updatedAt}
    	</td>
    </tr>
    </table>

</body>
</html>