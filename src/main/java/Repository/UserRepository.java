package Repository;


import Model.User;
import Tools.ConnectionFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    User user;

    private static final Logger logger = LogManager.getLogger(ConnectionFactory.class);
    public User currentUser;

    //  This method populates a new row in the SQL database
    //  under each specific column with user-inputted data from register() method

    public User createUser(String username, String password){
        User user = null;

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "insert into users(username, password) values (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet resultSet = stmt.executeQuery();

            if(resultSet.next()){
                user = new User(
                        resultSet.getString("username"),
                        resultSet.getString("password")

                );
            }
        } catch (SQLException e) {
            logger.warn(e.getMessage(), e);
        }
        return user;
    }

    public boolean checkLogin(String username, String password){

        try (Connection connection = ConnectionFactory.getConnection()) {

            String sql = "select id, username,password from users where userName=?"; //SQL-query
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();

            //Pull info from columns in table and assign to variables
            String orgUname = "", orPass = "";
            int orgId = 0;
            Double orBal = 0.00;

            while (rs.next()) {
                orgId = rs.getInt("id");
                orgUname = rs.getString("username");
                orPass = rs.getString("password");

            }

            //password validation
            if (orPass.equals(password)) {

                User dbUser = new User(orgUname, orPass); //creates an object to store table info from DB
                currentUser = dbUser; //converts object to be used in other packages/classes for convenience
                return true;
            } else {
                System.out.println("Invalid username or password.");
            }
        }
        catch (Exception e) {
        }
        return false;
    }


}
