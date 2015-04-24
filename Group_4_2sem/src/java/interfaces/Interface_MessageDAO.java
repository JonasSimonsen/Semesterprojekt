package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import DTO.Message;
import java.util.List;

public interface Interface_MessageDAO {

    public void createNewMessage(Message message) throws SQLException, ClassNotFoundException;

    public List<Message> getMessages() throws SQLException, ClassNotFoundException;

    public List<Message> getSpecificMessage(int ID) throws SQLException, ClassNotFoundException;

}
