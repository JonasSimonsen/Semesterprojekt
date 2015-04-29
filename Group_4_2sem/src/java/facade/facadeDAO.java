package facade;

import data.*;
import interfaces.*;
import java.util.ArrayList;
import DTO.*;
import exceptions.DatabaseErrorException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

public class facadeDAO implements Interface_DAOFacade {

    PartnerDAO partnerDAO = new PartnerDAO();
    UserDAO userDAO = new UserDAO();
    CampaignDAO campaignDAO = new CampaignDAO();
    MessageDAO messageDAO = new MessageDAO();

    
    @Override
    public void createNewMessage(Message message) throws DatabaseErrorException, ClassNotFoundException {
        messageDAO.createNewMessage(message);
    }

    @Override
    public void submitNewCampaignV2(Campaign2 camp, int userID) throws DatabaseErrorException, ClassNotFoundException {
        campaignDAO.submitNewCampaignV2(camp, userID);
    }

    @Override
    public void deleteCampaign(int ID) throws DatabaseErrorException, ClassNotFoundException {
        campaignDAO.deleteCampaign(ID);
    }

    @Override
    public void editCampaign(Campaign camp) throws DatabaseErrorException, ClassNotFoundException {
        campaignDAO.editCampaign(camp);
    }

    @Override
    public void approveBudget(int campno, double budget) throws DatabaseErrorException, ClassNotFoundException {
        campaignDAO.approveBudget(campno, budget);
    }

    @Override
    public void budgetStatus(String status, int campno) throws DatabaseErrorException, ClassNotFoundException {
        campaignDAO.budgetStatus(status, campno);
    }

    @Override
    public void updatePOEStatus(int campno, int has_poe) throws DatabaseErrorException, ClassNotFoundException {
        campaignDAO.updatePOEStatus(campno, has_poe);
    }

    @Override
    public void createNewPartner(Partner partner) throws DatabaseErrorException, ClassNotFoundException {
        partnerDAO.createNewPartner(partner);
    }

    @Override
    public void createNewUser(User user) throws DatabaseErrorException, ClassNotFoundException {
        userDAO.createNewUser(user);
    }

    @Override
    public void deleteUser(int ID) throws DatabaseErrorException, ClassNotFoundException {
        userDAO.deleteUser(ID);
    }

    @Override
    public int getUserID(String username) throws DatabaseErrorException, ClassNotFoundException {
        int userID = userDAO.getUserID(username);
        return userID;
    }

    @Override
    public int getUserType(String username) throws DatabaseErrorException, ClassNotFoundException {
        int userType = userDAO.getUserType(username);
        return userType;
    }

    @Override
    public boolean getUser(String username, String password) throws DatabaseErrorException, ClassNotFoundException {
        boolean user = userDAO.getUser(username, password);
        return user;
    }

    @Override
    public Campaign2 getSpecificCampaign(int campno) throws DatabaseErrorException, ClassNotFoundException {
        Campaign2 camp = campaignDAO.getSpecificCampaign(campno);
        return camp;
    }

    @Override
    public ArrayList<Campaign2> getCampaignsExternal(int id) throws DatabaseErrorException, ClassNotFoundException {
        ArrayList<Campaign2> camp = campaignDAO.getCampaignsExternal(id);
        return camp;
    }

    @Override
    public ArrayList<Campaign2> getCampaigns() throws DatabaseErrorException, ClassNotFoundException {
        ArrayList<Campaign2> camp = campaignDAO.getCampaigns();
        return camp;
    }

    @Override
    public List<Message> getMessages() throws DatabaseErrorException, ClassNotFoundException {
        List<Message> message = messageDAO.getMessages();
        return message;
    }

    @Override
    public List<Message> getSpecificMessage(int ID) throws DatabaseErrorException, ClassNotFoundException {
        List<Message> message = messageDAO.getSpecificMessage(ID);
        return message;
    }
    
    @Override
    public ArrayList<User> getUsers() throws DatabaseErrorException, ClassNotFoundException {
        ArrayList<User> user = userDAO.getUsers();
        return user;
    }
    
    @Override
    public void savePOE(InputStream input, int campno) throws DatabaseErrorException, ClassNotFoundException {
        campaignDAO.savePOE(input, campno);
    }

    @Override
    public OutputStream loadPOE(int campno, ServletContext context, HttpServletResponse response) throws DatabaseErrorException, ClassNotFoundException {
       OutputStream output = campaignDAO.loadPOE(campno, context, response);
       return output;
    }
}
