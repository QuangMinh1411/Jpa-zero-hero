package com.heaven.propertymanagement.controller;

import com.heaven.propertymanagement.dto.UserDTO;
import com.heaven.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO){
        userDTO = userService.register(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO){
        userDTO = userService.login(userDTO.getOwnerEmail(),userDTO.getPassword());
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }
}
