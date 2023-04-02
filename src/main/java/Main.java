import java.sql.*;

public class Main {

    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/dvd_rental";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, "postgres", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM actor");

            while(resultSet.next()){
                long id = resultSet.getLong("actor_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");

                System.out.printf("%d: %s %s%n", id, first_name, last_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
