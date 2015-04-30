/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import DTO.Campaign;
import DTO.Message;
import DTO.Partner;
import DTO.User;
import exceptions.DatabaseErrorException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ZARDOZ
 */
public interface Interface_CtrlFacade {

    public void createNewMessage(Message message) throws DatabaseErrorException, ClassNotFoundException;

    public void submitNewCampaignV2(Campaign camp, int userID) throws DatabaseErrorException, ClassNotFoundException;

    public void deleteCampaign(int ID) throws DatabaseErrorException, ClassNotFoundException;

    public void approveBudget(int campno, double budget) throws DatabaseErrorException, ClassNotFoundException;

    public void budgetStatus(String status, int campno) throws DatabaseErrorException, ClassNotFoundException;

    public void updatePOEStatus(int campno, int has_poe) throws DatabaseErrorException, ClassNotFoundException;

    public void createNewPartner(Partner partner) throws DatabaseErrorException, ClassNotFoundException;

    public void createNewUser(User user) throws DatabaseErrorException, ClassNotFoundException;

    public void deleteUser(int ID) throws DatabaseErrorException, ClassNotFoundException;

    public int getUserID(String username) throws DatabaseErrorException, ClassNotFoundException;

    public int getUserType(String username) throws DatabaseErrorException, ClassNotFoundException;

    public boolean getUser(String username, String password) throws DatabaseErrorException, ClassNotFoundException;
    
    public Campaign getSpecificCampaign(int campno) throws DatabaseErrorException, ClassNotFoundException;
    
    public ArrayList<Campaign> getCampaignsExternal(int id) throws DatabaseErrorException, ClassNotFoundException;
    
    public ArrayList<Campaign> getCampaigns() throws DatabaseErrorException, ClassNotFoundException;

    public List<Message> getMessages() throws DatabaseErrorException, ClassNotFoundException;

    public List<Message> getSpecificMessage(int ID) throws DatabaseErrorException, ClassNotFoundException;
    
    public ArrayList<User> getUsers() throws DatabaseErrorException, ClassNotFoundException;
    
    public void savePOE(InputStream input, int campno) throws DatabaseErrorException, ClassNotFoundException;

    public OutputStream loadPOE(int campno, ServletContext context, HttpServletResponse response) throws DatabaseErrorException, ClassNotFoundException;
}
