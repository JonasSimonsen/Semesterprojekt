package data;

import interfaces.Interface_MessageDAO;
import DTO.Message;
import exceptions.DatabaseErrorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageDAO implements Interface_MessageDAO {

    private List<Message> getMessages = new ArrayList();                      // Opretter Arraylist til at indeholde Message objekter

    @Override
    public void createNewMessage(Message message) throws DatabaseErrorException, ClassNotFoundException {
        PreparedStatement prep = null;
        Connection connection = null;

        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);  // Opretter forbindelse til databasen med info fra DB klassen
            String query = "INSERT INTO MESSAGES (COMMENTID,COMMENTS,CAMPNO,COMMENTDATE,ACT_ID,USERNAME) VALUES (act_seq.nextval,?,(SELECT CAMPNO FROM CAMPAIGN WHERE CAMPNO=?),?,(SELECT ID FROM USERS WHERE ID=?),?)";  // Indsætter en ny partner i PARTNERS table i databasen
            prep = connection.prepareStatement(query);                           // Opretter forbindelse til til databasen for statement
            prep.setString(1, message.getComments());
            prep.setInt(2, message.getCampNum());
            prep.setString(3, message.getDate());
            prep.setInt(4, message.getID());
            prep.setString(5, message.getUsername());
            prep.executeQuery();                                      // Sender queryen ind i databasen
            prep.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        } catch (SQLException ex) {
            throw new DatabaseErrorException("Error in Database");
        }
    }

    @Override
    public List<Message> getMessages() throws DatabaseErrorException, ClassNotFoundException {
        getMessages = new ArrayList();                      // Opretter Arraylist til at indeholde Message objekter
        ResultSet rs = null;
        PreparedStatement prep = null;
        Connection connection = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);  // Opretter forbindelse til databasen med info fra DB klassen
            String query = "SELECT * FROM MESSAGES";                            // Vælger alle informationer i PARTNERPLAN table
            prep = connection.prepareStatement(query);                          // Opretter forbindelse til til databasen for statement
            rs = prep.executeQuery();
            while (rs.next()) {
                getMessages.add(new Message(rs.getInt("COMMENTID"), rs.getString("COMMENTS"), rs.getInt("CAMPNO"), rs.getString("COMMENTDATE"), rs.getInt("ACT_ID"), rs.getString("USERNAME"))); // Tilføjer Message objekter til Arraylisten
            }
            prep.close();                                                       // Lukker forbindelsen til databasen
            connection.close();
        } catch (SQLException ex) {
            throw new DatabaseErrorException("Error in Database");
        }
        return getMessages;                                                     // Returnerer Arraylisten med alle Message objekterne igennem metoden
    }

    @Override
    public List<Message> getSpecificMessage(int ID) throws DatabaseErrorException, ClassNotFoundException {
        getMessages = new ArrayList();                      // Opretter Arraylist til at indeholde Message objekter
        ResultSet rs = null;
        PreparedStatement prep = null;
        Connection connection = null;
        int test = 0;
        System.out.println("what is going on");
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);  // Opretter forbindelse til databasen med info fra DB klassen
            String query = "SELECT * FROM MESSAGES WHERE CAMPNO = ?";           // Vælger alle informationer i PARTNERPLAN table
            prep = connection.prepareStatement(query);                          // Opretter forbindelse til til databasen for statement
            prep.setInt(1, ID);
            rs = prep.executeQuery();
            while (rs.next()) {
                System.out.println("Test: " + rs.getInt("ACT_ID") + "While run number: " + test);
                test++;
                getMessages.add(new Message(rs.getInt("COMMENTID"), rs.getString("COMMENTS"), rs.getInt("CAMPNO"), rs.getString("COMMENTDATE"), rs.getInt("ACT_ID"), rs.getString("USERNAME"))); // Tilføjer Message objekter til Arraylisten
            }
            prep.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        } catch (SQLException ex) {
            throw new DatabaseErrorException("Error in Database");
        }
        
        Collections.sort(getMessages);
        
        return getMessages;                                                     // Returnerer Arraylisten med alle Message objekterne igennem metoden
    }
}
