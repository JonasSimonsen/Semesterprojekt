package DTO;


public class POE {
    
    private final String poe_id;
    private String poe_path;

    public POE(String poe_id, String poe_path) {
        this.poe_id = poe_id;
        this.poe_path = poe_path;
    }

    public String getPoe_path() {
        return poe_path;
    }

    public void setPoe_path(String poe_path) {
        this.poe_path = poe_path;
    }

    public String getPoe_id() {
        return poe_id;
    }

}
