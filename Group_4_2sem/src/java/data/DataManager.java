package data;

import entity.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataManager {

    public void createNewUser(ArrayList<external_user> external) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        Statement statement = null;
        Connection connection = null;
        int ID, PHONENUM, USERTYPE;
        String USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ORGANIZATION;
        
        
        try {
            Class.forName(DatabaseInfo.driver);
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);
            statement = connection.createStatement();
            String query = "INSERT INTO USERS (ID,USERNAME,PASSWORD,FIRSTNAME,LASTNAME,EMAIL,PHONENUM,ORGANIZATION,USERTYPE) VALUES (" + ;
            rs = statement.executeQuery(query);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public void deleteUser(ArrayList<internal_user> internal) throws SQLException, ClassNotFoundException {
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

    public static ArrayList<external_user> getUserInfo() throws SQLException, ClassNotFoundException {
        ArrayList<external_user> getUser = new ArrayList();
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
                getUser.add(new external_user(rs.getInt("ID"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getInt("PHONENUM"), rs.getString("ORGANIZATION"), rs.getInt("USERTYPE")));
            }
        } finally {
            statement.close();
            connection.close();
        }
        return getUser;
    }
}
