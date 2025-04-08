package com.vinrt.fitnessapp.service;

import com.vinrt.fitnessapp.exceptionhandler.ResourceFoundException;
import com.vinrt.fitnessapp.model.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by vinayraghavtiwari on 30/11/18.
 */

@Service
public class CustomerServiceImplementation implements CustomerService {

    Set<Customer> members = new HashSet<>();


    @Override
    public void addCustomerRecord(Customer newCustomer) {
        if(members.contains(newCustomer)) {
            throw new ResourceFoundException("Customer with " + newCustomer.getFirstName() + " already exists");
        }
        else {
            members.add(newCustomer);
            newCustomer.setId(members.size() + 1);
        }
    }

    @Override
    public boolean updateCustomerRecord(Customer customer) {

        for(Customer cust : members){
            if(cust.getId().equals(customer.getId()))
            {
                cust.setFirstName(customer.getFirstName());
                cust.setLastName(customer.getLastName());
                cust.setEmailId(customer.getEmailId());

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteRecord(Integer Id) {
        for(Customer cust : members){
            if(cust.getId().equals(Id))
                members.remove(cust);
                return true;
        }
        return false;
    }

    @Override
    public Customer findbyId(Integer Id) {
        for(Customer cus: members){
            if(cus.getId().equals(Id)){
                return cus;
            }
        }
        return null;
    }

    @Override
    public Set<Customer> findAllVustomers() {
        return members;
    }
}
