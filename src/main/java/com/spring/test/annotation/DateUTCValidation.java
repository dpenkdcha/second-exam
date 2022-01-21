package com.spring.test.annotation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DateUTCValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface DateUTCValidation {
    String message() default "This field is mandatory and the format must be YYYY-MM-DD'T'HH:MM:SS'Z' (UTC Format)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
