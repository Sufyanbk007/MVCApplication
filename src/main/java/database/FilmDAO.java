package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Film;



public class FilmDAO {
	
	Film oneFilm = null;
	Connection conn = null;
    Statement stmt = null;
	String user = "khurrams";
    String password = "plimcerN2";
    // Note none default port used, 6306 not 3306
    String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/"+user;

	public FilmDAO() {}

	
	private void openConnection(){
		// loading jdbc driver for mysql
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch(Exception e) { System.out.println(e); }

		// connecting to database
		try{
			// connection string for demos database, username demos, password demos
 			conn = DriverManager.getConnection(url, user, password);      
		    stmt = conn.createStatement();
		} catch(SQLException se) { System.out.println(se); }	   
    }
	
	
	private void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private Film getNextFilm(ResultSet rs){
    	Film thisFilm=null;
		try {
			thisFilm = new Film(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getInt("year"),
					rs.getString("director"),
					rs.getString("stars"),
					rs.getString("review"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return thisFilm;		
	}
	
	
	
   public ArrayList<Film> getAllFilms(){
	   
		ArrayList<Film> allFilms = new ArrayList<Film>();
		openConnection();
		
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from films";
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    	allFilms.add(oneFilm);
		   }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return allFilms;
   }

   public Film getFilmByID(int id){
	   
		openConnection();
		oneFilm=null;
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from films where id="+id;
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return oneFilm;
   }
   
   public boolean insertFilm(Film film) throws SQLException {
	    boolean result = false;
	    try {
	        openConnection();
	        String sql = "INSERT INTO films (id, title, year, director, stars, review) VALUES (?, ?, ?, ?, ?, ?)";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, film.getId());
	        stmt.setString(2, film.getTitle());
	        stmt.setInt(3, film.getYear());
	        stmt.setString(4, film.getDirector());
	        stmt.setString(5, film.getStars());
	        stmt.setString(6, film.getReview());
	        int rowsInserted = stmt.executeUpdate();
	        if (rowsInserted > 0) {
	            System.out.println("A new film was inserted successfully!");
	            result = true;
	        }
	        closeConnection();
	    } catch (SQLException e) {
	        throw new SQLException("Film not inserted, something went wrong.", e);
	    }
	    return result;
	}
   
   public boolean editFilm(Film film) throws SQLException {
	    boolean result = false;
	    try {
	        openConnection();
	        String sql = "UPDATE films SET title = ?, year = ?, director = ?, stars = ?, review = ? WHERE id = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, film.getTitle());
	        stmt.setInt(2, film.getYear());
	        stmt.setString(3, film.getDirector());
	        stmt.setString(4, film.getStars());
	        stmt.setString(5, film.getReview());
	        stmt.setInt(6, film.getId());
	        int rowsUpdated = stmt.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("The film was updated successfully!");
	            result = true;
	        }
	        closeConnection();
	    } catch (SQLException e) {
	        throw new SQLException("Film not updated, something went wrong.", e);
	    }
	    return result;
	}
   
   public boolean deleteFilms(int id) throws SQLException {
	    boolean result = false;
	    try {
	        openConnection();
	        String sql = "DELETE FROM films WHERE id = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, id);
	        int rowsDeleted = stmt.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("The film was deleted successfully!");
	            result = true;
	        }
	        closeConnection();
	    } catch (SQLException e) {
	        throw new SQLException("Film not deleted, something went wrong.", e);
	    }
	    return result;
	}







	
	
   
   
   
   
   
   
}
