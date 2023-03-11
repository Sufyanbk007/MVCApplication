<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Add Film</title>
  
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f1f1f1;
    }

  h1 {
    text-align: center;
    margin-top: 30px;
    margin-bottom: 30px;
  }
  
  form {
    width: 80%;
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
    border-radius: 5px;
  }
  
  label {
    display: inline-block;
    width: 120px;
    margin-bottom: 10px;
    font-weight: bold;
  }
  
  input[type="number"], input[type="text"], textarea {
    display: block;
    width: 100%;
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    font-size: 16px;
  }
  
  input[type="submit"] {
    display: block;
    margin: 0 auto;
    padding: 10px 20px;
    background-color: #4CAF50;
    color: #fff;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
  }
  
  input[type="submit"]:hover {
    background-color: #3e8e41;
  }
  
  .error-message {
    color: red;
    font-weight: bold;
    margin-top: 20px;
    text-align: center;
  }
  
  .button {
  display: inline-block;
  padding: 10px 20px;
  background-color: #4CAF50;
  color: #fff;
  border: none;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.button:hover {
  background-color: #3e8e41;
}
  
</style>
</head>
<body>
<input type="hidden" name="action" value="add">
  <h1>Add Film</h1>
  <a href="./FilmsList.jsp" class="button">Back to Films List</a>
  <form method="post" action="./Films">
    <label for="filmId">Film ID:</label>
    <input type="number" id="filmId" name="filmId" required>

  <label for="filmTitle">Film Title:</label>
  <input type="text" id="filmTitle" name="filmTitle" required>

  <label for="year">Year:</label>
  <input type="number" id="year" name="year" required>

  <label for="filmDirector">Film Director:</label>
  <input type="text" id="filmDirector" name="filmDirector" required>

  <label for="filmStars">Film Stars:</label>
  <input type="text" id="filmStars" name="filmStars" required>

  <label for="filmReview">Film Review:</label>
  <textarea id="filmReview" name="filmReview"></textarea>

  <input type="submit" value="Add Film">
</form>
</body>
</html>