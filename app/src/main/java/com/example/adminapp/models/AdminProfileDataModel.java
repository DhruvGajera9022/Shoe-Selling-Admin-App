package com.example.adminapp.models;

public class AdminProfileDataModel {

    String fName, lName, email;

    public AdminProfileDataModel() {
    }

    public AdminProfileDataModel(String fName, String email, String lName) {
        this.fName = fName;
        this.email = email;
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
