package com.cadence.events.validator;

import java.util.Date;

import org.apache.commons.validator.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cadence.events.models.Event;

@Component
public class EventValidator implements Validator {
    
    //    1
    @Override
    public boolean supports(Class<?> clazz) {
        return Event.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object object, Errors errors) {
        Event event = (Event) object;
        
        if (event.getDate().before(new Date())) {
        	errors.rejectValue("date", "tooEarly");
        }
        
    }
    
   
}