package facade;

import data.*;
import interfaces.*;
import java.sql.SQLException;
import model.*;

public class facadeDAO {

    Interface_PartnerDAO partnerDAO = new PartnerDAO();
    Interface_UserDAO userDAO = new UserDAO();
    Interface_CampaignDAO campaignDAO = new CampaignDAO();
    Interface_ActivityDAO activityDAO = new ActivityDAO();

    public void createNewActivity(Activity activity) throws SQLException, ClassNotFoundException {
        activityDAO.createNewActivity(activity);
    }

    public void submitNewCampaignV2(Campaign2 camp, int userID) throws SQLException, ClassNotFoundException {
        campaignDAO.submitNewCampaignV2(camp, userID);
    }

    public void deleteCampaign(String name) throws SQLException, ClassNotFoundException {
        campaignDAO.deleteCampaign(name);
    }

    public void editCampaign(Campaign camp) throws SQLException, ClassNotFoundException {
        campaignDAO.editCampaign(camp);
    }

    public void approveBudget(int campno, double budget) throws SQLException, ClassNotFoundException {
        campaignDAO.approveBudget(campno, budget);
    }

    public void budgetStatus(String status, int campno) throws SQLException, ClassNotFoundException {
        campaignDAO.budgetStatus(status, campno);
    }

    public void updatePOEStatus(int campno, int has_poe) throws SQLException, ClassNotFoundException {
        campaignDAO.updatePOEStatus(campno, has_poe);
    }

    public void createNewPartner(Partner partner) throws SQLException, ClassNotFoundException {
        partnerDAO.createNewPartner(partner);
    }

    public void createNewUser(User user) throws SQLException, ClassNotFoundException {
        userDAO.createNewUser(user);
    }

    public void deleteUser(String name) throws SQLException, ClassNotFoundException {
        userDAO.deleteUser(name);
    }
}
