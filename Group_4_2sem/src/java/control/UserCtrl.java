package control;

import facade.facadeDAO;
import java.sql.SQLException;
import DTO.User;

public class UserCtrl {

    facadeDAO facade = new facadeDAO();

    public void createNewUser(User user) throws SQLException, ClassNotFoundException {
        facade.createNewUser(user);
    }

    public void deleteUser(String name) throws SQLException, ClassNotFoundException {
        facade.deleteUser(name);
    }

    public int getUserID(String username) throws SQLException, ClassNotFoundException {
        int userID = facade.getUserID(username);
        return userID;
    }

    public int getUserType(String username) throws SQLException, ClassNotFoundException {
        int userType = facade.getUserType(username);
        return userType;
    }

    public boolean getUser(String username, String password) throws SQLException, ClassNotFoundException {
        boolean user = facade.getUser(username, password);
        return user;
    }
}
