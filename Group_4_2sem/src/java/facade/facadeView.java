package facade;

import control.*;
import java.sql.SQLException;
import java.util.ArrayList;
import model.*;

public class facadeView {

    ActivityCtrl ActCtrl = new ActivityCtrl();
    CampaignCtrl CampCtrl = new CampaignCtrl();
    PartnerCtrl PartCtrl = new PartnerCtrl();
    UserCtrl UseCtrl = new UserCtrl();

    public void createNewActivity(Activity activity) throws SQLException, ClassNotFoundException {
        ActCtrl.createNewActivity(activity);
    }

    public void submitNewCampaignV2(Campaign2 camp, int userID) throws SQLException, ClassNotFoundException {
        CampCtrl.submitNewCampaignV2(camp, userID);
    }

    public void deleteCampaign(String name) throws SQLException, ClassNotFoundException {
        CampCtrl.deleteCampaign(name);
    }

    public void editCampaign(Campaign camp) throws SQLException, ClassNotFoundException {
        CampCtrl.editCampaign(camp);
    }

    public void approveBudget(int campno, double budget) throws SQLException, ClassNotFoundException {
        CampCtrl.approveBudget(campno, budget);
    }

    public void budgetStatus(String status, int campno) throws SQLException, ClassNotFoundException {
        CampCtrl.budgetStatus(status, campno);
    }

    public void updatePOEStatus(int campno, int has_poe) throws SQLException, ClassNotFoundException {
        CampCtrl.updatePOEStatus(campno, has_poe);
    }

    public void createNewPartner(Partner partner) throws SQLException, ClassNotFoundException {
        PartCtrl.createNewPartner(partner);
    }

    public void createNewUser(User user) throws SQLException, ClassNotFoundException {
        UseCtrl.createNewUser(user);
    }

    public void deleteUser(String name) throws SQLException, ClassNotFoundException {
        UseCtrl.deleteUser(name);
    }

    public int getUserID(String UN) throws SQLException, ClassNotFoundException {
        int userID = UseCtrl.getUserID(UN);
        return userID;
    }

    public ArrayList<Campaign2> getCampaignsExternal(int ID) throws SQLException, ClassNotFoundException {
        ArrayList<Campaign2> camp = CampCtrl.getCampaignsExternal(ID);
        return camp;
    }

    public Campaign2 getSpecificCampaign(int PLANNO) throws SQLException, ClassNotFoundException {
        Campaign2 camp = CampCtrl.getSpecificCampaign(PLANNO);
        return camp;
    }

    public ArrayList<Campaign2> getCampaigns() throws SQLException, ClassNotFoundException {
        ArrayList<Campaign2> camp = CampCtrl.getCampaigns();
        return camp;
    }

    public boolean getUser(String UN, String PW) throws SQLException, ClassNotFoundException {
        boolean user = UseCtrl.getUser(PW, PW);
        return user;
    }

    public int getUserType(String UN) throws SQLException, ClassNotFoundException {
        int userType = UseCtrl.getUserType(UN);
        return userType;
    }
}
