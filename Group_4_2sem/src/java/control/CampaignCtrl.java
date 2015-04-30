package control;

import java.util.ArrayList;
import DTO.Campaign;
import exceptions.DatabaseErrorException;
import facade.facadeDAO;
import interfaces.Interface_DAOFacade;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

public class CampaignCtrl {

    Interface_DAOFacade dao = new facadeDAO();

    public void submitNewCampaign(Campaign camp, int userID) throws DatabaseErrorException, ClassNotFoundException {
        dao.submitNewCampaign(camp, userID);
    }

    public void deleteCampaign(int ID) throws DatabaseErrorException, ClassNotFoundException {
        dao.deleteCampaign(ID);
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

    public Campaign getSpecificCampaign(int campno) throws DatabaseErrorException, ClassNotFoundException {
        Campaign camp = dao.getSpecificCampaign(campno);
        return camp;
    }

    public ArrayList<Campaign> getCampaignsExternal(int id) throws DatabaseErrorException, ClassNotFoundException {
        ArrayList<Campaign> camp = dao.getCampaignsExternal(id);
        return camp;
    }

    public ArrayList<Campaign> getCampaigns() throws DatabaseErrorException, ClassNotFoundException {
        ArrayList<Campaign> camp = dao.getCampaigns();
        return camp;
    }
    
    public void savePOE(InputStream input, int campno) throws DatabaseErrorException, ClassNotFoundException{
        dao.savePOE(input, campno);
    }

    public OutputStream loadPOE(int campno, ServletContext context, HttpServletResponse response) throws DatabaseErrorException, ClassNotFoundException{
        OutputStream output = dao.loadPOE(campno, context, response);
        return output;
    }
}
