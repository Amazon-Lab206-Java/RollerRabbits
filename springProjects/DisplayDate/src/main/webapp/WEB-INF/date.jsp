 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
 <a href="/"/>Back </a><br>
    <span id = "date">
    	<fmt:formatDate pattern = "EEEE, 'the' d 'of' MMMM, y" value = "${date}" />
    </span>