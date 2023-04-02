import Singleton.ConnectionSingleton;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DataBaseTest {

    @Test
    public static void checkAllActors(){
        Map<Long, String> allActors = new HashMap<>();
        try {
            Statement st = ConnectionSingleton.getInstance().createStatement();
            String request = "SELECT * FROM actor";
            ResultSet resultSet = st.executeQuery(request);
            while (resultSet.next()){
                long id = resultSet.getLong("actor_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String fullName = first_name.concat(" ").concat(last_name);
                System.out.printf("%d: %s%n", id, fullName);
                allActors.put(id, fullName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(allActors.containsValue("PENELOPE GUINESS"), "The Actor table does not have 'KIM ALLEN' person");
    }

}
