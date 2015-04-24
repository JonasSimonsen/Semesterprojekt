package control;

import java.sql.SQLException;
import DTO.Message;
import facade.facadeDAO;
import java.util.List;

public class MessageCtrl {

    facadeDAO facade = new facadeDAO();

    public void createNewMessage(Message message) throws SQLException, ClassNotFoundException {
        facade.createNewMessage(message);
    }

    public List<Message> getMessages() throws SQLException, ClassNotFoundException {
        List<Message> message = facade.getMessages();
        return message;
    }

    public List<Message> getSpecificMessage(int ID) throws SQLException, ClassNotFoundException {
        List<Message> message = facade.getSpecificMessage(ID);
        return message;
    }
}
