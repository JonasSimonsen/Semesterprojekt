/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import DTO.User;
import exceptions.DatabaseErrorException;

/**
 *
 * @author Sander
 */
public interface Interface_UserDAO {
    
    public void createNewUser(User user) throws DatabaseErrorException, ClassNotFoundException;
    public void deleteUser(String name) throws DatabaseErrorException, ClassNotFoundException;
    public int getUserID(String username) throws DatabaseErrorException, ClassNotFoundException;
    public int getUserType(String username) throws DatabaseErrorException, ClassNotFoundException;
    public boolean getUser(String username, String password) throws DatabaseErrorException, ClassNotFoundException;
}
