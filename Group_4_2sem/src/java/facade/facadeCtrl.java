package facade;

import DTO.Campaign;
import DTO.User;
import DTO.Partner;
import DTO.Message;
import DTO.Campaign2;
import control.*;
import exceptions.DatabaseErrorException;
import interfaces.Interface_CtrlFacade;
import java.util.ArrayList;
import java.util.List;

public class facadeCtrl implements Interface_CtrlFacade {

    CampaignCtrl CampCtrl = new CampaignCtrl();
    MessageCtrl MsgCtrl = new MessageCtrl();
    PartnerCtrl PartCtrl = new PartnerCtrl();
    UserCtrl UseCtrl = new UserCtrl();

    @Override
    public void createNewMessage(Message message) throws DatabaseErrorException, ClassNotFoundException {
        MsgCtrl.createNewMessage(message);
    }

    @Override
    public void submitNewCampaignV2(Campaign2 camp, int userID) throws DatabaseErrorException, ClassNotFoundException {
        CampCtrl.submitNewCampaignV2(camp, userID);
    }

    @Override
    public void deleteCampaign(int ID) throws DatabaseErrorException, ClassNotFoundException {
        CampCtrl.deleteCampaign(ID);
    }

    @Override
    public void editCampaign(Campaign camp) throws DatabaseErrorException, ClassNotFoundException {
        CampCtrl.editCampaign(camp);
    }

    @Override
    public void approveBudget(int campno, double budget) throws DatabaseErrorException, ClassNotFoundException {
        CampCtrl.approveBudget(campno, budget);
    }

    @Override
    public void budgetStatus(String status, int campno) throws DatabaseErrorException, ClassNotFoundException {
        CampCtrl.budgetStatus(status, campno);
    }

    @Override
    public void updatePOEStatus(int campno, int has_poe) throws DatabaseErrorException, ClassNotFoundException {
        CampCtrl.updatePOEStatus(campno, has_poe);
    }

    @Override
    public void createNewPartner(Partner partner) throws DatabaseErrorException, ClassNotFoundException {
        PartCtrl.createNewPartner(partner);
    }

    @Override
    public void createNewUser(User user) throws DatabaseErrorException, ClassNotFoundException {
        UseCtrl.createNewUser(user);
    }

    @Override
    public void deleteUser(int ID) throws DatabaseErrorException, ClassNotFoundException {
        UseCtrl.deleteUser(ID);
    }

    @Override
    public int getUserID(String UN) throws DatabaseErrorException, ClassNotFoundException {
        int userID = UseCtrl.getUserID(UN);
        return userID;
    }

    @Override
    public ArrayList<Campaign2> getCampaignsExternal(int ID) throws DatabaseErrorException, ClassNotFoundException {
        ArrayList<Campaign2> camp = CampCtrl.getCampaignsExternal(ID);
        return camp;
    }

    @Override
    public Campaign2 getSpecificCampaign(int PLANNO) throws DatabaseErrorException, ClassNotFoundException {
        Campaign2 camp = CampCtrl.getSpecificCampaign(PLANNO);
        return camp;
    }

    @Override
    public ArrayList<Campaign2> getCampaigns() throws DatabaseErrorException, ClassNotFoundException {
        ArrayList<Campaign2> camp = CampCtrl.getCampaigns();
        return camp;
    }

    @Override
    public boolean getUser(String UN, String PW) throws DatabaseErrorException, ClassNotFoundException {
        boolean user = UseCtrl.getUser(UN, PW);
        return user;
    }

    @Override
    public int getUserType(String UN) throws DatabaseErrorException, ClassNotFoundException {
        int userType = UseCtrl.getUserType(UN);
        return userType;
    }

    @Override
    public List<Message> getMessages() throws DatabaseErrorException, ClassNotFoundException {
        List<Message> message = MsgCtrl.getMessages();
        return message;
    }

    @Override
    public List<Message> getSpecificMessage(int ID) throws DatabaseErrorException, ClassNotFoundException {
        List<Message> message = MsgCtrl.getSpecificMessage(ID);
        return message;
    }
    
    @Override
    public ArrayList<User> getUsers() throws DatabaseErrorException, ClassNotFoundException {
        ArrayList<User> user = UseCtrl.getUsers();
        return user;
    }
}
