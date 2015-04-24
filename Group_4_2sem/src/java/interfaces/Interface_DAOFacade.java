/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import DTO.Campaign;
import DTO.Campaign2;
import DTO.Message;
import DTO.Partner;
import DTO.User;
import exceptions.DatabaseErrorException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZARDOZ
 */
public interface Interface_DAOFacade {

    public void createNewMessage(Message message) throws DatabaseErrorException, ClassNotFoundException;

    public void submitNewCampaignV2(Campaign2 camp, int userID) throws DatabaseErrorException, ClassNotFoundException;

    public void deleteCampaign(String name) throws DatabaseErrorException, ClassNotFoundException;

    public void editCampaign(Campaign camp) throws DatabaseErrorException, ClassNotFoundException;

    public void approveBudget(int campno, double budget) throws DatabaseErrorException, ClassNotFoundException;

    public void budgetStatus(String status, int campno) throws DatabaseErrorException, ClassNotFoundException;

    public void updatePOEStatus(int campno, int has_poe) throws DatabaseErrorException, ClassNotFoundException;

    public void createNewPartner(Partner partner) throws DatabaseErrorException, ClassNotFoundException;

    public void createNewUser(User user) throws DatabaseErrorException, ClassNotFoundException;

    public void deleteUser(String name) throws DatabaseErrorException, ClassNotFoundException;

    public int getUserID(String username) throws DatabaseErrorException, ClassNotFoundException;

    public int getUserType(String username) throws DatabaseErrorException, ClassNotFoundException;

    public boolean getUser(String username, String password) throws DatabaseErrorException, ClassNotFoundException;

    public Campaign2 getSpecificCampaign(int campno) throws DatabaseErrorException, ClassNotFoundException;

    public ArrayList<Campaign2> getCampaignsExternal(int id) throws DatabaseErrorException, ClassNotFoundException;

    public ArrayList<Campaign2> getCampaigns() throws DatabaseErrorException, ClassNotFoundException;

    public List<Message> getMessages() throws DatabaseErrorException, ClassNotFoundException;

    public List<Message> getSpecificMessage(int ID) throws DatabaseErrorException, ClassNotFoundException;
}
