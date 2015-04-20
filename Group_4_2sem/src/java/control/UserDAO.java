package control;

import interfaces.Interface_UserDAO;
import model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO implements Interface_UserDAO {

    @Override
    public void createNewUser(User user) throws SQLException, ClassNotFoundException {
        PreparedStatement prep = null;
        Connection connection = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "INSERT INTO USERS (ID,USERNAME,PASSWORD,FIRSTNAME,LASTNAME,EMAIL,PHONENUM,ORGANIZATION,USERTYPE) VALUES (user_seq.nextval,?,?,?,?,?,?,?,?)"; // SQL query til databasen som indsætter en ny column med de indtastede informationer. user_seq.nextval aktiverer en sequence i databasen som fungerer some Auto_Increment.
            prep = connection.prepareStatement(query);
            prep.setString(1, user.getUserName());
            prep.setString(2, user.getPassWord());
            prep.setString(3, user.getFirstName());                             // Sætter ?-tegnene i queryen til de givne variabler fra User objektet.
            prep.setString(4, user.getLastName());
            prep.setString(5, user.getEmail());
            prep.setInt(6, user.getPhoneNum());
            prep.setString(7, user.getOrganization());
            prep.setInt(8, user.getType());
            prep.executeQuery();
        } finally {
            prep.close();                                                       // Lukker forbindelser.
            connection.close();
        }
    }

    @Override
    public void deleteUser(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = null;
        Connection connection = null;                             

        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "DELETE FROM USERS WHERE USERNAME=?";                      // Sletter den column hvor ID'et matcher det ID som er passeret ind i metoden.
            statement = connection.prepareStatement(query);                     // Opretter forbindelse til til databasen for statement
            statement.setString(1, name);
            statement.executeQuery();
        } finally {
            statement.close();                                                  // Lukker forbindelser
            connection.close();
        }
    }

    public static User getUserInfo(String name) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        User getUser = null;

        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "SELECT * FROM USERS WHERE USERNAME = ?";                               // Henter alle informationer gemt i USERS table i databasen
            statement = connection.prepareStatement(query);                           // Opretter forbindelse til databasen for statement
            statement.setString(1, name);
            rs = statement.executeQuery();
            while (rs.next()) {
                getUser = new User(rs.getInt("ID"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getInt("PHONENUM"), rs.getString("ORGANIZATION"), rs.getInt("USERTYPE"));
                // Fylder Arraylisten med User objekter fra databasen
            }
        } finally {
            statement.close();                                                  // Lukker forbindelser
            connection.close();
        }
        return getUser;                                                         // Returnerer Arraylisten fyldt med all User objekter fra databasen
    }
    
    public boolean getUser(String username, String password) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        User getUser = null;
        boolean correctLogin = false;
        String tempUsername = null;
        String tempPassword = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "SELECT USERNAME,PASSWORD FROM USERS WHERE USERNAME = ?";                               // Henter alle informationer gemt i USERS table i databasen
            statement = connection.prepareStatement(query);                           // Opretter forbindelse til databasen for statement
            statement.setString(1, username);
            rs = statement.executeQuery();
            while (rs.next()) {
                tempUsername = rs.getString("USERNAME");
                tempPassword = rs.getString("PASSWORD");
            }
            if (username.equals(tempUsername) && password.equals(tempPassword)){
                correctLogin = true;
            }
        } finally {
            statement.close();                                                  // Lukker forbindelser
            connection.close();
        }
        return correctLogin;
    }
}
