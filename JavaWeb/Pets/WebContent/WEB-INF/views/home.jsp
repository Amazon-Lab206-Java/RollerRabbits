
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Make a pet!</title>
</head>
<body>
    <p>
    	Make a dog!
        <form action="/Pets/Dog">
        Name:
  		<input type="text" name="name"> <br>
  		Breed:
  		<input type="text" name="breed"> <br>
  		Weight (lb):
  		<input type="text" name="weight"> <br>
  		<input type="submit" value="Submit">
        </form>
        
        Make a cat!
        <form action="/Pets/Cat">
        Name:
  		<input type="text" name="name"> <br>
  		Breed:
  		<input type="text" name="breed"> <br>
  		Weight (lb):
  		<input type="text" name="weight"> <br>
  		<input type="submit" value="Submit">
        </form>
    </p>
</body>
</html>