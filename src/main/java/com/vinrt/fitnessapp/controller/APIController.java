package com.vinrt.fitnessapp.controller;

import com.vinrt.fitnessapp.service.CustomerService;
import com.vinrt.fitnessapp.model.Customer;
import com.vinrt.fitnessapp.validator.CustomerRegistrationValidator;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by vinayraghavtiwari on 28/12/18.
 */
@RestController
@RequestMapping(value = "/workout/app")
public class APIController {

    @Autowired
    private CustomerService memberService;

    private  CustomerRegistrationValidator.ValidationResult isOk;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @ApiOperation(value = " Get All Customers")
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public Set<Customer> findAllCustomers() {
        return memberService.findAllVustomers();
    }

    @ApiOperation(value = " Add Customers")
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addCustomerRecord(@RequestParam String firstName,
                                  @RequestParam String lastName,
                                  @RequestParam String emailId,
                                  @RequestParam String phoneNumber,
                                  @RequestParam String dob) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmailId(emailId.toLowerCase());
        customer.setPhoneNumber(phoneNumber);
        customer.setDob(LocalDate.parse(dob,formatter));
        // Validate the data is correct or not
        isOk = CustomerRegistrationValidator.isNameValid()
                .and(CustomerRegistrationValidator.isEmailIdValid())
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAnAdult())
                .apply(customer);
        if(isOk != CustomerRegistrationValidator.ValidationResult.Success) {
            throw new IllegalStateException("Please, verify your input : " + isOk.name());
        }
        memberService.addCustomerRecord(customer);
    }

    @ApiOperation(value = " Find Customer Id")
    @RequestMapping(method = RequestMethod.GET , value = "/{Id}")
    Customer findById(@PathVariable Integer Id){
        return memberService.findbyId(Id);
    }

    @ApiOperation(value = " Update Customer Record")
    @RequestMapping(method = RequestMethod.PUT , value = "/update/{Id}")
    public void updateCustomerRecord(@PathVariable Integer Id,
                                     @RequestParam String firstName,
                                     @RequestParam String lastName,
                                     @RequestParam String emailId,
                                     @RequestParam String phoneNumber,
                                     @RequestParam LocalDate dob)
    {
        Customer customer = memberService.findbyId(Id);
                if(firstName!=null)
                    customer.setFirstName(firstName);
                if(lastName!=null)
                    customer.setLastName(lastName);
                if(emailId!=null)
                    customer.setEmailId(emailId);
                if(phoneNumber!=null)
                    customer.setPhoneNumber(phoneNumber);
                if(dob!=null)
                    customer.setDob(dob);
                memberService.updateCustomerRecord(customer);

    }
    @ApiOperation(value = " Delete Customer Record")
    @RequestMapping(method = RequestMethod.DELETE , value = "/delete/{Id}")
    public boolean deleteCustomer(@PathVariable Integer Id){
       memberService.deleteRecord(Id);
       return true;
    }
}