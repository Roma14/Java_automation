package utils;

import Singleton.ConnectionSingleton;
import models.Film;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PostGresUtil {

    public static ResultSet executeQuery(String request){
        ResultSet resultSet = null;
        try {
            Statement st = ConnectionSingleton.getInstance().createStatement();
            resultSet = st.executeQuery(request);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionSingleton.closeConnection();
            return resultSet;
        }
    }

    public static List<Film> getFilmsReleasedBetween(int startYear, int finalYear){
        List<Film> filmList = new ArrayList<>();
        String request = "SELECT * FROM film WHERE release_year BETWEEN ? AND ? ORDER BY length DESC";
        try{
            PreparedStatement pstmt = ConnectionSingleton.getInstance().prepareStatement(request);
            pstmt.setInt(1, startYear);
            pstmt.setInt(2, finalYear);
            ResultSet result= pstmt.executeQuery();

            while (result.next()){
                long film_id = result.getLong("film_id");
                String title = result.getString("title");
                String description = result.getString("description");
                int release_year = result.getInt("release_year");
                double rental_rate = result.getDouble("rental_rate");
                int length = result.getInt("length");
                String rating = result.getString("rating");
                Film film  = new Film(film_id, title, description, release_year, rental_rate, length, rating );
                filmList.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionSingleton.closeConnection();
            return filmList;
        }
    }


    public static List<Film> getFilmsFilteredByCategoryAndRating(String category, String ratings){
        List<Film> filmList = new ArrayList<>();
        String request = "SELECT * FROM film" +
                "JOIN film_category ON film.film_id = film_category.film_id" +
                "JOIN category ON film_category.category_id = category.category_id" +
                "WHERE category.name = ? AND film.rating = ?";
        try{
            PreparedStatement pstmt = ConnectionSingleton.getInstance().prepareStatement(request);
            pstmt.setString(1, category);
            pstmt.setString(2, ratings);
            ResultSet result= pstmt.executeQuery();

            while (result.next()){
                long film_id = result.getLong("film_id");
                String title = result.getString("title");
                String description = result.getString("description");
                int release_year = result.getInt("release_year");
                double rental_rate = result.getDouble("rental_rate");
                int length = result.getInt("length");
                String rating = result.getString("rating");
                System.out.println(film_id +  title );
                Film film  = new Film(film_id, title, description, release_year, rental_rate, length, rating );
                filmList.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionSingleton.closeConnection();
            return filmList;
        }
    }

}
