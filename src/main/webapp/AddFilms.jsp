<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Add Films</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css" />

</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #00b894;">
			<a class="navbar-brand" href="#">Add/Edit Films</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link"
						href="<%=request.getContextPath()%>/Films">Films</a></li>
				</ul>
			</div>
		</nav>
	</header>

	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${film != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${film == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${film != null}">
            			Edit Film
            		</c:if>
						<c:if test="${film == null}">
            			Add New Film
            		</c:if>
					</h2>
				</caption>

				<c:if test="${film != null}">
					<input type="hidden" name="id" value="<c:out value='${film.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Film ID</label> <input type="text"
						value="<c:out value='${film.id}' />" class="form-control"
						name="filmId">
				</fieldset>

				<fieldset class="form-group">
					<label>Film Title</label> <input type="text"
						value="<c:out value='${film.title}' />" class="form-control"
						name="filmTitle">
				</fieldset>

				<fieldset class="form-group">
					<label>Film Year</label> <input type="text"
						value="<c:out value='${film.year}' />" class="form-control"
						name="filmYear">
				</fieldset>

				<fieldset class="form-group">
					<label>Film Director</label> <input type="text"
						value="<c:out value='${film.director}' />" class="form-control"
						name="filmDirector">
				</fieldset>

				<fieldset class="form-group">
					<label>Film Stars</label> <input type="text"
						value="<c:out value='${film.stars}' />" class="form-control"
						name="filmStars">
				</fieldset>

				<fieldset class="form-group">
					<label>Film Review</label> <input type="text"
						value="<c:out value='${film.review}' />" class="form-control"
						name="filmReview">
				</fieldset>

				<button type="submit" class="btn btn-primary">Save</button>

				</form>
			</div>
		</div>
	</div>
</body>
</html>