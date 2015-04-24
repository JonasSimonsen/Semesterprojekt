package data;

import DTO.Partner;
import exceptions.DatabaseErrorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PartnerDAO {
        private ArrayList<Partner> getPartner = new ArrayList();                        // Opretter Arraylist til at indeholde Partner objekter
    public void createNewPartner(Partner partner) throws DatabaseErrorException, ClassNotFoundException{
        Statement statement = null;
        Connection connection = null;
        int pno = partner.getPNO();
        String partnerName = partner.getPartnerName();                          // Variabler som henter values fra Partner objektet passeret igennem servletten.
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            statement = connection.createStatement();                           // Opretter forbindelse til til databasen for statement
            String query = "INSERT INTO PARTNERS (PNO,PARTNER) VALUES (user_seq.nextval,'" + partnerName + "')"; // Tilføjer en ny column til PARTNERS table
            statement.executeQuery(query);
            statement.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        } catch (SQLException ex) {
            throw new DatabaseErrorException("Error in Database");
        }
    }
    public ArrayList<Partner> getPartner() throws DatabaseErrorException, ClassNotFoundException{
        getPartner = new ArrayList();                        // Opretter Arraylist til at indeholde Partner objekter
        ResultSet rs = null;
        Statement statement = null;
        Connection connection = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren. 
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);  // Opretter forbindelse til databasen med info fra DB klassen
            statement = connection.createStatement();                           // Opretter forbindelse til til databasen for statement
            String query = "SELECT * FROM PARTNERS";                            // Vælger alle informationer i PARTNERS table
            rs = statement.executeQuery(query);
            while (rs.next()) {
                getPartner.add(new Partner(rs.getInt("PNO"),rs.getString("PARTNER"))); // Tilføjer Partner objekter til Arraylisten 
            }
            
            statement.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
            rs.close();
        } catch (SQLException ex) {
            throw new DatabaseErrorException("Error in Database");
        }
        
        return getPartner;                                                      // Returnerer Arraylisten med alle Activity objekterne igennem metoden
    }
}
