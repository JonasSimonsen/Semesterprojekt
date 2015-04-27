package control;

import facade.facadeDAO;
import DTO.User;
import exceptions.DatabaseErrorException;
import interfaces.Interface_DAOFacade;
import java.util.ArrayList;

public class UserCtrl {

    Interface_DAOFacade dao = new facadeDAO();

    public void createNewUser(User user) throws DatabaseErrorException, ClassNotFoundException {
        dao.createNewUser(user);
    }

    public void deleteUser(int ID) throws DatabaseErrorException, ClassNotFoundException {
        dao.deleteUser(ID);
    }

    public int getUserID(String username) throws DatabaseErrorException, ClassNotFoundException {
        int userID = dao.getUserID(username);
        return userID;
    }

    public int getUserType(String username) throws DatabaseErrorException, ClassNotFoundException {
        int userType = dao.getUserType(username);
        return userType;
    }

    public boolean getUser(String username, String password) throws DatabaseErrorException, ClassNotFoundException {
        boolean user = dao.getUser(username, password);
        return user;
    }
    
    public ArrayList<User> getUsers() throws DatabaseErrorException, ClassNotFoundException {
        ArrayList<User> user = dao.getUsers();
        return user;
    }
}
