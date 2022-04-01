package com.revature.Repository;


import com.revature.Model.Enums.Role;
import com.revature.Model.User;
import com.revature.Tools.ConnectionFactory;
import com.revature.Tools.Log;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepository {


    //  This method populates a new row in the SQL database
    //  under each specific column with user-inputted data from register() method




    public static boolean createUser(User user){
        Connection connection;

        try {
            connection = ConnectionFactory.getConnection();

            // try to create a user with given credentials
            String statement = "insert into ers_users (username, email, password, first_name, last_name, is_active, role_id) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement sqlInsert = connection.prepareStatement(statement);
            sqlInsert.setString(1,user.getUsername());
            sqlInsert.setString(2, user.getEmail());
            sqlInsert.setString(3,user.getPassword());
            sqlInsert.setString(4, user.getFirstName());
            sqlInsert.setString(5, user.getLastName());
            sqlInsert.setBoolean(6, user.isActive());
            sqlInsert.setInt(7, user.getRole().ordinal());

            sqlInsert.executeUpdate();

            //now we look for the just created user to see if it was created
            String statement2 = "select * from ers_users where username = ? and password = ?";
            PreparedStatement sqlQuery = connection.prepareStatement(statement2);
            sqlQuery.setString(1, user.getUsername());
            sqlQuery.setString(2, user.getPassword());


            ResultSet resultSet = sqlQuery.executeQuery();
            if (resultSet.next()) {
                return true;
            }

            } catch (SQLException e) {
                Log.setupLogger();
                Log.logMessage("warn", e.getMessage());
            }
            return false;
        }

    public User login(User user){
        Connection connection;

        try {
            connection = ConnectionFactory.getConnection();

            String statement = "select * from ers_users where username = ? and password = ?";
            PreparedStatement sqlQuery = connection.prepareStatement(statement);
            sqlQuery.setString(1, user.getUsername());
            sqlQuery.setString(2, user.getPassword());


            ResultSet resultSet = sqlQuery.executeQuery();

            if (resultSet.next()) {
                user.setUserId(resultSet.getInt("user_id"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setActive(resultSet.getBoolean("is_active"));
                user.setRole(Role.values()[resultSet.getInt("role_id")]);
            }
        } catch (SQLException e) {
            Log.logMessage("warn", e.getMessage());
        }
        System.out.println(user);
        //
        return user;

    }


    public ArrayList<User> getAll(){
        ArrayList<User> users = new ArrayList<>();

        try(Connection connection = ConnectionFactory.getConnection()){
            String sql = "select * from ers_users";
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
                users.add(new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getBoolean("is_active"),
                        Role.values()[resultSet.getInt("role_id")]
                        )
                );
            }
        } catch (Exception e) {
            //logger.warn(e);
        }
        return users;
    }




}
