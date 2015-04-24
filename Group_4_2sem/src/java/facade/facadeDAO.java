package facade;

import data.*;
import interfaces.*;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.*;
import java.util.List;

public class facadeDAO {

    Interface_PartnerDAO partnerDAO = new PartnerDAO();
    Interface_UserDAO userDAO = new UserDAO();
    Interface_CampaignDAO campaignDAO = new CampaignDAO();
    Interface_MessageDAO messageDAO = new MessageDAO();

    public void createNewMessage(Message message) throws SQLException, ClassNotFoundException {
        messageDAO.createNewMessage(message);
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

    public int getUserID(String username) throws SQLException, ClassNotFoundException {
        int userID = userDAO.getUserID(username);
        return userID;
    }

    public int getUserType(String username) throws SQLException, ClassNotFoundException {
        int userType = userDAO.getUserType(username);
        return userType;
    }

    public boolean getUser(String username, String password) throws SQLException, ClassNotFoundException {
        boolean user = userDAO.getUser(username, password);
        return user;
    }

    public Campaign2 getSpecificCampaign(int campno) throws SQLException, ClassNotFoundException {
        Campaign2 camp = campaignDAO.getSpecificCampaign(campno);
        return camp;
    }

    public ArrayList<Campaign2> getCampaignsExternal(int id) throws SQLException, ClassNotFoundException {
        ArrayList<Campaign2> camp = campaignDAO.getCampaignsExternal(id);
        return camp;
    }

    public ArrayList<Campaign2> getCampaigns() throws SQLException, ClassNotFoundException {
        ArrayList<Campaign2> camp = campaignDAO.getCampaigns();
        return camp;
    }

    public List<Message> getMessages() throws SQLException, ClassNotFoundException {
        List<Message> message = messageDAO.getMessages();
        return message;
    }

    public List<Message> getSpecificMessage(int ID) throws SQLException, ClassNotFoundException {
        List<Message> message = messageDAO.getSpecificMessage(ID);
        return message;
    }
}
