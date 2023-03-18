<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Delete Film</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
    }
    form {
      display: inline-block;
      margin: 20px;
      background-color: #fff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 5px rgba(0,0,0,0.2);
    }
    input[type="submit"] {
      padding: 10px;
      background-color: #cc0000;
      color: #fff;
      border: none;
      border-radius: 3px;
      cursor: pointer;
    }
  </style>
</head>
<body>
  <c:set var="filmId" value="${param.id}" />

  <c:url var="deleteUrl" value="/Delete" />

  <form action="${deleteUrl}" method="post">
    <h1>Delete Film</h1>
    <input type="hidden" name="id" value="${filmId}" />
    <p>Are you sure you want to delete this film?</p>
    <input type="submit" value="Delete" />
  </form>
</body>
</html>
