package com.vinrt.fitnessapp.model;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by vinayraghavtiwari on 30/11/18.
 */


public class Customer {

    @ApiModelProperty(notes = "Customer Id")
    private Integer Id;
    @ApiModelProperty(notes = "Customer FirstName")
    private String firstName;
    @ApiModelProperty(notes = "Customer LastName")
    private String lastName;
    @ApiModelProperty(notes = "Customer Emailid, should be in lowercase")
    private String emailId;
    @ApiModelProperty(notes = "Customer phoneNumber")
    private String phoneNumber;
    @ApiModelProperty(notes = "Customer DateOfBirth, should be in format dd/MM/yyyy")
    private LocalDate dob;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(Id, customer.Id) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(emailId, customer.emailId) && Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(dob, customer.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, firstName, lastName, emailId, phoneNumber, dob);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dob=" + dob +
                '}';
    }
}
