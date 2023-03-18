<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Film</title>
	<!-- Link to Bootstrap stylesheet -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<style>
		.error-message {
			color: red;
		}
	</style>
</head>
<body>
	<div class="container">
		<h1>Edit Film</h1>
		<c:if test="${not empty errorMessage}">
			<div class="alert alert-danger">${errorMessage}</div>
		</c:if>
		<form action="./Edit" method="POST">
			<input type="hidden" name="id" value="${film.id}">
			<div class="form-group">
				<label for="title">Title:</label>
				<input type="text" class="form-control" name="title" value="${film.title}">
			</div>
			<div class="form-group">
				<label for="year">Year:</label>
				<input type="text" class="form-control" name="year" value="${film.year}">
			</div>
			<div class="form-group">
				<label for="director">Director:</label>
				<input type="text" class="form-control" name="director" value="${film.director}">
			</div>
			<div class="form-group">
				<label for="stars">Stars:</label>
				<input type="text" class="form-control" name="stars" value="${film.stars}">
			</div>
			<div class="form-group">
			  <label for="review">Review:</label>
			  <textarea class="form-control" style="width: 100%" name="review" rows="5">${film.review}</textarea>
			</div>


			<input type="submit" class="btn btn-primary" value="Save">
		</form>
	</div>
	<!-- Link to Bootstrap JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
