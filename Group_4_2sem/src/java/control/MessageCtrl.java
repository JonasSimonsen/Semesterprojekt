package control;

import java.sql.SQLException;
import DTO.Message;
import facade.FacadeDAO;
import java.util.ArrayList;

public class MessageCtrl {

    FacadeDAO facade = new FacadeDAO();

    public void createNewMessage(Message message) throws SQLException, ClassNotFoundException {
        facade.createNewMessage(message);
    }

    public ArrayList<Message> getMessages() throws SQLException, ClassNotFoundException {
        ArrayList<Message> message = facade.getActivity();
        return message;
    }

    public ArrayList<Message> getSpecificMessage(int ID) throws SQLException, ClassNotFoundException {
        ArrayList<Message> message = facade.getActivity();
        return message;
    }
}
