package data;

import entity.Activity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ActivityDAO {
    public void createNewActivity(Activity activity) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        Connection connection = null;
        int ID = activity.getID();
        int PLANNO = activity.getPlanNo();
        String COMMENTS = activity.getComments();
        String COMMENTDATE = activity.getDate();
        try {
            Class.forName(DatabaseInfo.driver);
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);
            statement = connection.createStatement();
            String query = "INSERT INTO PARTNERS (COMMENTS,PLANNO,COMMENTDATE,ID) VALUES ('" + COMMENTS + "'," + PLANNO + ",'" + COMMENTDATE + "'," + ID + ")";
            statement.executeQuery(query);
        } finally {
            statement.close();
            connection.close();
        }
    }
    public static ArrayList<Activity> getActivity() throws SQLException, ClassNotFoundException{
        ArrayList<Activity> getActivity = new ArrayList();
        ResultSet rs = null;
        Statement statement = null;
        Connection connection = null;
        try {
            Class.forName(DatabaseInfo.driver);
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);
            statement = connection.createStatement();
            String query = "SELECT * FROM PARTNERPLAN";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                getActivity.add(new Activity(rs.getString("COMMENTS"),rs.getInt("PLANNO"),rs.getString("COMMENTDATE"),rs.getInt("ID")));
            }
        } finally {
            
        }
        
        return getActivity;
    }
}
