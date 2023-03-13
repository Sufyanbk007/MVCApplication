<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>List of Films</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>

<script>
$(document).ready(function() {
    // Initialize DataTable with sorting functionality
    $('#film-table').DataTable({
        columnDefs: [
            { targets: 'no-sort', orderable: false }
        ]
    });
});
</script>
	
	<!-- Add CSS styles for table -->
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }
    th, td {
        text-align: left;
        padding: 8px;
    }
    th {
        background-color: #4CAF50;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    tr:hover {
        background-color: #ddd;
    }
    
    #film-table th:nth-child(7),
    #film-table td:nth-child(7) {
        width: 120px; /* adjust the width to your preference */
    }
</style>
	
</head>
<body>

<header>
  <nav class="navbar navbar-expand-md navbar-dark"
       style="background-color: #00b894">
    <a class="navbar-brand" href="#">List of Films</a>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <a class="nav-link" href="<%=request.getContextPath()%>/films">Home</a>
        </li>
      </ul>
    </div>
  </nav>
</header>

	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Films</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Film</a>
			</div>
			<br>
			<table id="film-table" class="display">
    <thead>
        <tr>
            <th>Film ID</th>
            <th>Film Title</th>
            <th>Film Year</th>
            <th>Film Director</th>
            <th>Film Stars</th>
            <th>Film Review</th>
            <th class="no-sort">Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="film" items="${allFilms}">
            <tr>
                <td><c:out value="${film.id}" /></td>
                <td><c:out value="${film.title}" /></td>
                <td><c:out value="${film.year}" /></td>
                <td><c:out value="${film.director}" /></td>
                <td><c:out value="${film.stars}" /></td>
                <td><c:out value="${film.review}" /></td>
                <td>
                    <a href="edit?id=<c:out value='${film.id}' />"><span class="fa fa-edit"></span> </a>
                    &nbsp;&nbsp;&nbsp;&nbsp; 
                    <a href="delete?id=<c:out value='${film.id}' />"><span class="fa fa-trash"></span></a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
		</div>
	</div>
</body>
</html>