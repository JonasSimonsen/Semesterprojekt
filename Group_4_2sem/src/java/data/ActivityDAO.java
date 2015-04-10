package data;

import model.Activity;
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
        String COMMENTDATE = activity.getDate();                                // Variabler som henter values fra Activity objektet passeret igennem servletten.
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);  // Opretter forbindelse til databasen med info fra DB klassen
            statement = connection.createStatement();                           // Opretter forbindelse til til databasen for statement
            String query = "INSERT INTO PARTNERS (COMMENTS,PLANNO,COMMENTDATE,ID) VALUES ('" + COMMENTS + "'," + PLANNO + ",'" + COMMENTDATE + "'," + ID + ")";  // Indsætter en ny partner i PARTNERS table i databasen
            statement.executeQuery(query);                                      // Sender queryen ind i databasen
        } finally {  
            statement.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        }
    }
    public static ArrayList<Activity> getActivity() throws SQLException, ClassNotFoundException{
        ArrayList<Activity> getActivity = new ArrayList();                      // Opretter Arraylist til at indeholde Activity objekter
        ResultSet rs = null;
        Statement statement = null;
        Connection connection = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);  // Opretter forbindelse til databasen med info fra DB klassen
            statement = connection.createStatement();                           // Opretter forbindelse til til databasen for statement
            String query = "SELECT * FROM PARTNERPLAN";                         // Vælger alle informationer i PARTNERPLAN table
            rs = statement.executeQuery(query);
            while (rs.next()) {
                getActivity.add(new Activity(rs.getString("COMMENTS"),rs.getInt("PLANNO"),rs.getString("COMMENTDATE"),rs.getInt("ID"))); // Tilføjer Activity objekter til Arraylisten
            }
        } finally {
            statement.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        }
        return getActivity;                                                     // Returnerer Arraylisten med alle Activity objekterne igennem metoden
    }
}
