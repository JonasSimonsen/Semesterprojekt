package control;

import DTO.Message;
import exceptions.DatabaseErrorException;
import facade.facadeDAO;
import interfaces.Interface_DAOFacade;
import java.util.List;

public class MessageCtrl {

    Interface_DAOFacade dao = new facadeDAO();

    public void createNewMessage(Message message) throws DatabaseErrorException, ClassNotFoundException {
        dao.createNewMessage(message);
    }

    public List<Message> getMessages() throws DatabaseErrorException, ClassNotFoundException {
        List<Message> message = dao.getMessages();
        return message;
    }

    public List<Message> getSpecificMessage(int ID) throws DatabaseErrorException, ClassNotFoundException {
        List<Message> message = dao.getSpecificMessage(ID);
        return message;
    }
}
