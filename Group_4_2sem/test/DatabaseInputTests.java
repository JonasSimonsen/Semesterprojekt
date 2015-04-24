import data.UserDAO;
import data.CampaignDAO;
import static data.CampaignDAO.getSpecificCampaignV2;
import static data.UserDAO.getUserInfo;
import java.sql.SQLException;
import DTO.Campaign2;
import DTO.User;
import exceptions.DatabaseErrorException;
import facade.facadeCtrl;
import interfaces.Interface_CtrlFacade;
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
    public void testUserEntry() throws DatabaseErrorException, ClassNotFoundException{
        Interface_CtrlFacade ctrl = new facadeCtrl();
        User user = new User(666,"SATAN"," "," "," "," ",40404040," ",1);
        ctrl.createNewUser(user);
        User getUser = getUserInfo("SATAN");
        assertEquals(40404040, getUser.getPhoneNum());
        ctrl.deleteUser("SATAN");
    }
    
    @Test
    public void testCampaignEntry() throws DatabaseErrorException, ClassNotFoundException{
        Interface_CtrlFacade ctrl = new facadeCtrl();
        Campaign2 camp = new Campaign2(1,"","SATAN","HELL LLC","","","","","","",5,"","",0,0,0,0,0,0,0,"",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"",0,0,0,0.0,0.0,"","",0.0,0,0.0,"",0,0);
        int id = 0;
        ctrl.submitNewCampaignV2(camp,id);
        camp = getSpecificCampaignV2("SATAN");
        assertEquals("HELL LLC", camp.getCompany_name());
        ctrl.deleteCampaign("SATAN");
    }

    @Test
    public void testPOEStatus() throws ClassNotFoundException, DatabaseErrorException{
        Interface_CtrlFacade ctrl = new facadeCtrl();
        Campaign2 camp = new Campaign2(666,"","SATAN","HELL LLC","","","","","","",5,"","",0,0,0,0,0,0,0,"",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"",0,0,0,0.0,0.0,"","",0.0,0,0.0,"",0,0);
        int id = 0;
        ctrl.submitNewCampaignV2(camp,id);
        System.out.println("Before: " +camp.getHas_poe());
        ctrl.updatePOEStatus(1, 666);
        camp = getSpecificCampaignV2("SATAN");
        System.out.println("After: " +camp.getHas_poe());
        assertEquals(1,camp.getHas_poe());
        ctrl.updatePOEStatus(0, 666);
        camp = getSpecificCampaignV2("SATAN");
        assertEquals(0,camp.getHas_poe());
        ctrl.deleteCampaign("SATAN");
    }
    
}
