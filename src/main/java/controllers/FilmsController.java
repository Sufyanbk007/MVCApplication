package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FilmDAO;
import models.Film;

/**
 * Servlet implementation class FilmsController
 */
@WebServlet("/Films")
public class FilmsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FilmDAO dao = new FilmDAO();
		ArrayList<Film> allFilms = dao.getAllFilms();
		request.setAttribute("films", allFilms);
		RequestDispatcher rd = request.getRequestDispatcher("FilmsList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Get the form data
		int filmId = Integer.parseInt(request.getParameter("filmId"));
	    String filmTitle = request.getParameter("filmTitle");
	    int filmYear = Integer.parseInt(request.getParameter("year"));
	    String filmDirector = request.getParameter("filmDirector");
	    String filmStars = request.getParameter("filmStars");
	    String filmReview = request.getParameter("filmReview");    

	        // Create a new DAO object to apply its method
	        FilmDAO dao = new FilmDAO();
	        
	        if (request.getParameter("action").equals("add")) {
	        	
	        	if (dao.getFilmByID(filmId) != null) {
	        		// Show error message if film with the same ID already exists
	        		request.setAttribute("error", "Film with ID " + filmId + " already exists.");
	        		RequestDispatcher rd = request.getRequestDispatcher("AddFilms.jsp");
	        		rd.forward(request, response);
	        		return;
	        	}
	        	
	        	// Create a new film object
	        	Film newFilm = new Film( filmId,  filmTitle,  filmYear,  filmDirector,  filmStars,
	        			filmReview);
	        	
	        	// Add the new film to the database
	        	try {
	        		dao.insertFilm(newFilm);
	        	} catch (SQLException e) {
	        		e.printStackTrace();
	        		// Show error message if failed to insert film into database
	        		request.setAttribute("error", "Failed to add new film. Please try again later.");
	        		RequestDispatcher rd = request.getRequestDispatcher("AddFilms.jsp");
	        		rd.forward(request, response);
	        		return;
	        	}
	        	
	        	// Redirect the user to the films list page
	        	response.sendRedirect("./Films");
	        } else if (request.getParameter("action").equals("update")) {
	        	
	        	//Edit 

	        	// Get the existing film from the database
	            Film existingFilm = dao.getFilmByID(filmId);

	            // Update the existing film with the new data
	            existingFilm.setTitle(filmTitle);
	            existingFilm.setYear(filmYear);
	            existingFilm.setDirector(filmDirector);
	            existingFilm.setStars(filmStars);
	            existingFilm.setReview(filmReview);

	            // Update the film in the database
	            try {
	                dao.editFilm(existingFilm);
	            } catch (SQLException e) {
	                e.printStackTrace();
	                // Show error message if failed to update film in database
	                request.setAttribute("error", "Failed to update film. Please try again later.");
	                RequestDispatcher rd = request.getRequestDispatcher("EditFilms.jsp");
	                rd.forward(request, response);
                return;
	            }

	            // Redirect the user to the films list page
	            response.sendRedirect("./Films");
	            
	        
	        }

	        
	        
	        
	}  
	    }
	

