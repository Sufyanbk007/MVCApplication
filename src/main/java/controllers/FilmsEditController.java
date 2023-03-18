package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FilmDAO;
import models.Film;

/**
 * Servlet implementation class FilmsEditController
 */
@WebServlet("/Edit")
public class FilmsEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmsEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the ID of the film to edit from the request parameters
        int filmId = Integer.parseInt(request.getParameter("id"));

        // Retrieve the film with the given ID from the database
        FilmDAO filmDAO = new FilmDAO();
        Film film = filmDAO.getFilmByID(filmId);

        // Set the film as an attribute of the request and forward to the edit film form
        request.setAttribute("film", film);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/EditFilms.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the form data from the request parameters
        int filmId = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        int year = Integer.parseInt(request.getParameter("year"));
        String director = request.getParameter("director");
        String stars = request.getParameter("stars");
        String review = request.getParameter("review");

        // Create a new Film object with the updated data
        Film film = new Film(filmId, title, year, director, stars, review);

        // Update the film in the database
        FilmDAO filmDAO = new FilmDAO();
        
        System.out.println("The below is the film object being outputted that is currently being edited");
        System.out.println(film);
        
        try {
            filmDAO.editFilm(film);
	        System.out.println("Film Edited Successfully");
            // Redirect to the film list page on successful edit
            response.sendRedirect(request.getContextPath() + "/Films");
        } catch (SQLException e) {
            // Display an error message on failure to update the film
            request.setAttribute("errorMessage", "Failed to update film.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/EditFilms.jsp");
            dispatcher.forward(request, response);
        }
    }

}
