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

	FilmDAO dao = new FilmDAO();
       
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
		
		ArrayList<Film> allFilms = dao.getAllFilms();
		
		request.setAttribute("allFilms", allFilms);
		
		RequestDispatcher rd = request.getRequestDispatcher("ListFilms.jsp");
		
		rd.forward(request, response);
		

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String filmIdParam = request.getParameter("filmId");
	    int filmId = Integer.parseInt(filmIdParam);
	    
	    String filmTitle = request.getParameter("filmTitle");
	    int filmYear = Integer.parseInt(request.getParameter("filmYear"));
	    String filmDirector = request.getParameter("filmDirector");
	    String filmStars = request.getParameter("filmStars");
	    String filmReview = request.getParameter("filmReview"); 
	    
	    // Create a new film object
	    Film newFilm = new Film(filmId, filmTitle, filmYear, filmDirector, filmStars, filmReview);
	    
	    // Add the new film to the database
	    try {
	    	System.out.println("The below is the film object being outputted");
	    	System.out.println(newFilm);
	        dao.insertFilm(newFilm);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    // Set a success message to be displayed on the AddFilms.jsp page
	    request.setAttribute("successMessage", "Film added successfully");
	    
	    response.sendRedirect(request.getContextPath() + "/Films");

	}



	    }
	

