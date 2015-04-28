
import static data.CampaignDAO.getSpecificCampaignV2;
import static data.UserDAO.getUserInfo;
import DTO.Campaign2;
import DTO.Message;
import DTO.User;
import exceptions.DatabaseErrorException;
import facade.facadeCtrl;
import interfaces.Interface_CtrlFacade;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatabaseInputTests {

    Interface_CtrlFacade ctrl = new facadeCtrl();

    public DatabaseInputTests() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testUserEntry() throws DatabaseErrorException, ClassNotFoundException {
        ctrl = new facadeCtrl();
        User user = new User(666, "SATAN", " ", " ", " ", " ", 40404040, " ", 1);
        ctrl.createNewUser(user);
        User getUser = getUserInfo("SATAN");
        assertEquals(40404040, getUser.getPhoneNum());
        int userID = ctrl.getUserID("SATAN");
        ctrl.deleteUser(userID);
    }

    @Test
    public void testCampaignEntry() throws DatabaseErrorException, ClassNotFoundException {
        ctrl = new facadeCtrl();
        Campaign2 camp = new Campaign2(1, "", "SATAN", "HELL LLC", "", "", "", "", "", "", 5, "", "", 0, 0, 0, 0, 0, 0, 0, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0, 0, 0, 0.0, 0.0, "", "", 0.0, 0, 0.0, "", 0, 666);
        int id = 0;
        ctrl.submitNewCampaignV2(camp, id);
        camp = getSpecificCampaignV2("SATAN");
        assertEquals("HELL LLC", camp.getCompany_name());
        int userID = ctrl.getUserID("SATAN");
        ctrl.deleteUser(userID);
        ctrl.deleteCampaign(userID);
   }

    @Test
    public void testPOEStatus() throws ClassNotFoundException, DatabaseErrorException {
        ctrl = new facadeCtrl();
        Campaign2 camp = new Campaign2(666, "", "SATAN", "HELL LLC", "", "", "", "", "", "", 5, "", "", 0, 0, 0, 0, 0, 0, 0, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0, 0, 0, 0.0, 0.0, "", "", 0.0, 0, 0.0, "", 0, 666);
        int id = 0;
        ctrl.submitNewCampaignV2(camp, id);
        assertEquals(0, camp.getHas_poe());
        Campaign2 camp2 = new Campaign2(666, "", "SATAN", "HELL LLC", "", "", "", "", "", "", 5, "", "", 0, 0, 0, 0, 0, 0, 0, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0, 0, 0, 0.0, 0.0, "", "", 0.0, 0, 0.0, "", 1, 666);
        ctrl.submitNewCampaignV2(camp2, id);
        assertEquals(1, camp2.getHas_poe());
        int userID = ctrl.getUserID("SATAN");
        ctrl.deleteUser(userID);
        ctrl.deleteCampaign(userID);
    }
    
    @Test
    public void testLoginFalse() throws ClassNotFoundException, DatabaseErrorException {
        ctrl = new facadeCtrl();
        User user = new User(666, "SATAN", "XYZZY", " ", " ", " ", 40404040, " ", 1);
        ctrl.createNewUser(user);
        assertFalse(ctrl.getUser("SATAN", "ZYXXY"));
        int userID = ctrl.getUserID("SATAN");
        ctrl.deleteUser(userID);
    }

    @Test
    public void testLoginTrue() throws ClassNotFoundException, DatabaseErrorException {
        ctrl = new facadeCtrl();
        User user = new User(666, "SATAN", "XYZZY", " ", " ", " ", 40404040, " ", 0);
        ctrl.createNewUser(user);
        assertTrue(ctrl.getUser("SATAN", "XYZZY"));
        int userID = ctrl.getUserID("SATAN");
        ctrl.deleteUser(userID);
    }
    
    @Test
    public void testCommentEntry() throws DatabaseErrorException, ClassNotFoundException {
        List<Message> msgList = new ArrayList<>();
        ctrl = new facadeCtrl();
        Campaign2 camp = new Campaign2(1, "", "SATAN", "HELL LLC", "", "", "", "", "", "", 5, "", "", 0, 0, 0, 0, 0, 0, 0, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0, 0, 0, 0.0, 0.0, "", "", 0.0, 0, 0.0, "", 0, 666);
        int id = 0;
        ctrl.submitNewCampaignV2(camp, id);
        camp = getSpecificCampaignV2("SATAN");
        assertEquals("HELL LLC", camp.getCompany_name());
        Message msg = new Message(1, "TEST", 666, "1966-66-66", 666, "SATAN");
        ctrl.createNewMessage(msg);
        ctrl.getSpecificMessage(id);
        msgList = ctrl.getSpecificMessage(666);
        msg = msgList.get(1);
        assertEquals("TEST",msg.getComments());
        int userID = ctrl.getUserID("SATAN");
        ctrl.deleteUser(userID);
        ctrl.deleteCampaign(userID);
    }
}
