package DTO;

public class Message implements Comparable<Message> {

    private String comments, date, username;
    private int commentID, campNum, ID;

    public Message(int commentID, String comments, int campNum, String date, int ID, String username) {
        this.commentID = commentID;
        this.comments = comments;
        this.date = date;
        this.campNum = campNum;
        this.ID = ID;
        this.username = username;
    }

    @Override
    public int compareTo(Message other) {

        // compareTo should return < 0 if this is supposed to be
        // less than other, > 0 if this is supposed to be greater than 
        // other and 0 if they are supposed to be equal
        return Integer.compare(this.commentID, other.commentID);

    }

    public String getComments() {
        return comments;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getCampNum() {
        return campNum;
    }

    public void setCampNum(int campNum) {
        this.campNum = campNum;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
