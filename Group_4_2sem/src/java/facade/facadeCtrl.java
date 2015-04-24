package facade;

import DTO.Campaign;
import DTO.User;
import DTO.Partner;
import DTO.Message;
import DTO.Campaign2;
import control.*;
import exceptions.DatabaseErrorException;
import java.util.ArrayList;
import java.util.List;

public class facadeCtrl {

    MessageCtrl MsgCtrl = new MessageCtrl();
    CampaignCtrl CampCtrl = new CampaignCtrl();
    PartnerCtrl PartCtrl = new PartnerCtrl();
    UserCtrl UseCtrl = new UserCtrl();

    public void createNewMessage(Message message) throws DatabaseErrorException, ClassNotFoundException {
        MsgCtrl.createNewMessage(message);
    }

    public void submitNewCampaignV2(Campaign2 camp, int userID) throws DatabaseErrorException, ClassNotFoundException {
        CampCtrl.submitNewCampaignV2(camp, userID);
    }

    public void deleteCampaign(String name) throws DatabaseErrorException, ClassNotFoundException {
        CampCtrl.deleteCampaign(name);
    }

    public void editCampaign(Campaign camp) throws DatabaseErrorException, ClassNotFoundException {
        CampCtrl.editCampaign(camp);
    }

    public void approveBudget(int campno, double budget) throws DatabaseErrorException, ClassNotFoundException {
        CampCtrl.approveBudget(campno, budget);
    }

    public void budgetStatus(String status, int campno) throws DatabaseErrorException, ClassNotFoundException {
        CampCtrl.budgetStatus(status, campno);
    }

    public void updatePOEStatus(int campno, int has_poe) throws DatabaseErrorException, ClassNotFoundException {
        CampCtrl.updatePOEStatus(campno, has_poe);
    }

    public void createNewPartner(Partner partner) throws DatabaseErrorException, ClassNotFoundException {
        PartCtrl.createNewPartner(partner);
    }

    public void createNewUser(User user) throws DatabaseErrorException, ClassNotFoundException {
        UseCtrl.createNewUser(user);
    }

    public void deleteUser(String name) throws DatabaseErrorException, ClassNotFoundException {
        UseCtrl.deleteUser(name);
    }

    public int getUserID(String UN) throws DatabaseErrorException, ClassNotFoundException {
        int userID = UseCtrl.getUserID(UN);
        return userID;
    }

    public ArrayList<Campaign2> getCampaignsExternal(int ID) throws DatabaseErrorException, ClassNotFoundException {
        ArrayList<Campaign2> camp = CampCtrl.getCampaignsExternal(ID);
        return camp;
    }

    public Campaign2 getSpecificCampaign(int PLANNO) throws DatabaseErrorException, ClassNotFoundException {
        Campaign2 camp = CampCtrl.getSpecificCampaign(PLANNO);
        return camp;
    }

    public ArrayList<Campaign2> getCampaigns() throws DatabaseErrorException, ClassNotFoundException {
        ArrayList<Campaign2> camp = CampCtrl.getCampaigns();
        return camp;
    }

    public boolean getUser(String UN, String PW) throws DatabaseErrorException, ClassNotFoundException {
        boolean user = UseCtrl.getUser(PW, PW);
        return user;
    }

    public int getUserType(String UN) throws DatabaseErrorException, ClassNotFoundException {
        int userType = UseCtrl.getUserType(UN);
        return userType;
    }

    public List<Message> getActivity() throws DatabaseErrorException, ClassNotFoundException {
        List<Message> message = MsgCtrl.getMessages();
        return message;
    }

    public List<Message> getSpecificMessage(int ID) throws DatabaseErrorException, ClassNotFoundException {
        List<Message> message = MsgCtrl.getSpecificMessage(ID);
        return message;
    }
}
