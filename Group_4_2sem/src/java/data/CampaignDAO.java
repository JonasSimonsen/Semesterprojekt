package data;

import model.Campaign;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CampaignDAO {
    public void submitNewCampaign(Campaign camp) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        Connection connection = null;
        int PNO = 0;
        double COST, MDFBUDGET;
        String COUNTRY, DESCRIPTION, AUDIENCE, CURRENCY, STATUS, QUARTER, STARTDATE, ENDDATE, OBJECTIVE, POE_REQ;
        COST = camp.getCost();
        MDFBUDGET = 0;
        COUNTRY = camp.getCountry();
        DESCRIPTION = camp.getDescription();
        AUDIENCE = camp.getAudience();
        CURRENCY = camp.getCurrency();
        STATUS = "PENDING";
        QUARTER = camp.getQuarter();
        STARTDATE = camp.getStartDate();
        ENDDATE = camp.getEndDate();
        OBJECTIVE = camp.getObjective();
        POE_REQ = null;                                                         // Variabler som henter values fra Campaign objektet passeret igennem servletten.
        
        try{
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            statement = connection.createStatement();                           // Opretter forbindelse til til databasen for statement
            String query = "INSERT INTO PARTNERPLAN (PLANNO,PNO,COUNTRY,DESCRIPTION,AUDIENCE,CURRENCY,COST,MDFBUDGET,STATUS,QUARTER,STARTDATE,ENDDATE,OBJECTIVE,POE_REQ) VALUES (plan_seq.nextval," + PNO + ",'" + COUNTRY + "','" + DESCRIPTION + "','" + AUDIENCE + "','" + CURRENCY + "'," + COST + "," + MDFBUDGET + ",'" + STATUS + "','" + QUARTER + "','" + STARTDATE + "','" + ENDDATE + "','" + OBJECTIVE + "','" + POE_REQ + "')";
            // Tilføjer en ny column til PARTNERPLAN med alle campaign informationerne
            statement.executeQuery(query);
        } finally {
            statement.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        }
        
    }
    public void deleteCampaign(Campaign camp) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        Connection connection = null;
        int PLANNO = camp.getPlanNumber();                                      // Variable som henter value fra Campaign objektet passeret igennem servletten.
        
        try{
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            statement = connection.createStatement();                           // Opretter forbindelse til til databasen for statement
            String query = "DELETE FROM PARTNERPLAN WHERE PLANNO =" + PLANNO;   // Sletter column hvor PLANNO passer til den indtastede PLANNO
            statement.executeQuery(query);
        } finally {
            statement.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        }
    }
    
    public void editCampaign(Campaign camp) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        Connection connection = null;
        int PLANNO, PNO;
        double COST, MDFBUDGET;
        String COUNTRY, DESCRIPTION, AUDIENCE, CURRENCY, STATUS, QUARTER, STARTDATE, ENDDATE, OBJECTIVE, POE_REQ;
        PLANNO = camp.getPlanNumber();
        PNO = camp.getPartnerNumber();
        COST = camp.getCost();
        MDFBUDGET = camp.getMdfBudget();
        COUNTRY = camp.getCountry();
        DESCRIPTION = camp.getDescription();
        AUDIENCE = camp.getAudience();
        CURRENCY = camp.getCurrency();
        STATUS = camp.getStatus();
        QUARTER = camp.getQuarter();
        STARTDATE = camp.getStartDate();
        ENDDATE = camp.getEndDate();
        OBJECTIVE = camp.getObjective();
        POE_REQ = camp.getPoeRequirement();                                     // Variabler som henter values fra Campaign objektet passeret igennem servletten.
        
        try{
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            statement = connection.createStatement();                           // Opretter forbindelse til til databasen for statement
            String query = "UPDATE PARTNERPLAN SET PNO = " + PNO + ", COUNTRY = '" + COUNTRY + "', DESCRIPTION = '" + DESCRIPTION + "', AUDIENCE = '" + AUDIENCE + "', CURRENCY = '" + CURRENCY + "', COST = " + COST + ", MDFBUDGET = " + MDFBUDGET + ", STATUS = '" + STATUS + "', QUARTER = '" + QUARTER + "', STARTDATE = '" + STARTDATE + "', ENDDATE = '" + ENDDATE + "', OBJECTIVE = '" + OBJECTIVE + "', POE_REQ = '" + POE_REQ + "' WHERE PLANNO = " + PLANNO + ";";
            // Opdaterer column i PARTNERPLAN som passer til PNO som er passeret ind
            statement.executeQuery(query);
        } finally {
            statement.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        }
    }
    
    public void submitBudget(Campaign camp) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        Connection connection = null;
        int PLANNO = camp.getPlanNumber();
        double MDFBUDGET = camp.getMdfBudget();
        
        try{
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            statement = connection.createStatement();                           // Opretter forbindelse til til databasen for statement
            String query = "UPDATE PARTNERPLAN SET MDFBUDGET = " + MDFBUDGET + " WHERE PLANNO = " + PLANNO; // Opdaterer MDF Budget 
            statement.executeQuery(query);
        } finally {
            statement.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        }
    }
    
    public static ArrayList<Campaign> getCampaigns() throws SQLException, ClassNotFoundException{
        ArrayList<Campaign> getCamp = new ArrayList();
        ResultSet rs = null;
        Statement statement = null;
        Connection connection = null;

        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            statement = connection.createStatement();                           // Opretter forbindelse til til databasen for statement
            String query = "SELECT * FROM PARTNERPLAN";                         // Finder alle informationer
            rs = statement.executeQuery(query);
            while (rs.next()) {
                getCamp.add(new Campaign(rs.getInt("PLANNO"), rs.getInt("PNO"), rs.getString("COUNTRY"), rs.getString("DESCRIPTION"), rs.getString("AUDIENCE"), rs.getString("CURRENCY"), rs.getInt("COST"), rs.getInt("MDFBUDGET"), rs.getString("STATUS"), rs.getString("QUARTER"), rs.getString("STARTDATE"), rs.getString("ENDDATE"), rs.getString("OBJECTIVE"), rs.getString("POE_REQ")));
            }
        } finally {
            statement.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        }
        return getCamp;
    }
    
    public static Campaign getSpecificCampaign(int planno) throws SQLException, ClassNotFoundException{
        ResultSet rs = null;
        Statement statement = null;
        Connection connection = null;
        Campaign campaign;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            statement = connection.createStatement();                           // Opretter forbindelse til til databasen for statement
            String query = "SELECT * FROM PARTNERPLAN WHERE PLANNO = " + planno;// Finder alle informationer i den column hvor PLANNO matcher int'en som er passeret ind i metoden
            rs = statement.executeQuery(query);
            campaign = new Campaign(rs.getInt("PLANNO"), rs.getInt("PNO"), rs.getString("COUNTRY"), rs.getString("DESCRIPTION"), rs.getString("AUDIENCE"), rs.getString("CURRENCY"), rs.getInt("COST"), rs.getInt("MDFBUDGET"), rs.getString("STATUS"), rs.getString("QUARTER"), rs.getString("STARTDATE"), rs.getString("ENDDATE"), rs.getString("OBJECTIVE"), rs.getString("POE_REQ"));
        } finally {
            statement.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        }
        
        return campaign;
    }
}
