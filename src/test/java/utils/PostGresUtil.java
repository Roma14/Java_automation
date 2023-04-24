package utils;

import Singleton.ConnectionSingleton;
import models.Actor;
import models.Film;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PostGresUtil {
    protected static Logger logger = Logger.getLogger(ConnectionSingleton.class);

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
            logger.debug("Request to DataBase performed");

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
                logger.info(String.format("Film %s is added to List", film.toString()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionSingleton.closeConnection();
            logger.info(String.format("Film list  %s returned", filmList.toString()));
            return filmList;
        }
    }

    public static List<Film> getFilmsFilteredByCategory(String category){
        List<Film> filmList = new ArrayList<>();
        String request = "SELECT * FROM film " +
                "JOIN film_category ON film.film_id = film_category.film_id " +
                "JOIN category ON film_category.category_id = category.category_id " +
                "WHERE category.name = ? AND film.rating = 'R'";
        try{
            PreparedStatement pstmt = ConnectionSingleton.getInstance().prepareStatement(request);
            pstmt.setString(1, category);
            ResultSet result= pstmt.executeQuery();
            logger.debug("Request to DataBase performed");

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
                logger.info(String.format("Film %s is added to list", film.toString()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionSingleton.closeConnection();
            logger.info(String.format("Film list  %s returned", filmList.toString()));
            return filmList;
        }
    }

    public static List<Actor> getActorsFilteredByFilmCategoryAndYear(String filmCategory, int filmYearRelease ){
        List<Actor> filmList = new ArrayList<>();
        String request = "SELECT DISTINCT actor.actor_id, actor.first_name,actor.last_name FROM film" +
                " JOIN film_category ON film.film_id = film_category.film_id" +
                " JOIN category ON film_category.category_id = category.category_id" +
                " JOIN film_actor ON film.film_id = film_actor.film_id" +
                " JOIN actor ON film_actor.actor_id = actor.actor_id" +
                " WHERE category.name = ? AND film.release_year < ?" +
                " ORDER BY actor_id;";
        try{
            PreparedStatement pstmt = ConnectionSingleton.getInstance().prepareStatement(request);
            pstmt.setString(1, filmCategory);
            pstmt.setInt(2, filmYearRelease);
            ResultSet result= pstmt.executeQuery();
            logger.debug("Request to DataBase performed");

            while (result.next()){
                long actor_id = result.getLong("actor_id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                Actor actor  = new Actor(actor_id, firstName, lastName);
                filmList.add(actor);
                logger.info(String.format("Actor %s starred in %s film created before %d ", actor.toString(), filmCategory,filmYearRelease));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionSingleton.closeConnection();
            logger.info(String.format("Actor list returned: %s", filmList.toString()));
            return filmList;
        }
    }

    public static List<Actor> getTopActorsWithMostFilmsAmount(int topCount ){
        List<Actor> filmList = new ArrayList<>();
        String request = "SELECT actor.actor_id, actor.first_name, actor.last_name " +
                "FROM actor JOIN film_actor ON actor.actor_id = film_actor.actor_id " +
                "GROUP BY actor.actor_id " +
                "ORDER BY  COUNT(film_actor.actor_id)  DESC " +
                "LIMIT ?";
        try{
            PreparedStatement pstmt = ConnectionSingleton.getInstance().prepareStatement(request);
            pstmt.setInt(1, topCount);
            ResultSet result= pstmt.executeQuery();
            logger.debug("Request to DataBase performed");

            while (result.next()){
                long actor_id = result.getLong("actor_id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                Actor actor  = new Actor(actor_id, firstName, lastName);
                filmList.add(actor);
                logger.info(String.format("Actor %s is added to list", actor.toString()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionSingleton.closeConnection();
            logger.info(String.format("Top %d actor list returned: %s", topCount, filmList.toString()));
            return filmList;
        }
    }

}
