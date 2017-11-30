 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
 <a href="/"/>Back </a><br>
    <span id="time">
    	<fmt:formatDate pattern = "hh:mm a" value = "${date}" />
    </span>