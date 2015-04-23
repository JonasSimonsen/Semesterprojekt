package control;

import facade.facadeDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Campaign;
import model.Campaign2;

public class CampaignCtrl {

    facadeDAO facade = new facadeDAO();

    public void submitNewCampaignV2(Campaign2 camp, int userID) throws SQLException, ClassNotFoundException {
        facade.submitNewCampaignV2(camp, userID);
    }

    public void deleteCampaign(String name) throws SQLException, ClassNotFoundException {
        facade.deleteCampaign(name);
    }

    public void editCampaign(Campaign camp) throws SQLException, ClassNotFoundException {
        facade.editCampaign(camp);
    }

    public void approveBudget(int campno, double budget) throws SQLException, ClassNotFoundException {
        facade.approveBudget(campno, budget);
    }

    public void budgetStatus(String status, int campno) throws SQLException, ClassNotFoundException {
        facade.budgetStatus(status, campno);
    }

    public void updatePOEStatus(int campno, int has_poe) throws SQLException, ClassNotFoundException {
        facade.updatePOEStatus(campno, has_poe);
    }

    public Campaign2 getSpecificCampaign(int campno) throws SQLException, ClassNotFoundException {
        Campaign2 camp = facade.getSpecificCampaign(campno);
        return camp;
    }

    public ArrayList<Campaign2> getCampaignsExternal(int id) throws SQLException, ClassNotFoundException {
        ArrayList<Campaign2> camp = facade.getCampaignsExternal(id);
        return camp;
    }

    public ArrayList<Campaign2> getCampaigns() throws SQLException, ClassNotFoundException {
        ArrayList<Campaign2> camp = facade.getCampaigns();
        return camp;
    }
}
