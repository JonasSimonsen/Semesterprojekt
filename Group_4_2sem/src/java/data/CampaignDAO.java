package data;

import model.Campaign;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CampaignDAO {

    public void submitNewCampaign(Campaign camp) throws SQLException, ClassNotFoundException {
        PreparedStatement prep = null;
        Connection connection = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "INSERT INTO PARTNERPLAN (PLANNO,PNO,COUNTRY,DESCRIPTION,AUDIENCE,CURRENCY,COST,MDFBUDGET,STATUS,QUARTER,STARTDATE,ENDDATE,OBJECTIVE,POE_REQ) VALUES (plan_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // SQL query til databasen som indsætter en ny column med de indtastede informationer. user_seq.nextval aktiverer en sequence i databasen som fungerer some Auto_Increment.
            prep = connection.prepareStatement(query);                           // Opretter forbindelse til til databasen for statement
            prep.setInt(1, 1);    // Temp løsning, skal have udarbejdet hvordan vi tilknyttet PNO til et givent projekt da PNO er foreign key til PARTNERS table.
            prep.setString(2, camp.getCountry());
            prep.setString(3, camp.getDescription());
            prep.setString(4, camp.getAudience());
            prep.setString(5, camp.getCurrency());
            prep.setDouble(6, camp.getCost());
            prep.setDouble(7, camp.getMdfBudget());                             // Sætter ?-tegnene i queryen til de givne variabler fra Campaign objektet.
            prep.setString(8, "PENDING");
            prep.setString(9, camp.getQuarter());
            prep.setString(10, camp.getStartDate());
            prep.setString(11, camp.getEndDate());
            prep.setString(12, camp.getObjective());
            prep.setString(13, camp.getPoeRequirement());
            prep.executeQuery();
        } finally {
            prep.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        }

    }
        public void submitNewCampaignV2(Campaign camp) throws SQLException, ClassNotFoundException {
        PreparedStatement prep = null;
        Connection connection = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "INSERT INTO CAMPAIGN (CAMPNO,SUBMITDATE,CONTACTNAME,COMPNAME,COMPADDR,CONTACTEMAIL,CONTACTPHONE,PROGRAMDATE,STARTTIME,ENDTIME,ATTENDNUM,VENUE,VENUEADDR,FTOF,TRADESHOW,MULTIT,DOOROPEN,THIRDPARTY,DIRECTMAIL,BLITZ,PROGDESC,SC4000,PS4210,STORAGESOL,FLASH,FLUIDCAC,DATAPROT,NEWGEN,WIN2003,X86SERV,VRTX,SDN,USERCENT,CLOUD,CONVERG,BLADEDATA,FUTUREIT,POWEREDGE,SDS,CAMPAIGNCOM,SMB,LE,PUB,COST,MDFREQ,REIMB,PARTNERS,MDFCONTR,OPPORTU,ESTREVENUE,STATUS) VALUES (plan_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            prep.executeQuery();
        } finally {
            prep.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        }

    }
    public void deleteCampaign(Campaign camp) throws SQLException, ClassNotFoundException {
        PreparedStatement prep = null;
        Connection connection = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "DELETE FROM PARTNERPLAN WHERE PLANNO = ?";          // Sletter column hvor PLANNO passer til den indtastede PLANNO
            prep = connection.prepareStatement(query);                          // Opretter forbindelse til til databasen for statement
            prep.setInt(1, camp.getPlanNumber());
            prep.executeQuery();
        } finally {
            prep.close();                                                       // Lukker forbindelsen til databasen
            connection.close();
        }
    }

    public void editCampaign(Campaign camp) throws SQLException, ClassNotFoundException {
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

        try {
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

    public void submitBudget(Campaign camp, double budget) throws SQLException, ClassNotFoundException {
        PreparedStatement prep = null;
        Connection connection = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "UPDATE PARTNERPLAN SET MDFBUDGET = ? WHERE PLANNO = ?"; // Opdaterer MDF Budget 
            prep.setDouble(1, budget);
            prep.setInt(2, camp.getPlanNumber());
            prep = connection.prepareStatement(query);                          // Opretter forbindelse til til databasen for statement
            prep.executeQuery();
        } finally {
            prep.close();                                                       // Lukker forbindelsen til databasen
            connection.close();
        }
    }

    public static ArrayList<Campaign> getCampaigns() throws SQLException, ClassNotFoundException {
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

    public static Campaign getSpecificCampaign(int planno) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        Statement statement = null;
        Connection connection = null;
        Campaign campaign = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            statement = connection.createStatement();                           // Opretter forbindelse til til databasen for statement
            String query = "SELECT * FROM PARTNERPLAN WHERE PLANNO = " + planno;// Finder alle informationer i den column hvor PLANNO matcher int'en som er passeret ind i metoden
            rs = statement.executeQuery(query);
            while (rs.next()) {
                campaign = new Campaign(rs.getInt("PLANNO"), rs.getInt("PNO"), rs.getString("COUNTRY"), rs.getString("DESCRIPTION"), rs.getString("AUDIENCE"), rs.getString("CURRENCY"), rs.getInt("COST"), rs.getInt("MDFBUDGET"), rs.getString("STATUS"), rs.getString("QUARTER"), rs.getString("STARTDATE"), rs.getString("ENDDATE"), rs.getString("OBJECTIVE"), rs.getString("POE_REQ"));
            }
        } finally {
            statement.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        }
        return campaign;
    }
}
