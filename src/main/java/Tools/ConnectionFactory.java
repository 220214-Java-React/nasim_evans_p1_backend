package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private ConnectionFactory() {}

    private static Connection connection;

    private static final String url = "jdbc:postgresql://java-react.cewgx1k1p4rc.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=project1";
    private static final String username = "postgres";
    private static final String password = "sJits7549!";

    //getScanner: gives the connection the the database where needed
    //            creates a connection to the database first time called
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, username, password);
        }

        return connection;
    }

    //closeScanner: closes the connection. used once program ends for clean end
    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }


}
