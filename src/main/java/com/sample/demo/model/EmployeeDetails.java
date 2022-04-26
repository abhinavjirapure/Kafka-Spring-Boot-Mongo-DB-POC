package com.sample.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EmployeeData")
public class EmployeeDetails {
//    @Id
//    private int empId;
    private String firstName;
    private String lastName;
    private String address;
    private String country;
    private int zip;
    private String nationalID;
    //private String DOB;

//    public int getEmpId() {
//        return empId;
//    }
//
//    public void setEmpId(int empId) {
//        this.empId = empId;
//    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

//    public String getDOB() {
//        return DOB;
//    }
//
//    public void setDOB(String DOB) {
//        this.DOB = DOB;
//    }
}
