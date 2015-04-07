package entity;

public class external_user {

    int partnerId;
    String userName;
    String passWord;
    String firstName;
    String lastName;
    String email;
    int phoneNum;
    String organization;
    final int type;

    public external_user(int partnerId, String userName, String passWord, String firstName, String lastName, String email, int phoneNum, String organization, int type) {
        this.partnerId = partnerId;
        this.userName = userName;
        this.passWord = passWord;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.organization = organization;
        this.type = type;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public int isType() {
        return type;
    }
}
