package control;

import facade.facadeDAO;
import java.sql.SQLException;
import model.User;

public class UserCtrl {
    facadeDAO facade = new facadeDAO();
    public void createNewUser(User user) throws SQLException, ClassNotFoundException {
      facade.createNewUser(user);
    }

    public void deleteUser(String name) throws SQLException, ClassNotFoundException {
      facade.deleteUser(name);
    }
}