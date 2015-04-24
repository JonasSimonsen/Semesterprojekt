package control;

import DTO.Message;
import exceptions.DatabaseErrorException;
import facade.facadeDAO;
import java.util.List;

public class MessageCtrl {

    facadeDAO facade = new facadeDAO();

    public void createNewMessage(Message message) throws DatabaseErrorException, ClassNotFoundException {
        facade.createNewMessage(message);
    }

    public List<Message> getMessages() throws DatabaseErrorException, ClassNotFoundException {
        List<Message> message = facade.getMessages();
        return message;
    }

    public List<Message> getSpecificMessage(int ID) throws DatabaseErrorException, ClassNotFoundException {
        List<Message> message = facade.getSpecificMessage(ID);
        return message;
    }
}
