package data;

import entity.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataManager {

    public void createNewUser(User external) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        Statement statement = null;
        Connection connection = null;
        int ID, PHONENUM, USERTYPE;
        String USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ORGANIZATION;
        ID = external.getPartnerId();
        PHONENUM = external.getPhoneNum();
        USERTYPE = external.getType();
        USERNAME = external.getUserName();
        PASSWORD = external.getPassWord();
        FIRSTNAME = external.getFirstName();
        LASTNAME = external.getLastName();
        EMAIL = external.getEmail();
        ORGANIZATION = external.getOrganization();

        try {
            Class.forName(DatabaseInfo.driver);
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);
            statement = connection.createStatement();
            String query = "INSERT INTO USERS (ID,USERNAME,PASSWORD,FIRSTNAME,LASTNAME,EMAIL,PHONENUM,ORGANIZATION,USERTYPE) VALUES (" + ID + ",'" + USERNAME + "','" + PASSWORD + "','" + FIRSTNAME + "','" + LASTNAME + "','" + EMAIL + "'," + PHONENUM + ",'" + ORGANIZATION + "'," + USERTYPE + ")";
            statement.executeQuery(query);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public void deleteUser(ArrayList<User> internal) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        Statement statement = null;
        Connection connection = null;

        try {
            Class.forName(DatabaseInfo.driver);
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);
            statement = connection.createStatement();
            String query = "";
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
            String query = "";
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
