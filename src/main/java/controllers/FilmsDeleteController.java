package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FilmDAO;
import models.Film;

/**
 * Servlet implementation class FilmsDeleteController
 */
@WebServlet("/Delete")
public class FilmsDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FilmDAO dao = new FilmDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmsDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    
		Film film = dao.getFilmByID(Integer.parseInt(request.getParameter("id")));

	    try {
	    	System.out.println("is this even getting executed");
	    	System.out.println("The below is the film object being outputted that is going to be deleted");
	    	System.out.println(film);
	    	dao.deleteFilmObj(film);
	        System.out.println("Film Deleted Successfully");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	 // Redirect the user to the "/Films" servlet
        response.sendRedirect(request.getContextPath() + "/Films");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}		



}
