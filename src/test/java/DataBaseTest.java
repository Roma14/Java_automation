
import models.Actor;
import models.Film;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PostGresUtil;


import java.util.List;


public class DataBaseTest{

    @Test
    public static void checkFilmsReleasedBetweenYears(){
        List<Film> resultFilms = PostGresUtil.getFilmsReleasedBetween(2005, 2007);
        Assert.assertTrue(resultFilms.size() > 0, "There are no films released in specified interval");
    }

    @Test
    public static void checkFilmsFilteredByCategory(){
        List<Film> resultFilms = PostGresUtil.getFilmsFilteredByCategory("Comedy");
        Assert.assertTrue(resultFilms.size() > 0, "There are no films filtered by specified categories");
    }

    @Test
    public static void checkActorsFilteredByFilmCategoryAndReleaseYear(){
        List<Actor> resultActors = PostGresUtil.getActorsFilteredByFilmCategoryAndYear("Drama", 1998 );
        Assert.assertTrue(resultActors.size() > 0, "There are no actors filtered by specified categories");
    }

    @Test
    public static void checkTopActorsWithMostFilmsAmount(){
        int topCount = 3;
        List<Actor> resultActors = PostGresUtil.getTopActorsWithMostFilmsAmount(topCount);
        Assert.assertTrue(resultActors.size() == (topCount + 1), "There are wrong amount of actors");
    }

}
