package control;

import java.util.ArrayList;
import DTO.Campaign;
import DTO.Campaign2;
import exceptions.DatabaseErrorException;
import facade.facadeDAO;
import interfaces.Interface_DAOFacade;

public class CampaignCtrl {

    Interface_DAOFacade dao = new facadeDAO();

    public void submitNewCampaignV2(Campaign2 camp, int userID) throws DatabaseErrorException, ClassNotFoundException {
        dao.submitNewCampaignV2(camp, userID);
    }

    public void deleteCampaign(int ID) throws DatabaseErrorException, ClassNotFoundException {
        dao.deleteCampaign(ID);
    }

    public void editCampaign(Campaign camp) throws DatabaseErrorException, ClassNotFoundException {
        dao.editCampaign(camp);
    }

    public void approveBudget(int campno, double budget) throws DatabaseErrorException, ClassNotFoundException {
        dao.approveBudget(campno, budget);
    }

    public void budgetStatus(String status, int campno) throws DatabaseErrorException, ClassNotFoundException {
        dao.budgetStatus(status, campno);
    }

    public void updatePOEStatus(int campno, int has_poe) throws DatabaseErrorException, ClassNotFoundException {
        dao.updatePOEStatus(campno, has_poe);
    }

    public Campaign2 getSpecificCampaign(int campno) throws DatabaseErrorException, ClassNotFoundException {
        Campaign2 camp = dao.getSpecificCampaign(campno);
        return camp;
    }

    public ArrayList<Campaign2> getCampaignsExternal(int id) throws DatabaseErrorException, ClassNotFoundException {
        ArrayList<Campaign2> camp = dao.getCampaignsExternal(id);
        return camp;
    }

    public ArrayList<Campaign2> getCampaigns() throws DatabaseErrorException, ClassNotFoundException {
        ArrayList<Campaign2> camp = dao.getCampaigns();
        return camp;
    }
}
