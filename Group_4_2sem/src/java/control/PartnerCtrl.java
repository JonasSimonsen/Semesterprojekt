package control;

import facade.FacadeDAO;
import java.sql.SQLException;
import DTO.Partner;

public class PartnerCtrl {
    FacadeDAO facade = new FacadeDAO();
    public void createNewPartner(Partner partner) throws SQLException, ClassNotFoundException{
        facade.createNewPartner(partner);
    }
}
