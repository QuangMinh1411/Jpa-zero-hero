package com.heaven.propertymanagement.dto;

import lombok.Data;

@Data
public class PropertyDTO {
    private Long id;
    private String title;
    private String description;

    private Double price;
    private String address;

}
