package com.vinrt.fitnessapp.service;

import com.vinrt.fitnessapp.model.Customer;

import java.util.*;

/**
 * Created by vinayraghavtiwari on 30/11/18.
 */
public interface CustomerService {

    void addCustomerRecord(Customer customer);

    boolean updateCustomerRecord(Customer customer);

    boolean deleteRecord(Integer Id);

    Customer findbyId(Integer Id);

    Set<Customer> findAllVustomers();
}
