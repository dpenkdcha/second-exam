package com.spring.test.annotation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUTCValidator implements ConstraintValidator<DateUTCValidation, String> {
    @Override
    public void initialize(DateUTCValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            if(value == null) {
                return false;
            }
            dateFormat.parse(value);
            return true;
        } catch (ParseException e) {
            return false;
        }

    }
}
