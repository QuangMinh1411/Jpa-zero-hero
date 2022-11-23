package com.heaven.propertymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleFieldException(MethodArgumentNotValidException mex){
        List<ErrorModel> errorModels = new ArrayList<>();
        List<FieldError> fieldErrors = mex.getBindingResult().getFieldErrors();
        fieldErrors.forEach(fe->{
            errorModels.add(new ErrorModel(fe.getField(),fe.getDefaultMessage()));
        });
        return new ResponseEntity<>(errorModels,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler()
    public ResponseEntity<?> handleBusinessException(BusinessException bex){

        return new ResponseEntity<>(bex.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
