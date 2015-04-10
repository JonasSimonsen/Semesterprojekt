/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ZARDOZ
 */
public class Partner {
    int PNO;
    String partnerName;
    
    public Partner (int PNO, String partnerName){
        this.PNO = PNO;
        this.partnerName = partnerName;
    }

    public int getPNO() {
        return PNO;
    }

    public void setPNO(int PNO) {
        this.PNO = PNO;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
}
