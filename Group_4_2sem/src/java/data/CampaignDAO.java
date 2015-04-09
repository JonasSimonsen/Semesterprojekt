package data;

import entity.Campaign;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CampaignDAO {
    public void submitNewCampaign(Campaign camp) throws SQLException, ClassNotFoundException{
        ResultSet rs = null;
        Statement statement = null;
        Connection connection = null;
        int PNO, MDFBUDGET;
        double COST;
        String COUNTRY, DESCRIPTION, AUDIENCE, CURRENCY, STATUS, QUARTER, STARTDATE, ENDDATE, OBJECTIVE, POE_REQ;
        PNO = 5;
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
        POE_REQ = null;
        
        try{
            Class.forName(DatabaseInfo.driver);
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);
            statement = connection.createStatement();
            String query = "INSERT INTO PARTNERPLAN (PLANNO,PNO,COUNTRY,DESCRIPTION,AUDIENCE,CURRENCY,COST,MDFBUDGET,STATUS,QUARTER,STARTDATE,ENDDATE,OBJECTIVE,POE_REQ) VALUES (user_seq.nextval," + PNO + ",'" + COUNTRY + "','" + DESCRIPTION + "','" + AUDIENCE + "','" + CURRENCY + "'," + COST + "," + MDFBUDGET + ",'" + STATUS + "','" + QUARTER + "','" + STARTDATE + "','" + ENDDATE + "','" + OBJECTIVE + "','" + POE_REQ + "')";
            statement.executeQuery(query);
        } finally {
            statement.close();
            connection.close();
        }
        
    }
    public void deleteCampaign(Campaign camp) throws SQLException, ClassNotFoundException{
        ResultSet rs = null;
        Statement statement = null;
        Connection connection = null;
        int PLANNO = camp.getPlanNumber();
        
        try{
            Class.forName(DatabaseInfo.driver);
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);
            statement = connection.createStatement();
            String query = "DELETE FROM PARTNERPLAN WHERE PLANNO =" + PLANNO;
            statement.executeQuery(query);
        } finally {
            statement.close();
            connection.close();
        }
    }
    
    public void editCampaign(Campaign camp) throws SQLException, ClassNotFoundException{
        ResultSet rs = null;
        Statement statement = null;
        Connection connection = null;
        int PLANNO, PNO, MDFBUDGET;
        double COST;
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
        POE_REQ = camp.getPoeRequirement();
        
        try{
            Class.forName(DatabaseInfo.driver);
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);
            statement = connection.createStatement();
            String query = "UPDATE PARTNERPLAN SET PNO = " + PNO + ", COUNTRY = '" + COUNTRY + "', DESCRIPTION = '" + DESCRIPTION + "', AUDIENCE = '" + AUDIENCE + "', CURRENCY = '" + CURRENCY + "', COST = " + COST + ", MDFBUDGET = " + MDFBUDGET + ", STATUS = '" + STATUS + "', QUARTER = '" + QUARTER + "', STARTDATE = '" + STARTDATE + "', ENDDATE = '" + ENDDATE + "', OBJECTIVE = '" + OBJECTIVE + "', POE_REQ = '" + POE_REQ + "' WHERE PLANNO = " + PLANNO + ";";
            statement.executeQuery(query);
        } finally {
            statement.close();
            connection.close();
        }
    }
    
    public static ArrayList<Campaign> getCampaign() throws SQLException, ClassNotFoundException{
        ArrayList<Campaign> getCamp = new ArrayList();
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
                getCamp.add(new Campaign(rs.getInt("PLANNO"), rs.getInt("PNO"), rs.getString("COUNTRY"), rs.getString("DESCRIPTION"), rs.getString("AUDIENCE"), rs.getString("CURRENCY"), rs.getInt("COST"), rs.getInt("MDFBUDGET"), rs.getString("STATUS"), rs.getString("QUARTER"), rs.getString("STARTDATE"), rs.getString("ENDDATE"), rs.getString("OBJECTIVE"), rs.getString("POE_REQ")));
            }
        } finally {
            statement.close();
            connection.close();
        }
        return getCamp;
    }
}
