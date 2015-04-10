package data;

import model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO {

    public void createNewUser(User user) throws SQLException, ClassNotFoundException {
        Statement statement = null;
        Connection connection = null;
        int ID, PHONENUM, USERTYPE;
        String USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ORGANIZATION;
        ID = user.getPartnerId();
        PHONENUM = user.getPhoneNum();
        USERTYPE = user.getType();
        USERNAME = user.getUserName();
        PASSWORD = user.getPassWord();
        FIRSTNAME = user.getFirstName();
        LASTNAME = user.getLastName();
        EMAIL = user.getEmail();
        ORGANIZATION = user.getOrganization();                                  // Variabler som henter values fra User objektet passeret igennem servletten.

        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            statement = connection.createStatement();                           // Opretter forbindelse til til databasen for statement
            String query = "INSERT INTO USERS (ID,USERNAME,PASSWORD,FIRSTNAME,LASTNAME,EMAIL,PHONENUM,ORGANIZATION,USERTYPE) VALUES (user_seq.nextval,'" + USERNAME + "','" + PASSWORD + "','" + FIRSTNAME + "','" + LASTNAME + "','" + EMAIL + "'," + PHONENUM + ",'" + ORGANIZATION + "'," + USERTYPE + ")";  // SQL query til databasen som indsætter en ny column med de indtastede informationer. user_seq.nextval aktiverer en sequence i databasen som fungerer some Auto_Increment.
            statement.executeQuery(query);
        } finally {
            statement.close();                                                  // Lukker forbindelser.
            connection.close();
        }
    }

    public void deleteUser(User user) throws SQLException, ClassNotFoundException {
        Statement statement = null;
        Connection connection = null;
        int ID, PHONENUM, USERTYPE;
        String USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ORGANIZATION;
        ID = user.getPartnerId();
        PHONENUM = user.getPhoneNum();
        USERTYPE = user.getType();
        USERNAME = user.getUserName();
        PASSWORD = user.getPassWord();
        FIRSTNAME = user.getFirstName();
        LASTNAME = user.getLastName();
        EMAIL = user.getEmail();
        ORGANIZATION = user.getOrganization();                                  // Variabler som henter values fra User objektet passeret igennem servletten.
        
        
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            statement = connection.createStatement();                           // Opretter forbindelse til til databasen for statement
            String query = "DELETE FROM USERS WHERE ID=" + ID;                  // Sletter den column hvor ID'et matcher det ID som er passeret ind i metoden.
            statement.executeQuery(query);
        } finally {
            statement.close();                                                  // Lukker forbindelser
            connection.close();
        }
    }

    public static ArrayList<User> getUserInfo() throws SQLException, ClassNotFoundException {
        ArrayList<User> getUser = new ArrayList();                              // Opretter ArrayList til at sende tilbage igennem metoden.
        ResultSet rs = null;
        Statement statement = null;
        Connection connection = null;

        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            statement = connection.createStatement();                           // Opretter forbindelse til databasen for statement
            String query = "SELECT * FROM USERS";                               // Henter alle informationer gemt i USERS table i databasen
            rs = statement.executeQuery(query);
            while (rs.next()) {
                getUser.add(new User(rs.getInt("ID"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getInt("PHONENUM"), rs.getString("ORGANIZATION"), rs.getInt("USERTYPE")));
                // Fylder Arraylisten med User objekter fra databasen
            }
        } finally {
            statement.close();                                                  // Lukker forbindelser
            connection.close();
        }
        return getUser;                                                         // Returnerer Arraylisten fyldt med all User objekter fra databasen
    }
}
