package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import DTO.Campaign;
import exceptions.DatabaseErrorException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import view.campaign_LoadPOE;
import view.campaign_SavePOE;

public class CampaignDAO {

    private ArrayList<Campaign> getCamp = new ArrayList();

    public void submitNewCampaignV2(Campaign camp, int userID) throws DatabaseErrorException, ClassNotFoundException {
        PreparedStatement prep = null;
        Connection connection = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "INSERT INTO CAMPAIGN (CAMPNO,SUBMITDATE,CONTACTNAME,COMPNAME,COMPADDR,CONTACTEMAIL,CONTACTPHONE,PROGRAMDATE,STARTTIME,ENDTIME,ATTENDNUM,VENUE,VENUEADDR,FTOF,TRADESHOW,MULTIT,DOOROPEN,THIRDPART,DIRECTMAIL,BLITZ,PROGDESC,SC4000,PS4210,STORAGESOL,FLASH,FLUIDCAC,DATAPROT,NEWGEN,WIN2003,X86SERV,VRTX,SDN,USERCENT,CLOUD,CONVERG,BLADEDATA,FUTUREIT,POWEREDGE,SDS,CAMPAIGNCOM,SMB,LE,PUB,COST,MDFREQ,REIMB,PARTNERS,MDFCONTR,OPPORTU,ESTREVENUE,STATUS,HASPOE,USER_ID) VALUES (camp_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,(SELECT ID FROM USERS WHERE ID=?))";
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
            prep.setInt(51, camp.getHas_poe());
            prep.setInt(52, userID);
            prep.executeQuery();
            prep.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        } catch (SQLException ex) {
            throw new DatabaseErrorException("Error in Database");
        }

    }

    public void deleteCampaign(int ID) throws DatabaseErrorException, ClassNotFoundException {
        PreparedStatement prep = null;
        Connection connection = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "DELETE FROM CAMPAIGN WHERE USER_ID = (SELECT USER_ID FROM USERS WHERE USER_ID=?)";          // Sletter column hvor PLANNO passer til den indtastede PLANNO
            prep = connection.prepareStatement(query);                          // Opretter forbindelse til til databasen for statement
            prep.setInt(1, ID);
            prep.executeQuery();
            prep.close();                                                       // Lukker forbindelsen til databasen
            connection.close();
        } catch (SQLException ex) {
            throw new DatabaseErrorException("Error in Database");
        }
    }

    public void approveBudget(int campno, double budget) throws DatabaseErrorException, ClassNotFoundException {
        PreparedStatement prep = null;
        Connection connection = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "UPDATE CAMPAIGN SET MDFBUDGET = ? WHERE CAMPNO = ?"; // Opdaterer MDF Budget 
            prep = connection.prepareStatement(query);                          // Opretter forbindelse til til databasen for statement
            prep.setDouble(1, budget);
            prep.setInt(2, campno);
            prep.executeQuery();

            prep.close();                                                       // Lukker forbindelsen til databasen
            connection.close();
        } catch (SQLException ex) {
            throw new DatabaseErrorException("Error in Database");
        }
    }

    public void budgetStatus(String status, int campno) throws DatabaseErrorException, ClassNotFoundException {
        PreparedStatement prep = null;
        Connection connection = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "UPDATE CAMPAIGN SET STATUS = ? WHERE CAMPNO = ?";   // Opdaterer MDF Budget 
            prep = connection.prepareStatement(query);                          // Opretter forbindelse til til databasen for statement
            prep.setString(1, status);
            prep.setInt(2, campno);
            prep.executeQuery();

            prep.close();                                                       // Lukker forbindelsen til databasen
            connection.close();
        } catch (SQLException ex) {
            throw new DatabaseErrorException("Error in Database");
        }
    }

    public void updatePOEStatus(int poe_status, int campno) throws DatabaseErrorException, ClassNotFoundException {
        PreparedStatement prep = null;
        Connection connection = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "UPDATE CAMPAIGN SET HASPOE = ? WHERE CAMPNO = ?";   // Opdaterer MDF Budget 
            prep = connection.prepareStatement(query);                          // Opretter forbindelse til til databasen for statement
            prep.setInt(1, poe_status);
            prep.setInt(2, campno);
            System.out.println("POE Test");
            System.out.println("Campno: " + campno);
            System.out.println("POE Status: " + poe_status);
            prep.executeQuery();

            prep.close();                                                       // Lukker forbindelsen til databasen
            connection.close();
        } catch (SQLException ex) {
            throw new DatabaseErrorException("Error in Database");
        }
    }

    public ArrayList<Campaign> getCampaigns() throws DatabaseErrorException, ClassNotFoundException {
        getCamp = new ArrayList();
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
                getCamp.add(new Campaign(rs.getInt("CAMPNO"), rs.getString("SUBMITDATE"), rs.getString("CONTACTNAME"), rs.getString("COMPNAME"), rs.getString("COMPADDR"), rs.getString("CONTACTEMAIL"), rs.getString("CONTACTPHONE"), rs.getString("PROGRAMDATE"), rs.getString("STARTTIME"), rs.getString("ENDTIME"), rs.getInt("ATTENDNUM"), rs.getString("VENUE"), rs.getString("VENUEADDR"), rs.getInt("FTOF"), rs.getInt("TRADESHOW"), rs.getInt("MULTIT"), rs.getInt("DOOROPEN"), rs.getInt("THIRDPART"), rs.getInt("DIRECTMAIL"), rs.getInt("BLITZ"), rs.getString("PROGDESC"), rs.getInt("SC4000"), rs.getInt("PS4210"), rs.getInt("STORAGESOL"), rs.getInt("FLASH"), rs.getInt("FLUIDCAC"), rs.getInt("DATAPROT"), rs.getInt("NEWGEN"), rs.getInt("WIN2003"), rs.getInt("X86SERV"), rs.getInt("VRTX"), rs.getInt("SDN"), rs.getInt("USERCENT"), rs.getInt("CLOUD"), rs.getInt("CONVERG"), rs.getInt("BLADEDATA"), rs.getInt("FUTUREIT"), rs.getInt("POWEREDGE"), rs.getInt("SDS"), rs.getString("CAMPAIGNCOM"), rs.getInt("SMB"), rs.getInt("LE"), rs.getInt("PUB"), rs.getDouble("COST"), rs.getDouble("MDFREQ"), rs.getString("REIMB"), rs.getString("PARTNERS"), rs.getDouble("MDFCONTR"), rs.getInt("OPPORTU"), rs.getDouble("ESTREVENUE"), rs.getString("STATUS"), rs.getInt("HASPOE"), rs.getInt("USER_ID")));
            }

            prep.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
            rs.close();
        } catch (SQLException ex) {
            throw new DatabaseErrorException("Error in Database");
        }
        return getCamp;
    }

    public ArrayList<Campaign> getCampaignsExternal(int id) throws DatabaseErrorException, ClassNotFoundException {
        getCamp = new ArrayList();
        ResultSet rs = null;
        PreparedStatement prep = null;
        Connection connection = null;

        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "SELECT * FROM CAMPAIGN WHERE USER_ID = ?";                         // Finder alle informationer
            prep = connection.prepareStatement(query);                          // Opretter forbindelse til til databasen for statement
            prep.setInt(1, id);
            rs = prep.executeQuery();
            while (rs.next()) {
                getCamp.add(new Campaign(rs.getInt("CAMPNO"), rs.getString("SUBMITDATE"), rs.getString("CONTACTNAME"), rs.getString("COMPNAME"), rs.getString("COMPADDR"), rs.getString("CONTACTEMAIL"), rs.getString("CONTACTPHONE"), rs.getString("PROGRAMDATE"), rs.getString("STARTTIME"), rs.getString("ENDTIME"), rs.getInt("ATTENDNUM"), rs.getString("VENUE"), rs.getString("VENUEADDR"), rs.getInt("FTOF"), rs.getInt("TRADESHOW"), rs.getInt("MULTIT"), rs.getInt("DOOROPEN"), rs.getInt("THIRDPART"), rs.getInt("DIRECTMAIL"), rs.getInt("BLITZ"), rs.getString("PROGDESC"), rs.getInt("SC4000"), rs.getInt("PS4210"), rs.getInt("STORAGESOL"), rs.getInt("FLASH"), rs.getInt("FLUIDCAC"), rs.getInt("DATAPROT"), rs.getInt("NEWGEN"), rs.getInt("WIN2003"), rs.getInt("X86SERV"), rs.getInt("VRTX"), rs.getInt("SDN"), rs.getInt("USERCENT"), rs.getInt("CLOUD"), rs.getInt("CONVERG"), rs.getInt("BLADEDATA"), rs.getInt("FUTUREIT"), rs.getInt("POWEREDGE"), rs.getInt("SDS"), rs.getString("CAMPAIGNCOM"), rs.getInt("SMB"), rs.getInt("LE"), rs.getInt("PUB"), rs.getDouble("COST"), rs.getDouble("MDFREQ"), rs.getString("REIMB"), rs.getString("PARTNERS"), rs.getDouble("MDFCONTR"), rs.getInt("OPPORTU"), rs.getDouble("ESTREVENUE"), rs.getString("STATUS"), rs.getInt("HASPOE"), rs.getInt("USER_ID")));
            }

            prep.close();                                                  // Lukker forbindelsen til databasen
            connection.close();
        } catch (SQLException ex) {
            throw new DatabaseErrorException("Error in Database");
        }
        return getCamp;
    }

    public Campaign getSpecificCampaign(int campno) throws DatabaseErrorException, ClassNotFoundException {
        ResultSet rs = null;
        PreparedStatement prep = null;
        Connection connection = null;
        Campaign campaign = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "SELECT * FROM CAMPAIGN WHERE CAMPNO = ?";        // Finder alle informationer i den column hvor PLANNO matcher int'en som er passeret ind i metoden
            prep = connection.prepareStatement(query);                          // Opretter forbindelse til til databasen for statement
            prep.setInt(1, campno);
            rs = prep.executeQuery();
            while (rs.next()) {
                campaign = new Campaign(rs.getInt("CAMPNO"), rs.getString("SUBMITDATE"), rs.getString("CONTACTNAME"), rs.getString("COMPNAME"), rs.getString("COMPADDR"), rs.getString("CONTACTEMAIL"), rs.getString("CONTACTPHONE"), rs.getString("PROGRAMDATE"), rs.getString("STARTTIME"), rs.getString("ENDTIME"), rs.getInt("ATTENDNUM"), rs.getString("VENUE"), rs.getString("VENUEADDR"), rs.getInt("FTOF"), rs.getInt("TRADESHOW"), rs.getInt("MULTIT"), rs.getInt("DOOROPEN"), rs.getInt("THIRDPART"), rs.getInt("DIRECTMAIL"), rs.getInt("BLITZ"), rs.getString("PROGDESC"), rs.getInt("SC4000"), rs.getInt("PS4210"), rs.getInt("STORAGESOL"), rs.getInt("FLASH"), rs.getInt("FLUIDCAC"), rs.getInt("DATAPROT"), rs.getInt("NEWGEN"), rs.getInt("WIN2003"), rs.getInt("X86SERV"), rs.getInt("VRTX"), rs.getInt("SDN"), rs.getInt("USERCENT"), rs.getInt("CLOUD"), rs.getInt("CONVERG"), rs.getInt("BLADEDATA"), rs.getInt("FUTUREIT"), rs.getInt("POWEREDGE"), rs.getInt("SDS"), rs.getString("CAMPAIGNCOM"), rs.getInt("SMB"), rs.getInt("LE"), rs.getInt("PUB"), rs.getDouble("COST"), rs.getDouble("MDFREQ"), rs.getString("REIMB"), rs.getString("PARTNERS"), rs.getDouble("MDFCONTR"), rs.getInt("OPPORTU"), rs.getDouble("ESTREVENUE"), rs.getString("STATUS"), rs.getInt("HASPOE"), rs.getInt("USER_ID"));
            }

            prep.close();                                                       // Lukker forbindelsen til databasen
            connection.close();
        } catch (SQLException ex) {
            throw new DatabaseErrorException("Error in Database");
        }
        return campaign;
    }

    public static Campaign getSpecificCampaign(String CONTACTNAME) throws DatabaseErrorException, ClassNotFoundException {
        ResultSet rs = null;
        PreparedStatement prep = null;
        Connection connection = null;
        Campaign campaign = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
            String query = "SELECT * FROM CAMPAIGN WHERE CONTACTNAME = ?";        // Finder alle informationer i den column hvor PLANNO matcher int'en som er passeret ind i metoden
            prep = connection.prepareStatement(query);                          // Opretter forbindelse til til databasen for statement
            prep.setString(1, CONTACTNAME);
            rs = prep.executeQuery();
            while (rs.next()) {
                campaign = new Campaign(rs.getInt("CAMPNO"), rs.getString("SUBMITDATE"), rs.getString("CONTACTNAME"), rs.getString("COMPNAME"), rs.getString("COMPADDR"), rs.getString("CONTACTEMAIL"), rs.getString("CONTACTPHONE"), rs.getString("PROGRAMDATE"), rs.getString("STARTTIME"), rs.getString("ENDTIME"), rs.getInt("ATTENDNUM"), rs.getString("VENUE"), rs.getString("VENUEADDR"), rs.getInt("FTOF"), rs.getInt("TRADESHOW"), rs.getInt("MULTIT"), rs.getInt("DOOROPEN"), rs.getInt("THIRDPART"), rs.getInt("DIRECTMAIL"), rs.getInt("BLITZ"), rs.getString("PROGDESC"), rs.getInt("SC4000"), rs.getInt("PS4210"), rs.getInt("STORAGESOL"), rs.getInt("FLASH"), rs.getInt("FLUIDCAC"), rs.getInt("DATAPROT"), rs.getInt("NEWGEN"), rs.getInt("WIN2003"), rs.getInt("X86SERV"), rs.getInt("VRTX"), rs.getInt("SDN"), rs.getInt("USERCENT"), rs.getInt("CLOUD"), rs.getInt("CONVERG"), rs.getInt("BLADEDATA"), rs.getInt("FUTUREIT"), rs.getInt("POWEREDGE"), rs.getInt("SDS"), rs.getString("CAMPAIGNCOM"), rs.getInt("SMB"), rs.getInt("LE"), rs.getInt("PUB"), rs.getDouble("COST"), rs.getDouble("MDFREQ"), rs.getString("REIMB"), rs.getString("PARTNERS"), rs.getDouble("MDFCONTR"), rs.getInt("OPPORTU"), rs.getDouble("ESTREVENUE"), rs.getString("STATUS"), rs.getInt("HASPOE"), rs.getInt("USER_ID"));
            }

            prep.close();                                                       // Lukker forbindelsen til databasen
            connection.close();
        } catch (SQLException ex) {
            throw new DatabaseErrorException("Error in Database");
        }
        return campaign;
    }

    public void savePOE(InputStream input, int campno) throws DatabaseErrorException, ClassNotFoundException{
        PreparedStatement prep = null;
        Connection connection = null;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen

            String query = "INSERT INTO CAMPSTORAGE (ZIPNO, ZIPFILE, CAMPNO) values (user_seq.nextval, ?, (SELECT CAMPNO FROM CAMPAIGN WHERE CAMPNO=?))";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setBlob(1, input);
            statement.setInt(2, campno);
            statement.executeUpdate();
            
            statement.close();                                                       // Lukker forbindelsen til databasen
            connection.close();
        } catch (SQLException ex) {
            throw new DatabaseErrorException("Error in Database");
        } finally {
                try {
                    updatePOEStatus(1, campno);
                    connection.close();
                } catch (SQLException ex) {
                    throw new DatabaseErrorException("Error in Database");
                }
        }
    }
    
    public OutputStream loadPOE(int campno, ServletContext context, HttpServletResponse response) throws DatabaseErrorException, ClassNotFoundException{
        PreparedStatement prep = null;
        Connection connection = null;
        ResultSet result = null;
        OutputStream output = null;
        final int BUFFER_SIZE = 4096;
        try {
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
 
            String sql = "SELECT ZIPFILE FROM CAMPSTORAGE WHERE CAMPNO=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, campno);
            
            result = statement.executeQuery();
            if (result.next()) {
                String fileName = "POE.zip";
                Blob blob = result.getBlob("ZIPFILE");
                InputStream inputStream = blob.getBinaryStream();

                
                
                String mimeType = context.getMimeType(fileName);
                if (mimeType == null) {        
                    mimeType = "application/octet-stream";
                }      
                response.setContentType(mimeType);
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", fileName);
                response.setHeader(headerKey, headerValue);
                
                OutputStream outputStream = response.getOutputStream();
                                
                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
 
                inputStream.close();
                outputStream.close();
                System.out.println("File saved");
            }
            connection.close();
            statement.close();
        } catch (SQLException | IOException ex) {
            throw new DatabaseErrorException("Error in Database");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(campaign_LoadPOE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return output;
    }
}
