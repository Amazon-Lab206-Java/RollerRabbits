 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <table class="table">
 <c:forEach items="${books}" var="book">
 	<tr>
 	<td><c:out value="${book.title}"/></td>
 	 <td><c:out value="${book.description}"/></td>
    <td><c:out value="${book.language}"/></td>
    <td><c:out value="${book.numberOfPages}"/></td>
    </tr>
    </c:forEach>
 </table>