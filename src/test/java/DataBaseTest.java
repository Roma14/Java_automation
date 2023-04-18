
import models.Film;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PostGresUtil;
import java.util.List;


public class DataBaseTest {

    @Test
    public static void checkFilmsReleasedBetweenYears(){
        List<Film> resultFilms = PostGresUtil.getFilmsReleasedBetween(2005, 2007);
        System.out.print(resultFilms);
        Assert.assertTrue(resultFilms.size() > 0, "There are no films released in specified interval");
    }

    @Test
    public static void checkFilmsFilteredByCategoryAndRating(){
        List<Film> resultFilms = PostGresUtil.getFilmsFilteredByCategoryAndRating("Comedy", "R");
        System.out.print(resultFilms);
        Assert.assertTrue(resultFilms.size() > 0, "There are no films filtered by specified categories");
    }

}
