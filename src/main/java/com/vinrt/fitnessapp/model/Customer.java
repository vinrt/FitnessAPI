package com.vinrt.fitnessapp.model;

import io.swagger.annotations.ApiModelProperty;

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
    @ApiModelProperty(notes = "Customer Emailid")
    private String emailId;


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

        if (Id != customer.Id) return false;
        if (!firstName.equals(customer.firstName)) return false;
        if (!lastName.equals(customer.lastName)) return false;
        return emailId.equals(customer.emailId);
    }

    @Override
    public int hashCode() {
        int result = (int) (Id ^ (Id >>> 32));
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + emailId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
