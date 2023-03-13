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
@WebServlet("/")
public class FilmsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmsController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	 dao = new FilmDAO();
    	
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	doGet(request, response);	        
    }  
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Retrieve the servlet path from the request object
		String action = request.getServletPath();
		

			try {
				
				// Use a switch statement to determine which action to perform based on the servlet path
				switch (action) {
				
				case "/insert":
					insertFilm(request, response);
					break;
				
				case "/delete":
					deleteFilm(request, response);
					break;
					
				case "/edit":
					showEditFilms(request, response);
					break;
					
				case "/update":
					updateFilm(request, response);
					break;
					
				case "/new":
					showAddFilmJsp(request, response);
					break;
					
					default:
						// If the path is none of the above, call the showFilmList method to display a list of all the films in the database
						showFilmList(request, response);
						break;
				}
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	private void showAddFilmJsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = request.getRequestDispatcher("AddFilms.jsp");
		rd.forward(request, response);
		
	}
	
	
	private void showFilmList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Film> allFilms = dao.getAllFilms();
		
		request.setAttribute("allFilms", allFilms);
		
		RequestDispatcher rd = request.getRequestDispatcher("ListFilms.jsp");
		
		rd.forward(request, response);
	}
	
	private void insertFilm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filmIdParam = request.getParameter("filmId");
		//Some sysouts to check if the filmID is being passed through?
		System.out.println("filmIdParam: " + filmIdParam);
		int filmId = Integer.parseInt(filmIdParam);
		
	    String filmTitle = request.getParameter("filmTitle");
	    int filmYear = Integer.parseInt(request.getParameter("filmYear"));
	    String filmDirector = request.getParameter("filmDirector");
	    String filmStars = request.getParameter("filmStars");
	    String filmReview = request.getParameter("filmReview"); 
	    
    	// Create a new film object
    	Film newFilm = new Film( filmId,  filmTitle,  filmYear,  filmDirector,  filmStars,
    			filmReview);
    	
    	// Add the new film to the database
    	try {
    		dao.insertFilm(newFilm);
    		response.sendRedirect("films");
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}

	}
	
	
	private void showEditFilms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filmIdParam = request.getParameter("id");
		System.out.println("filmIdParam: " + filmIdParam);
		int filmId = Integer.parseInt(filmIdParam);

		
		Film existingFilm = dao.getFilmByID(filmId);
		
		RequestDispatcher rd = request.getRequestDispatcher("AddFilms.jsp");
		
		
		request.setAttribute("film", existingFilm);
		
		rd.forward(request, response);
		
	}
	
	private void deleteFilm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filmIdParam = request.getParameter("id");
		System.out.println("filmIdParam: " + filmIdParam);
		int filmId = Integer.parseInt(filmIdParam);

		
		
		try {
			dao.deleteFilms(filmId);
			response.sendRedirect("films");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void updateFilm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String filmIdParam = request.getParameter("id");
		System.out.println("filmIdParam: " + filmIdParam);
		int filmId = Integer.parseInt(filmIdParam);
		
	    String filmTitle = request.getParameter("filmTitle");
	    
	    int filmYear = Integer.parseInt(request.getParameter("filmYear"));
	    String filmDirector = request.getParameter("filmDirector");
	    String filmStars = request.getParameter("filmStars");
	    String filmReview = request.getParameter("filmReview");  
	    
    	// Create a new film object
    	Film editExistingFilm = new Film( filmId,  filmTitle,  filmYear,  filmDirector,  filmStars, filmReview);
	
    	try {
			dao.editFilm(editExistingFilm);
			response.sendRedirect("films");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

	    }
	

