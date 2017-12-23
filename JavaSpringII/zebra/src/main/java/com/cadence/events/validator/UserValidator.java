package com.cadence.events.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cadence.events.models.User;

@Component
public class UserValidator implements Validator {
    
    //    1
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }         
        if (!EmailValidator.getInstance().isValid(user.getEmail())) {
        	errors.rejectValue("email", "InvalidEmail");
        }


    }
    
   
}