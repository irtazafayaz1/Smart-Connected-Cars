package com.example.wasalahore.Model;

import com.example.wasalahore.RecyclerView.CarDataClass;

import java.util.ArrayList;
import java.util.List;

public class OwnerDataClass {

    String dob;
    String firstname;
    String gender;
    String lastname;
    String maritalstatus;
    String nationality;
    String phoneno;

    public OwnerDataClass(String dob, String firstname, String gender, String lastname, String maritalstatus, String nationality, String phoneno) {
        this.dob = dob;
        this.firstname = firstname;
        this.gender = gender;
        this.lastname = lastname;

        this.maritalstatus = maritalstatus;
        this.nationality = nationality;
        this.phoneno = phoneno;
        //this.cars = cars;
    }

    public OwnerDataClass() {
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }


}
