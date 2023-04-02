package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/dvd_rental";
    private static Connection connection;

    public static Connection getInstance(){
        if (connection == null){
            try {
                connection = DriverManager.getConnection(URL, "postgres", "root");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection = null;
    }
}
