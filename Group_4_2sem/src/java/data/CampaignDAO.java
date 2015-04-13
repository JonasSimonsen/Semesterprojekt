package data;

import model.Campaign;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Campaign2;

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
            prep.close();                                                       // Lukker forbindelsen til databasen
            connection.close();
        }

    }
        public void submitNewCampaignV2(Campaign2 camp) throws SQLException, ClassNotFoundException {
        PreparedStatement prep = null;
        Connection connection = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "INSERT INTO CAMPAIGN (CAMPNO,SUBMITDATE,CONTACTNAME,COMPNAME,COMPADDR,CONTACTEMAIL,CONTACTPHONE,PROGRAMDATE,STARTTIME,ENDTIME,ATTENDNUM,VENUE,VENUEADDR,FTOF,TRADESHOW,MULTIT,DOOROPEN,THIRDPART,DIRECTMAIL,BLITZ,PROGDESC,SC4000,PS4210,STORAGESOL,FLASH,FLUIDCAC,DATAPROT,NEWGEN,WIN2003,X86SERV,VRTX,SDN,USERCENT,CLOUD,CONVERG,BLADEDATA,FUTUREIT,POWEREDGE,SDS,CAMPAIGNCOM,SMB,LE,PUB,COST,MDFREQ,REIMB,PARTNERS,MDFCONTR,OPPORTU,ESTREVENUE,STATUS) VALUES (plan_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            prep = connection.prepareStatement(query);                           // Opretter forbindelse til til databasen for statement
            prep.setString(1, camp.getSubmit_date());
            prep.setString(2, camp.getContact_name());
            prep.setString(3, camp.getCompany_name());
            prep.setString(4, camp.getCompany_address());
            prep.setString(5, camp.getContact_email());
            prep.setString(6, camp.getContact_phone());
            prep.setString(7, camp.getProgram_date());
            prep.setString(8, camp.getStart_time());
            prep.setString(9, camp.getEnd_time());
            prep.setInt(10, camp.getAttendum());
            prep.setString(11, camp.getVenue_name());
            prep.setString(12, camp.getVenue_address());
            prep.setInt(13, camp.getFace_to_face());
            prep.setInt(14, camp.getTradeshow());
            prep.setInt(15, camp.getMultitouch());
            prep.setInt(16, camp.getDoor_opener());
            prep.setInt(17, camp.getThird_party());
            prep.setInt(18, camp.getDirect_mail());
            prep.setInt(19, camp.getBlitz());
            prep.setString(20, camp.getProgram_desc());
            prep.setInt(21, camp.getStorage_sc4000());
            prep.setInt(22, camp.getStorage_ps4210());
            prep.setInt(23, camp.getStorage_solutions());
            prep.setInt(24, camp.getStorage_flash());
            prep.setInt(25, camp.getStorage_fluidcache());
            prep.setInt(26, camp.getStorage_data_protection());
            prep.setInt(27, camp.getServer_newgen());
            prep.setInt(28, camp.getServer_win2003());
            prep.setInt(29, camp.getServer_x86());
            prep.setInt(30, camp.getServer_vrtx());
            prep.setInt(31, camp.getNetworking_sdn());
            prep.setInt(32, camp.getNetworking_user_centric());
            prep.setInt(33, camp.getSolutions_cloud());
            prep.setInt(34, camp.getSolutions_converged());
            prep.setInt(35, camp.getSolutions_blade());
            prep.setInt(36, camp.getSolutions_futureready());
            prep.setInt(37, camp.getSolutions_poweredge());
            prep.setInt(38, camp.getSolutions_sds());
            prep.setString(39, camp.getCampaign_component());
            prep.setInt(40, camp.getTarget_smb());
            prep.setInt(41, camp.getTarget_le());
            prep.setInt(42, camp.getTarget_pub());
            prep.setDouble(43, camp.getCost());
            prep.setDouble(44, camp.getMdf_req());
            prep.setString(45, camp.getReimbursement());
            prep.setString(46, camp.getPartners());
            prep.setDouble(47, camp.getMdf_contr());
            prep.setInt(48, camp.getOpportunities());
            prep.setDouble(49, camp.getEst_renevue());
            prep.setString(50, "PENDING");
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

    public static ArrayList<Campaign2> getCampaigns() throws SQLException, ClassNotFoundException {
        ArrayList<Campaign2> getCamp = new ArrayList();
        ResultSet rs = null;
        PreparedStatement prep = null;
        Connection connection = null;

        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "SELECT * FROM CAMPAIGN";                         // Finder alle informationer
            prep = connection.prepareStatement(query);                          // Opretter forbindelse til til databasen for statement
            rs = prep.executeQuery();
            while (rs.next()) {
                getCamp.add(new Campaign2(rs.getInt("CAMPNO"),rs.getString("SUBMITDATE"),rs.getString("CONTACTNAME"),rs.getString("COMPNAME"),rs.getString("COMPADDR"),rs.getString("CONTACTEMAIL"),rs.getString("CONTACTPHONE"),rs.getString("PROGRAMDATE"),rs.getString("STARTTIME"),rs.getString("ENDTIME"),rs.getInt("ATTENDNUM"),rs.getString("VENUE"),rs.getString("VENUEADDR"),rs.getInt("FTOF"),rs.getInt("TRADESHOW"),rs.getInt("MULTIT"),rs.getInt("DOOROPEN"),rs.getInt("THIRDPART"),rs.getInt("DIRECTMAIL"),rs.getInt("BLITZ"),rs.getString("PROGDESC"),rs.getInt("SC4000"),rs.getInt("PS4210"),rs.getInt("STORAGESOL"),rs.getInt("FLASH"),rs.getInt("FLUIDCAC"),rs.getInt("DATAPROT"),rs.getInt("NEWGEN"),rs.getInt("WIN2003"),rs.getInt("X86SERV"),rs.getInt("VRTX"),rs.getInt("SDN"),rs.getInt("USERCENT"),rs.getInt("CLOUD"),rs.getInt("CONVERG"),rs.getInt("BLADEDATA"),rs.getInt("FUTUREIT"),rs.getInt("POWEREDGE"),rs.getInt("SDS"),rs.getString("CAMPAIGNCOM"),rs.getInt("SMB"),rs.getInt("LE"),rs.getInt("PUB"),rs.getDouble("COST"),rs.getDouble("MDFREQ"),rs.getString("REIMB"),rs.getString("PARTNERS"),rs.getDouble("MDFCONTR"),rs.getInt("OPPORTU"),rs.getDouble("ESTREVENUE"),rs.getString("STATUS")));
            }
        } finally {
            prep.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        }
        return getCamp;
    }

    public static Campaign2 getSpecificCampaign(int campno) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        PreparedStatement prep = null;
        Connection connection = null;
        Campaign2 campaign = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "SELECT * FROM CAMPAIGN WHERE CAMPNO = ?";        // Finder alle informationer i den column hvor PLANNO matcher int'en som er passeret ind i metoden
            prep = connection.prepareStatement(query);                          // Opretter forbindelse til til databasen for statement
            prep.setInt(1, campno);
            rs = prep.executeQuery();
            while (rs.next()) {
                campaign = new Campaign2(rs.getInt("CAMPNO"),rs.getString("SUBMITDATE"),rs.getString("CONTACTNAME"),rs.getString("COMPNAME"),rs.getString("COMPADDR"),rs.getString("CONTACTEMAIL"),rs.getString("CONTACTPHONE"),rs.getString("PROGRAMDATE"),rs.getString("STARTTIME"),rs.getString("ENDTIME"),rs.getInt("ATTENDNUM"),rs.getString("VENUE"),rs.getString("VENUEADDR"),rs.getInt("FTOF"),rs.getInt("TRADESHOW"),rs.getInt("MULTIT"),rs.getInt("DOOROPEN"),rs.getInt("THIRDPART"),rs.getInt("DIRECTMAIL"),rs.getInt("BLITZ"),rs.getString("PROGDESC"),rs.getInt("SC4000"),rs.getInt("PS4210"),rs.getInt("STORAGESOL"),rs.getInt("FLASH"),rs.getInt("FLUIDCAC"),rs.getInt("DATAPROT"),rs.getInt("NEWGEN"),rs.getInt("WIN2003"),rs.getInt("X86SERV"),rs.getInt("VRTX"),rs.getInt("SDN"),rs.getInt("USERCENT"),rs.getInt("CLOUD"),rs.getInt("CONVERG"),rs.getInt("BLADEDATA"),rs.getInt("FUTUREIT"),rs.getInt("POWEREDGE"),rs.getInt("SDS"),rs.getString("CAMPAIGNCOM"),rs.getInt("SMB"),rs.getInt("LE"),rs.getInt("PUB"),rs.getDouble("COST"),rs.getDouble("MDFREQ"),rs.getString("REIMB"),rs.getString("PARTNERS"),rs.getDouble("MDFCONTR"),rs.getInt("OPPORTU"),rs.getDouble("ESTREVENUE"),rs.getString("STATUS"));
            }
        } finally {
            prep.close();                                                       // Lukker forbindelsen til databasen
            connection.close();
        }
        return campaign;
    }
}
