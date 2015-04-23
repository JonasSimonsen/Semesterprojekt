package control;

import java.sql.SQLException;
import model.Activity;
import facade.facadeDAO;
import java.util.ArrayList;

public class ActivityCtrl {

    facadeDAO facade = new facadeDAO();

    public void createNewActivity(Activity activity) throws SQLException, ClassNotFoundException {
        facade.createNewActivity(activity);
    }

    public ArrayList<Activity> getActivity() throws SQLException, ClassNotFoundException {
        ArrayList<Activity> activity = facade.getActivity();
        return activity;
    }

    public ArrayList<Activity> getSpecificActivity(int ID) throws SQLException, ClassNotFoundException {
        ArrayList<Activity> activity = facade.getActivity();
        return activity;
    }
}
