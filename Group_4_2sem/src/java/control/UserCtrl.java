package control;

import facade.facadeDAO;
import java.sql.SQLException;
import DTO.User;
import exceptions.DatabaseErrorException;

public class UserCtrl {

    facadeDAO facade = new facadeDAO();

    public void createNewUser(User user) throws DatabaseErrorException, ClassNotFoundException {
        facade.createNewUser(user);
    }

    public void deleteUser(String name) throws DatabaseErrorException, ClassNotFoundException {
        facade.deleteUser(name);
    }

    public int getUserID(String username) throws DatabaseErrorException, ClassNotFoundException {
        int userID = facade.getUserID(username);
        return userID;
    }

    public int getUserType(String username) throws DatabaseErrorException, ClassNotFoundException {
        int userType = facade.getUserType(username);
        return userType;
    }

    public boolean getUser(String username, String password) throws DatabaseErrorException, ClassNotFoundException {
        boolean user = facade.getUser(username, password);
        return user;
    }
}
