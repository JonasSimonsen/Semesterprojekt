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
        
    }
    public void deleteCampaign(Campaign camp) throws SQLException, ClassNotFoundException{
        ResultSet rs = null;
        Statement statement = null;
        Connection connection = null;
    }
    
    public void editCampaign(Campaign camp) throws SQLException, ClassNotFoundException{
        ResultSet rs = null;
        Statement statement = null;
        Connection connection = null;
    }
    
    public static ArrayList<Campaign> getCampaign() throws SQLException, ClassNotFoundException{
        ResultSet rs = null;
        Statement statement = null;
        Connection connection = null;
        
        return null;
    }
}
