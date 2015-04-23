package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Message;

public interface Interface_MessageDAO {

    public void createNewMessage(Message message) throws SQLException, ClassNotFoundException;

    public ArrayList<Message> getMessages() throws SQLException, ClassNotFoundException;

    public ArrayList<Message> getSpecificMessage(int ID) throws SQLException, ClassNotFoundException;

}
