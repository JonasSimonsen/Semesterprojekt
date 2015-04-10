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
        ResultSet rs = null;
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
        ORGANIZATION = user.getOrganization();

        try {
            Class.forName(DatabaseInfo.driver);
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);
            statement = connection.createStatement();
            String query = "INSERT INTO USERS (ID,USERNAME,PASSWORD,FIRSTNAME,LASTNAME,EMAIL,PHONENUM,ORGANIZATION,USERTYPE) VALUES (user_seq.nextval,'" + USERNAME + "','" + PASSWORD + "','" + FIRSTNAME + "','" + LASTNAME + "','" + EMAIL + "'," + PHONENUM + ",'" + ORGANIZATION + "'," + USERTYPE + ")";
            statement.executeQuery(query);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public void deleteUser(User user) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
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
        ORGANIZATION = user.getOrganization();
        
        
        try {
            Class.forName(DatabaseInfo.driver);
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);
            statement = connection.createStatement();
            String query = "DELETE FROM USERS WHERE ID=" + ID;
            rs = statement.executeQuery(query);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public static ArrayList<User> getUserInfo() throws SQLException, ClassNotFoundException {
        ArrayList<User> getUser = new ArrayList();
        ResultSet rs = null;
        Statement statement = null;
        Connection connection = null;

        try {
            Class.forName(DatabaseInfo.driver);
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);
            statement = connection.createStatement();
            String query = "SELECT * FROM USERS";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                getUser.add(new User(rs.getInt("ID"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getInt("PHONENUM"), rs.getString("ORGANIZATION"), rs.getInt("USERTYPE")));
            }
        } finally {
            statement.close();
            connection.close();
        }
        return getUser;
    }
}
