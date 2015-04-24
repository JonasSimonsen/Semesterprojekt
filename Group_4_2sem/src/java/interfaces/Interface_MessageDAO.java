package interfaces;

import DTO.Message;
import exceptions.DatabaseErrorException;
import java.util.List;

public interface Interface_MessageDAO {

    public void createNewMessage(Message message) throws DatabaseErrorException, ClassNotFoundException;

    public List<Message> getMessages() throws DatabaseErrorException, ClassNotFoundException;

    public List<Message> getSpecificMessage(int ID) throws DatabaseErrorException, ClassNotFoundException;

}
