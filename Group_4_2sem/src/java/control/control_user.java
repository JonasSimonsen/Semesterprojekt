

package control;

import interfaces.interface_user;
import model.User;
import java.sql.SQLException;


public class control_user implements interface_user {

    @Override
    public void create_User(int partnerId, String userName, String passWord, String firstName, String lastName, String email, int phoneNum, String organization, int type) {
        User ext_user = new User(partnerId, userName, passWord, firstName, lastName, email, phoneNum, organization, type);
        
    }

    
    
    
}
