package control;

import java.sql.SQLException;
import model.Activity;
import facade.facadeDAO;

public class ActivityCtrl {
        facadeDAO facade = new facadeDAO();
        public void createNewActivity(Activity activity) throws SQLException, ClassNotFoundException{
            facade.createNewActivity(activity);
        }
}
