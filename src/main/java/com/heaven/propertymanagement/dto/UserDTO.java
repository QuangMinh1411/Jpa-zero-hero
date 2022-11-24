package com.heaven.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;
    private String ownerName;
    @NotBlank(message = "Email is mandatory")
    @Size(min = 1,max = 50,message = "Email length should between 1 and 50")
    private String ownerEmail;
    private String phone;
    @NotBlank(message = "Password is mandatory")

    private String password;

    private String houseNo;
    private String street;
    private String city;
    private String postalCode;
    private String country;
}
