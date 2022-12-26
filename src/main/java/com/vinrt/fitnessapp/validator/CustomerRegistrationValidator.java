package com.vinrt.fitnessapp.validator;

import com.vinrt.fitnessapp.model.Customer;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;


public interface CustomerRegistrationValidator extends Function<Customer, CustomerRegistrationValidator.ValidationResult> {

    static CustomerRegistrationValidator isNameValid(){
        return customer -> customer.getFirstName().length()  != 0 && customer.getLastName().length() != 0
                ? ValidationResult.Success : ValidationResult.Name_cannot_be_null;
    }

    static CustomerRegistrationValidator isEmailIdValid() {
        return customer -> customer.getEmailId().contains("@")
                ? ValidationResult.Success :ValidationResult.Email_not_valid;
    }

    static CustomerRegistrationValidator isPhoneNumberValid (){
        return customer ->
                customer.getPhoneNumber().contains("+46") && customer.getPhoneNumber().length() < 12
                        ? ValidationResult.Success : ValidationResult.Phone_number_is_not_valid;
    }

    static CustomerRegistrationValidator isAnAdult () {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 12 ? ValidationResult.Success : ValidationResult.Date_of_birth_is_not_valid;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
         ValidationResult result = this.apply(customer);
         return result.equals(ValidationResult.Success) ? other.apply(customer) : result;
        };
    }


    enum ValidationResult {
        Success,
        Name_cannot_be_null,
        Phone_number_is_not_valid,
        Email_not_valid,
        Date_of_birth_is_not_valid
    }
}
