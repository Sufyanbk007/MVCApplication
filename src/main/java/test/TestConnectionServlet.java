package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FilmDAO;
import models.Film1;

@WebServlet("/TestConnectionServlet")
public class TestConnectionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        FilmDAO dao = new FilmDAO();
        
        ArrayList<Film1> allFilms = dao.getAllFilms();
        
        for(Film1 f: allFilms) {
        	out.write(f.getTitle());
        }

       out.close();
    }
}
