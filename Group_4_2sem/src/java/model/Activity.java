package model;

public class Activity {
    private String comments, date;
    private int planNo, ID;
    
    public Activity (String comments, int planNo, String date, int ID){
        this.comments = comments;
        this.date = date;
        this.planNo = planNo;
        this.ID = ID;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPlanNo() {
        return planNo;
    }

    public void setPlanNo(int planNo) {
        this.planNo = planNo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
}
