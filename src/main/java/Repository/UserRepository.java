package Repository;


import Model.User;
import Tools.ConnectionFactory;
import Tools.Log;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {


    //  This method populates a new row in the SQL database
    //  under each specific column with user-inputted data from register() method

    public static void createUser(String username, String password){

    }

    public static User login(String username, String password){
        Connection connection;

        try {
            connection = ConnectionFactory.getConnection();

            String statment = "select * from ers_users where username = ? and password = ?";
            PreparedStatement sqlQuery = connection.prepareStatement(statment);
            sqlQuery.setString(1, username);
            sqlQuery.setString(2, password);


            ResultSet resultSet = sqlQuery.executeQuery();

            if (resultSet.next()) {
                return new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getBoolean(7), resultSet.getString(8));
            }
        } catch (SQLException e) {
            Log.logMessage("warn", e.getMessage());
        }

        //
        return new User();

    }




}
