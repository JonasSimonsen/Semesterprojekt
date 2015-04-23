package data;

import interfaces.Interface_ActivityDAO;
import model.Activity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActivityDAO implements Interface_ActivityDAO {
    @Override
    public void createNewActivity(Activity activity) throws SQLException, ClassNotFoundException{
        PreparedStatement prep = null;
        Connection connection = null;
        
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);  // Opretter forbindelse til databasen med info fra DB klassen
            String query = "INSERT INTO ACTIVITY (COMMENTID,COMMENTS,CAMPNO,COMMENTDATE,ACT_ID) VALUES (act_seq.nextval,?,(SELECT CAMPNO FROM CAMPAIGN WHERE CAMPNO=?),?,(SELECT ID FROM USERS WHERE ID=?))";  // Indsætter en ny partner i PARTNERS table i databasen
            prep = connection.prepareStatement(query);                           // Opretter forbindelse til til databasen for statement
            prep.setString(1, activity.getComments());
            prep.setInt(2, activity.getCampNum());
            prep.setString(3, activity.getDate());
            prep.setInt(4, activity.getID());
            prep.executeQuery();                                      // Sender queryen ind i databasen
        } finally {  
            prep.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        }
    }
    
    @Override
    public ArrayList<Activity> getActivity() throws SQLException, ClassNotFoundException{
        ArrayList<Activity> getActivity = new ArrayList();                      // Opretter Arraylist til at indeholde Activity objekter
        ResultSet rs = null;
        PreparedStatement prep = null;
        Connection connection = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);  // Opretter forbindelse til databasen med info fra DB klassen
            String query = "SELECT * FROM ACTIVITY";                         // Vælger alle informationer i PARTNERPLAN table
            prep = connection.prepareStatement(query);                           // Opretter forbindelse til til databasen for statement
            rs = prep.executeQuery();
            while (rs.next()) {
                getActivity.add(new Activity(rs.getInt("COMMENTID"),rs.getString("COMMENTS"),rs.getInt("CAMPNO"),rs.getString("COMMENTDATE"),rs.getInt("ACT_ID"))); // Tilføjer Activity objekter til Arraylisten
            }
        } finally {
            prep.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        }
        return getActivity;                                                     // Returnerer Arraylisten med alle Activity objekterne igennem metoden
    }
    
    @Override
    public ArrayList<Activity> getSpecificActivity(int ID) throws SQLException, ClassNotFoundException{
        ArrayList<Activity> getActivity = new ArrayList();                      // Opretter Arraylist til at indeholde Activity objekter
        ResultSet rs = null;
        PreparedStatement prep = null;
        Connection connection = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);  // Opretter forbindelse til databasen med info fra DB klassen
            String query = "SELECT * FROM ACTIVITY WHERE CAMPNO = ?";                         // Vælger alle informationer i PARTNERPLAN table
            prep = connection.prepareStatement(query);                           // Opretter forbindelse til til databasen for statement
            prep.setInt(1, ID);
            rs = prep.executeQuery();
            while (rs.next()) {
                getActivity.add(new Activity(rs.getInt("COMMENTID"),rs.getString("COMMENTS"),rs.getInt("CAMPNO"),rs.getString("COMMENTDATE"),rs.getInt("ACT_ID"))); // Tilføjer Activity objekter til Arraylisten
            }
        } finally {
            prep.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        }
        return getActivity;                                                     // Returnerer Arraylisten med alle Activity objekterne igennem metoden
    }
}
