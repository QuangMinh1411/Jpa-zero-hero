package com.heaven.propertymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS_TABLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String houseNo;
    private String street;
    private String city;
    private String postalCode;
    private String country;
    @OneToOne
    @JoinColumn(name = "USER_ID",nullable = false)
    private UserEntity userEntity;
}
