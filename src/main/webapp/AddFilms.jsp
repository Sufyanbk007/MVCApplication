<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Films</title>
<!-- Add the Bootstrap CSS file -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1>Add a New Film</h1>
        <form action="./Films" method="post" >
            <div class="form-group">
                <label for="filmId">Film ID:</label>
                <input type="text" class="form-control" id="filmId" name="filmId" required>
            </div>
            <div class="form-group">
                <label for="filmTitle">Title:</label>
                <input type="text" class="form-control" id="filmTitle" name="filmTitle" required>
            </div>
            <div class="form-group">
                <label for="filmYear">Year:</label>
                <input type="text" class="form-control" id="filmYear" name="filmYear" required>
            </div>
            <div class="form-group">
                <label for="filmDirector">Director:</label>
                <input type="text" class="form-control" id="filmDirector" name="filmDirector" required>
            </div>
            <div class="form-group">
                <label for="filmStars">Stars:</label>
                <input type="text" class="form-control" id="filmStars" name="filmStars" required>
            </div>
            <div class="form-group">
                <label for="filmReview">Review:</label>
                <textarea class="form-control" style="width: 100%" id="filmReview" name="filmReview" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Add Film</button>
        </form>
    </div>
    <!-- Add the Bootstrap JS file -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
