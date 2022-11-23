package com.heaven.propertymanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException{
    private List<ErrorModel> errors;
}
