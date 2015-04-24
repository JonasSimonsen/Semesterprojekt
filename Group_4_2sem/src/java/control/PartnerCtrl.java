package control;

import facade.facadeDAO;
import DTO.Partner;
import exceptions.DatabaseErrorException;
import interfaces.Interface_DAOFacade;

public class PartnerCtrl {
    Interface_DAOFacade dao = new facadeDAO();
    public void createNewPartner(Partner partner) throws DatabaseErrorException, ClassNotFoundException{
        dao.createNewPartner(partner);
    }
}
