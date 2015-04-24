import data.UserDAO;
import data.CampaignDAO;
import static data.CampaignDAO.getSpecificCampaignV2;
import static data.UserDAO.getUserInfo;
import java.sql.SQLException;
import DTO.Campaign2;
import DTO.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatabaseInputTests {

    public DatabaseInputTests() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testUserEntry() throws SQLException, ClassNotFoundException{
        UserDAO dm = new UserDAO();
        User user = new User(666,"SATAN"," "," "," "," ",40404040," ",1);
        dm.createNewUser(user);
        User getUser = getUserInfo("SATAN");
        assertEquals(40404040, getUser.getPhoneNum());
        dm.deleteUser("SATAN");
    }
    
    @Test
    public void testCampaignEntry() throws SQLException, ClassNotFoundException{
        CampaignDAO cm = new CampaignDAO();
        Campaign2 camp = new Campaign2(1,"","SATAN","HELL LLC","","","","","","",5,"","",0,0,0,0,0,0,0,"",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"",0,0,0,0.0,0.0,"","",0.0,0,0.0,"",0,0);
        int id = 0;
        cm.submitNewCampaignV2(camp,id);
        camp = getSpecificCampaignV2("SATAN");
        assertEquals("HELL LLC", camp.getCompany_name());
        cm.deleteCampaign("SATAN");
    }

    @Test
    public void testPOEStatus() throws SQLException, ClassNotFoundException{
        CampaignDAO cm = new CampaignDAO();
        Campaign2 camp = new Campaign2(666,"","SATAN","HELL LLC","","","","","","",5,"","",0,0,0,0,0,0,0,"",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"",0,0,0,0.0,0.0,"","",0.0,0,0.0,"",0,0);
        int id = 0;
        cm.submitNewCampaignV2(camp,id);
        System.out.println("Before: " +camp.getHas_poe());
        cm.updatePOEStatus(1, 666);
        camp = getSpecificCampaignV2("SATAN");
        System.out.println("After: " +camp.getHas_poe());
        assertEquals(1,camp.getHas_poe());
        cm.updatePOEStatus(0, 666);
        camp = getSpecificCampaignV2("SATAN");
        assertEquals(0,camp.getHas_poe());
        cm.deleteCampaign("SATAN");
    }
    
}
