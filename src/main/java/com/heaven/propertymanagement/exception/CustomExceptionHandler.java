package com.heaven.propertymanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleFieldException(MethodArgumentNotValidException mex){
        List<ErrorModel> errorModels = new ArrayList<>();
        List<FieldError> fieldErrors = mex.getBindingResult().getFieldErrors();
        fieldErrors.forEach(fe->{
            logger.debug("Inside field validation {} - {}",fe.getField(),fe.getDefaultMessage());
            logger.info("Inside field validation {} - {}",fe.getField(),fe.getDefaultMessage());
            errorModels.add(new ErrorModel(fe.getField(),fe.getDefaultMessage()));
        });
        return new ResponseEntity<>(errorModels,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler()
    public ResponseEntity<?> handleBusinessException(BusinessException bex){
        for (ErrorModel err:bex.getErrors()){
            logger.debug("Business error throw {} - {}",err.getCode(),err.getMessage());
            logger.info("Business error throw -level info {} - {}",err.getCode(),err.getMessage());
            logger.warn("Business error throw -level warning {} - {}",err.getCode(),err.getMessage());

        }

        return new ResponseEntity<>(bex.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
