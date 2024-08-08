package com.example.adminapp.models;

public class AdminProfileDataModel {

    String Address, Email, FirstName, LastName, Mobile, ProfileImage;

    public AdminProfileDataModel() {
    }

    public AdminProfileDataModel(String address, String email, String firstName, String lastName, String mobile, String profileImage) {
        this.Address = address;
        this.Email = email;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Mobile = mobile;
        this.ProfileImage = profileImage;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getProfileImage() {
        return ProfileImage;
    }

    public void setProfileImage(String profileImage) {
        ProfileImage = profileImage;
    }
}
