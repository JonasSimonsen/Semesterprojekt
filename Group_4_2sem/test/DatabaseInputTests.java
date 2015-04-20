/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import control.UserDAO;
import control.CampaignDAO;
import interfaces.*;
import control.*;
import static control.CampaignDAO.getSpecificCampaign;
import static control.CampaignDAO.getSpecificCampaignV2;
import static control.UserDAO.getUserInfo;
import java.sql.SQLException;
import model.Campaign2;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ZARDOZ
 */
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
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
