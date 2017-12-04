 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h2>Your gold: ${gold}</h2>
    
    <p>Farm</p>
    <p>Earns 10-20 gold</p>
    <form action="/gold" method="POST">
  <input type="hidden" input name="place" value="farm">
  <input type="submit" value="Get some gold!">
</form>

    <p>Cave</p>
    <p>Earns 5-10 gold</p>
    <form action="/gold" method="POST">
  <input type="hidden" input name="place" value="cave">
  <input type="submit" value="Get some gold!">
</form>

    <p>House</p>
    <p>Earns 2-5 gold</p>
    <form action="/gold" method="POST">
  <input type="hidden" input name="place" value="house">
  <input type="submit" value="Get some gold!">
</form>

    <p>Casino</p>
    <p>Earns -50 to 50 gold</p>
    <form action="/gold" method="POST">
  <input type="hidden" input name="place" value="casino">
  <input type="submit" value="Get some gold!">
</form>
    
</body>
</html>