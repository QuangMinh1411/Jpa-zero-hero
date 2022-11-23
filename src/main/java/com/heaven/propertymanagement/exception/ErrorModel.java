package com.heaven.propertymanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorModel {
    String code;
    String message;
}
