package control;

import facade.facadeDAO;
import DTO.Partner;
import exceptions.DatabaseErrorException;

public class PartnerCtrl {
    facadeDAO facade = new facadeDAO();
    public void createNewPartner(Partner partner) throws DatabaseErrorException, ClassNotFoundException{
        facade.createNewPartner(partner);
    }
}
