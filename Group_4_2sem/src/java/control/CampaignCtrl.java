package control;

import facade.facadeDAO;
import java.util.ArrayList;
import DTO.Campaign;
import DTO.Campaign2;
import exceptions.DatabaseErrorException;

public class CampaignCtrl {

    facadeDAO facade = new facadeDAO();

    public void submitNewCampaignV2(Campaign2 camp, int userID) throws DatabaseErrorException, ClassNotFoundException {
        facade.submitNewCampaignV2(camp, userID);
    }

    public void deleteCampaign(String name) throws DatabaseErrorException, ClassNotFoundException {
        facade.deleteCampaign(name);
    }

    public void editCampaign(Campaign camp) throws DatabaseErrorException, ClassNotFoundException {
        facade.editCampaign(camp);
    }

    public void approveBudget(int campno, double budget) throws DatabaseErrorException, ClassNotFoundException {
        facade.approveBudget(campno, budget);
    }

    public void budgetStatus(String status, int campno) throws DatabaseErrorException, ClassNotFoundException {
        facade.budgetStatus(status, campno);
    }

    public void updatePOEStatus(int campno, int has_poe) throws DatabaseErrorException, ClassNotFoundException {
        facade.updatePOEStatus(campno, has_poe);
    }

    public Campaign2 getSpecificCampaign(int campno) throws DatabaseErrorException, ClassNotFoundException {
        Campaign2 camp = facade.getSpecificCampaign(campno);
        return camp;
    }

    public ArrayList<Campaign2> getCampaignsExternal(int id) throws DatabaseErrorException, ClassNotFoundException {
        ArrayList<Campaign2> camp = facade.getCampaignsExternal(id);
        return camp;
    }

    public ArrayList<Campaign2> getCampaigns() throws DatabaseErrorException, ClassNotFoundException {
        ArrayList<Campaign2> camp = facade.getCampaigns();
        return camp;
    }
}
