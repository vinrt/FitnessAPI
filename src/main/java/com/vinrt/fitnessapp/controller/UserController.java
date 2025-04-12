package com.vinrt.fitnessapp.controller;


import com.vinrt.fitnessapp.model.User;
import com.vinrt.fitnessapp.service.UserServiceInt;
import com.vinrt.fitnessapp.validator.CustomerRegistrationValidator;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "/workout/app")
public class UserController {

    private final UserServiceInt userServiceInt;

    private  CustomerRegistrationValidator.ValidationResult isOk;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public UserController(UserServiceInt userServiceInt) {
        this.userServiceInt = userServiceInt;
    }

    @ApiOperation(value = " Add Users")
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addCustomerRecord(@RequestParam String firstName,
                                  @RequestParam String lastName,
                                  @RequestParam String emailId,
                                  @RequestParam String phoneNumber,
                                  @RequestParam String dob) {
        User customer = new User(firstName,lastName,emailId,phoneNumber,LocalDate.parse(dob,formatter));
        // Validate the data is correct or not
        isOk = CustomerRegistrationValidator.isNameValid()
                .and(CustomerRegistrationValidator.isEmailIdValid())
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAnAdult())
                .apply(customer);
        if(isOk != CustomerRegistrationValidator.ValidationResult.Success) {
            throw new IllegalStateException("Please, verify your input : " + isOk.name());
        }
        userServiceInt.addUser(customer);
    }

    private Integer createId(int n) {
        return n*n+1;
    }
}
