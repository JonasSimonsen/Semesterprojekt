/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Activity;

/**
 *
 * @author Sander
 */
public interface Interface_ActivityDAO {

    public void createNewActivity(Activity activity) throws SQLException, ClassNotFoundException;

    public ArrayList<Activity> getActivity() throws SQLException, ClassNotFoundException;

    public ArrayList<Activity> getSpecificActivity(int ID) throws SQLException, ClassNotFoundException;

}
