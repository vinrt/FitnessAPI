package com.vinrt.fitnessapp.controller;

import com.vinrt.fitnessapp.service.CustomerService;
import com.vinrt.fitnessapp.model.Customer;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by vinayraghavtiwari on 28/12/18.
 */
@RestController
@RequestMapping(value = "/workout/app")
public class APIController {

    @Autowired
    private CustomerService customergymrecord;

    @ApiOperation(value = " Get All Customers")
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public Set<Customer> findAllCustomers() {
        return customergymrecord.findAllVustomers();
    }

    @ApiOperation(value = " Add Customers")
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addCustomerRecord(@RequestParam String firstName,
                                  @RequestParam String lastName,
                                  @RequestParam String emailId) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmailId(emailId);
        customergymrecord.addCustomerRecord(customer);
    }

    @ApiOperation(value = " Find Customer Id")
    @RequestMapping(method = RequestMethod.GET , value = "/{Id}")
    Customer findById(@PathVariable Integer Id){
        return customergymrecord.findbyId(Id);
    }

    @ApiOperation(value = " Update Customer Record")
    @RequestMapping(method = RequestMethod.PUT , value = "/update/{Id}")
    public void updateCustomerRecord(@PathVariable Integer Id,
                                     @RequestParam String firstName,
                                     @RequestParam String lastName,
                                     @RequestParam String emailId)
    {
        Customer customer = customergymrecord.findbyId(Id);
                if(firstName!=null)
                    customer.setFirstName(firstName);
                if(lastName!=null)
                    customer.setLastName(lastName);
                if(emailId!=null)
                    customer.setEmailId(emailId);
                customergymrecord.updateCustomerRecord(customer);

    }
    @ApiOperation(value = " Delete Customer Record")
    @RequestMapping(method = RequestMethod.DELETE , value = "/delete/{Id}")
    public boolean deleteCustomer(@PathVariable Integer Id){
       customergymrecord.deleteRecord(Id);
       return true;
    }
}