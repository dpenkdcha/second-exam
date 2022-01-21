package com.spring.test.handler;


import com.spring.test.dtos.errors.Details;
import com.spring.test.dtos.errors.ErrorResponse;
import com.spring.test.dtos.errors.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionResponse {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity handlerForInvalidRequestDetails(MethodArgumentNotValidException ex) {

        final String ERROR_CODE_MESSAGE = "incorrect_value";
        final String ERROR_TYPE = "VALIDATION_FAILED";
        final String ERROR_DESC = "One or more fields specified in the request failed validation";

        List<Details> detailsList = ex.getBindingResult()
                .getFieldErrors().stream()
                .map(errors -> new Details(errors.getField(),ERROR_CODE_MESSAGE,errors.getDefaultMessage()))
                .collect(Collectors.toList());

        List<Errors> errorsList = new ArrayList<>();
        errorsList.add(new Errors(ERROR_TYPE, ERROR_DESC, detailsList));

        return new ResponseEntity(new ErrorResponse("", errorsList), HttpStatus.BAD_REQUEST);

    }


}
