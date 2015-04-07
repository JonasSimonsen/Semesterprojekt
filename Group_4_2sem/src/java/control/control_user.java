

package control;

import interfaces.interface_user;
import entity.external_user;


public class control_user implements interface_user {

    @Override
    public void create_User(int partnerId, String userName, String passWord, String firstName, String lastName, String email, int phoneNum, String organization, int type) {
        external_user ext_user = new external_user(partnerId, userName, passWord, firstName, lastName, email, phoneNum, organization, type);
    }

    
    
    
}
