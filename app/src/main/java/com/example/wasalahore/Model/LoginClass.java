package com.example.wasalahore.Model;

public class LoginClass {

    String emailaddress;
    String password;
    long typeid;


    public LoginClass(String emailaddress, String password, long typeid) {
        this.emailaddress = emailaddress;
        this.password = password;
        this.typeid = typeid;
    }

    public LoginClass() {
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getTypeid() {
        return typeid;
    }

    public void setTypeid(long typeid) {
        this.typeid = typeid;
    }
}
