import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/dvd_rental";

    public static void main(String[] args) {
        int[] array = new int[]{1,2,4};
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Roma");
        myList.add(0,"Lola");

        Arrays.copyOf(array, array.length * 2);
        System.out.println(myList.toString());
        System.out.println(Arrays.toString(array));
//        try {
//            Connection connection = DriverManager.getConnection(URL, "postgres", "root");
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM actor");
//
//            while(resultSet.next()){
//                long id = resultSet.getLong("actor_id");
//                String first_name = resultSet.getString("first_name");
//                String last_name = resultSet.getString("last_name");
//
//                System.out.printf("%d: %s %s%n", id, first_name, last_name);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }
}
