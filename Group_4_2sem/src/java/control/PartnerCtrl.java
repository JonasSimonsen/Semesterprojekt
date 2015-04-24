package control;

import facade.facadeDAO;
import java.sql.SQLException;
import DTO.Partner;

public class PartnerCtrl {
    facadeDAO facade = new facadeDAO();
    public void createNewPartner(Partner partner) throws SQLException, ClassNotFoundException{
        facade.createNewPartner(partner);
    }
}
