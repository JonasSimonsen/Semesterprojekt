package data;

import entity.Partner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PartnerDAO {
    public void createNewPartner(Partner partner) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        Connection connection = null;
        int pno = partner.getPNO();
        String partnerName = partner.getPartnerName();
        try {
            Class.forName(DatabaseInfo.driver);
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW);
            statement = connection.createStatement();
            String query = "INSERT INTO PARTNERS (PNO,PARTNER) VALUES (user_seq.nextval,'" + partnerName + "')";
            statement.executeQuery(query);
        } finally {
            statement.close();
            connection.close();
        }
    }
    public static ArrayList<Partner> getPartner() throws SQLException, ClassNotFoundException{
        ArrayList<Partner> getPartner = new ArrayList();
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
                getPartner.add(new Partner(rs.getInt("PNO"),rs.getString("PARTNER")));
            }
        } finally {
            
        }
        
        return getPartner;
    }
}
