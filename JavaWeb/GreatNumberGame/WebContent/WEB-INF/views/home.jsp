<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Great Number Game</title>
</head>
<body>
	<h3> Welcome to the Great Number Game!</h3>
	<p> I am thinking of a number between 1 and 100</p>
	<c:if test = "${guess > answer}">
         <p> Too High </p>
     </c:if>
     <c:if test = "${guess < answer}">
         <p> Too Low </p>
     </c:if>
     <c:if test = "${guess == answer && answer != null}">
         <p> <c:out value="${answer}"/> was the number! </p>
           	<form action="/GreatNumberGame/PlayAgain" method="post">
			<input type="submit" value ="Play Again!">
		</form>
     </c:if>
      <c:if test = "${guess != answer || answer == null}">
      	<p> Take a guess! </p>
       	<form action="/GreatNumberGame/Guess" method="post">
			<input type="text" name="guess">
			<input type="submit" value ="generate">
		</form>
     </c:if>
</body>
</html>