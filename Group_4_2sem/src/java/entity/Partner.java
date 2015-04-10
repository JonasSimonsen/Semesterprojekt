package entity;

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
