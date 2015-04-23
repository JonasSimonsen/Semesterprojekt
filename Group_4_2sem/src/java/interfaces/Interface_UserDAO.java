/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import model.User;

/**
 *
 * @author Sander
 */
public interface Interface_UserDAO {
    
    public void createNewUser(User user) throws SQLException, ClassNotFoundException;
    public void deleteUser(String name) throws SQLException, ClassNotFoundException;
    public int getUserID(String username) throws SQLException, ClassNotFoundException;
    public int getUserType(String username) throws SQLException, ClassNotFoundException;
    public boolean getUser(String username, String password) throws SQLException, ClassNotFoundException;
}
