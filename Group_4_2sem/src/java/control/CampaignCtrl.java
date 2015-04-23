package control;

import facade.facadeDAO;
import java.sql.SQLException;
import model.Campaign;
import model.Campaign2;

public class CampaignCtrl {
   facadeDAO facade = new facadeDAO();
    public void submitNewCampaignV2(Campaign2 camp, int userID) throws SQLException, ClassNotFoundException{
        facade.submitNewCampaignV2(camp, userID);
    }
    public void deleteCampaign(String name) throws SQLException, ClassNotFoundException{
        facade.deleteCampaign(name);
    }
    public void editCampaign(Campaign camp) throws SQLException, ClassNotFoundException{
        facade.editCampaign(camp);
    }
    public void approveBudget(int campno, double budget) throws SQLException, ClassNotFoundException{
        facade.approveBudget(campno, budget);
    }
    public void budgetStatus(String status, int campno) throws SQLException, ClassNotFoundException{
        facade.budgetStatus(status, campno);
    }
    public void updatePOEStatus(int campno, int has_poe) throws SQLException, ClassNotFoundException{
        facade.updatePOEStatus(campno, has_poe);
    }
}
