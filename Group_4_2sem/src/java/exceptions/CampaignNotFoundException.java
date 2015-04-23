package exceptions;


public class CampaignNotFoundException extends Exception {

    public CampaignNotFoundException () {
    
    }
    
    public CampaignNotFoundException (String message) {
        super(message);
    }
    
}
