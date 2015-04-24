/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import DTO.Campaign;
import DTO.Campaign2;
import exceptions.DatabaseErrorException;

/**
 *
 * @author Sander
 */
public interface Interface_CampaignDAO {
    
    public void submitNewCampaignV2(Campaign2 camp, int userID) throws DatabaseErrorException, ClassNotFoundException;
    public void deleteCampaign(String name) throws DatabaseErrorException, ClassNotFoundException;
    public void editCampaign(Campaign camp) throws DatabaseErrorException, ClassNotFoundException;
    public void approveBudget(int campno, double budget) throws DatabaseErrorException, ClassNotFoundException;
    public void budgetStatus(String status, int campno) throws DatabaseErrorException, ClassNotFoundException;
    public void updatePOEStatus(int campno, int has_poe) throws DatabaseErrorException, ClassNotFoundException;
    public Campaign2 getSpecificCampaign(int campno) throws DatabaseErrorException, ClassNotFoundException;
    public ArrayList<Campaign2> getCampaignsExternal(int id) throws DatabaseErrorException, ClassNotFoundException;
    public ArrayList<Campaign2> getCampaigns() throws DatabaseErrorException, ClassNotFoundException;
}
