<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="./scss/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" >
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.11.3/datatables.min.css"/>





<!DOCTYPE html>
<html>
<head>
<title>Films Websites</title>

<style>
  body {
    background-color: #F9F9F9 ; /* set your preferred color code here */
  }
  .list-inline-item {
  margin-right: 5px; /* Add margin to separate buttons */
  padding: 5px; /* Add padding to create space around buttons */
}
  th.actions {
    width: 120px;
  }
</style>
<style>
  .toggle-btn {
    border-radius: 0;
    border: none;
  }
  .toggle-btn:hover {
    background-color: #2a9d8f;
  }
  .toggle-btn:focus {
    outline: none;
    box-shadow: none;
  }
</style>


<style>
/* Add Films button */
  .add-btn {
    border-radius: 0;
    border: none;
  }
  .add-btn:hover {
    background-color: #28a745;
  }
  .add-btn:focus {
    outline: none;
    box-shadow: none;
  }
  .add-btn i {
    margin-right: 5px;
  }
</style>



</head>
<body>
<div class="container">
  <div class="row mb-2">
    <div class="col-12 text-center">
      <h1>Welcome to Enterprise Programming MVC Application</h1>
      <h2>List of Films</h2>
	  <button class="btn btn-primary mb-2 toggle-btn" id="toggle-table">Hide Table</button>
<button class="btn btn-success mb-2 add-btn" onclick="redirectToAddFilms()"><i class="fa fa-plus"></i> Add Film</button>

	  
    </div>
  </div>
  <div class="row">
    <div class="col-12">
      <div class="table-responsive">
        <table id="films-table" class="table table-bordered table-hover table-striped">
          <thead class="bg-primary text-white">
            <tr>
              <th scope="col" data-sortable="true">Film ID</th>
              <th scope="col">Film Title</th>
              <th scope="col" data-sortable="true">Year</th>
              <th scope="col">Film Director</th>
              <th scope="col">Film Stars</th>
              <th scope="col">Film Review</th>
              <th scope="col" class="actions">Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="film" items="${films}">
              <tr>
                <td>${film.id}</td>
                <td>${film.title}</td>
                <td>${film.year}</td>
                <td>${film.director}</td>
                <td>${film.stars}</td>
                <td>${film.review}</td>
<td>
	<ul class="list-inline m-0">
		<li class="list-inline-item">
			<button class="btn btn-success btn-lg rounded-0" onclick="redirectToEditFilms" type="button" data-toggle="tooltip" data-placement="top" title="Edit"><i class="fa fa-edit"></i></button>
		</li>
		<li class="list-inline-item">
			<button class="btn btn-danger btn-lg rounded-0" type="button" data-toggle="tooltip" data-placement="top" title="Delete"><i class="fa fa-trash"></i></button>
		</li>
	</ul>
</td>

              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
</body>
</html>


	<script 
		src="https://code.jquery.com/jquery-3.5.1.slim.min.js">
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js">
	</script>
	<script 
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js">
	</script>
	<script
		 src="https://code.jquery.com/jquery-3.6.0.min.js">
	</script>		

	<script
	 type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.11.3/datatables.min.js">
	</script>
	<script 
	src="https://code.jquery.com/jquery-3.6.0.min.js">
	</script>
	
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.js"></script>
	
	
	
	<script>
	  $(document).ready(function() {
	    $('#toggle-table').click(function() {
	      $('#films-table').toggle();
	      var buttonText = $(this).text() === 'Hide Table' ? 'Show Table' : 'Hide Table';
	      $(this).text(buttonText);
	    });
	  });
	</script>

	<script>
		function redirectToAddFilms() {
		  window.location.href = "AddFilms.jsp";
		}
	</script>
	<script>
		function redirectToEditFilms() {
		  window.location.href = "EditFilms.jsp";
		}
	</script>

	<script>
	  $(document).ready(function() {
	    $('#films-table').DataTable({
	      "columnDefs": [
	        {"orderable": true, "targets": [0, 2]}
	      ]
	    });
	  });
	</script>



	
</body>
</html>
